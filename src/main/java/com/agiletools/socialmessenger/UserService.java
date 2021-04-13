package com.agiletools.socialmessenger;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private static final String EMAIL_NOT_EXISTS = "Email não cadastrado";
    private static final String INVALID_PASSWORD = "Senha inválida";
    private static final String PAYMENT_EXPIRED = "Pagamento não realizado";

    public Flux<User> listUsers() {
        return repository.findAll();
    }


    public Mono<LoginResponse> login(LoginRequest request) {
        return Mono.just(request)
                .flatMap(req -> repository.findByEmail(req.getEmail()))
                .switchIfEmpty(Mono.error(new IllegalStateException(EMAIL_NOT_EXISTS)))
                .flatMap(user -> {
                    if( Objects.nonNull(user.getPassword()) && user.getPassword().length()>0) {
                        return Mono.just(user)
                                .filter(usr -> passwordEncoder.matches(request.getPassword(), usr.getPassword()))
                                .switchIfEmpty(Mono.error(new IllegalStateException(INVALID_PASSWORD)));
                    }else {
                        user.setPassword(passwordEncoder.encode(request.getPassword()));
                        return repository.save(user);
                    }
                })
                .filter(user -> user.getValidationDate().isAfter(LocalDateTime.now()))
                .switchIfEmpty(Mono.error(new IllegalStateException(PAYMENT_EXPIRED)))
                .doOnNext(u -> u.setLastLogin(LocalDateTime.now()))
                .doOnNext(u -> request.setName(u.getName()))
                .flatMap(repository::save).doOnSuccess(u -> u.setLastLogin(LocalDateTime.now()))
                .map(user ->  LoginResponse.builder()
                                    .token("012456")
                                    .userName(user.getName())
                                    .expiresIn(3600)
                                    .build())

                ;
    }

}


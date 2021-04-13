package com.agiletools.socialmessenger;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {


    private final UserRepository repository;

    public Flux<User> listUsers() {
        return repository.findAll();
    }



}


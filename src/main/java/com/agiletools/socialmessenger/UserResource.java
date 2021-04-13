package com.agiletools.socialmessenger;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "${application.website}", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserResource {

    private final UserService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<User> listUsers() {
        return service.listUsers();
    }

    @PostMapping(path = "/login")
    public Mono<LoginResponse> login(@RequestBody LoginRequest request)  {
        return service.login(request);
    }

}

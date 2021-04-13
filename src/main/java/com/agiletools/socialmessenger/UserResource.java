package com.agiletools.socialmessenger;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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


}

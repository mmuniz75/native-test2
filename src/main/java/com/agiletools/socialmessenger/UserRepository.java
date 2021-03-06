package com.agiletools.socialmessenger;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

    public Mono<User> findByEmail(String email);

}




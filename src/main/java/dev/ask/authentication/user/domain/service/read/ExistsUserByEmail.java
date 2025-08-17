package dev.ask.authentication.user.domain.service.read;

import reactor.core.publisher.Mono;

public interface ExistsUserByEmail {
    Mono<Boolean> existsUserByEmail(String email);
}
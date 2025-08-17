package dev.ask.authentication.user.domain.service.read;

import reactor.core.publisher.Mono;

public interface ExistsUserByPhoneNumber {
    Mono<Boolean> existsUserByPhoneNumber(String phoneNumber);
}
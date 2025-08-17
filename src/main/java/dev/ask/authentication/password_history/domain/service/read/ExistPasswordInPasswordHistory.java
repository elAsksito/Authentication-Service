package dev.ask.authentication.password_history.domain.service.read;

import reactor.core.publisher.Mono;

public interface ExistPasswordInPasswordHistory {
    Mono<Boolean> existPasswordInPasswordHistory(String userId, String passwordHash);
}
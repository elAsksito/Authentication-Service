package dev.ask.authentication.password_history.domain.service.create;

import dev.ask.authentication.password_history.domain.model.PasswordHistory;
import reactor.core.publisher.Mono;

public interface CreatePasswordHistory {
    Mono<PasswordHistory> createPasswordHistory(String userId, String passwordHash);
}
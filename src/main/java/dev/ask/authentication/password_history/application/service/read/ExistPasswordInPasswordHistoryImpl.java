package dev.ask.authentication.password_history.application.service.read;

import org.springframework.stereotype.Service;

import dev.ask.authentication.password_history.domain.repository.PasswordHistoryRepository;
import dev.ask.authentication.password_history.domain.service.read.ExistPasswordInPasswordHistory;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ExistPasswordInPasswordHistoryImpl implements ExistPasswordInPasswordHistory{

    private final PasswordHistoryRepository repository;

    @Override
    public Mono<Boolean> existPasswordInPasswordHistory(String userId, String passwordHash) {
        return repository.isPasswordUsed(userId, passwordHash);
    }
}
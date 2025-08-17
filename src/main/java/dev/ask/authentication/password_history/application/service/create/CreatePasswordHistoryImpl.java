package dev.ask.authentication.password_history.application.service.create;

import java.time.Instant;

import org.springframework.stereotype.Service;

import dev.ask.authentication.password_history.domain.model.PasswordHistory;
import dev.ask.authentication.password_history.domain.repository.PasswordHistoryRepository;
import dev.ask.authentication.password_history.domain.service.create.CreatePasswordHistory;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CreatePasswordHistoryImpl implements CreatePasswordHistory{
    
    private final PasswordHistoryRepository repository;
    
    @Override
    public Mono<PasswordHistory> createPasswordHistory(String userId, String passwordHash) {
        PasswordHistory passwordHistory = PasswordHistory.builder()
            .userId(userId)
            .passwordHash(passwordHash)
            .changedAt(Instant.now())
            .build();

        return repository.save(passwordHistory);
    }
}
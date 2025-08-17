package dev.ask.authentication.password_history.infrastructure.port.out.persistence.adapter;

import org.springframework.stereotype.Component;

import dev.ask.authentication.password_history.domain.model.PasswordHistory;
import dev.ask.authentication.password_history.domain.repository.PasswordHistoryRepository;
import dev.ask.authentication.password_history.infrastructure.port.out.persistence.mapper.PasswordHistoryMapper;
import dev.ask.authentication.password_history.infrastructure.port.out.persistence.repository.ReactivePasswordHistoryMongoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PasswordHistoryRepositoryAdapter implements PasswordHistoryRepository {

    private final ReactivePasswordHistoryMongoRepository repository;

    @Override
    public Mono<PasswordHistory> save(PasswordHistory passwordHistory) {
        return repository.save(PasswordHistoryMapper.toDocument(passwordHistory))
                .map(PasswordHistoryMapper::toDomain);
    }

    @Override
    public Mono<Boolean> isPasswordUsed(String userId, String passwordHash) {
        return repository.existsByUserIdAndPasswordHash(userId, passwordHash);
    }
    
}
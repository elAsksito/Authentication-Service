package dev.ask.authentication.audit_log.infrastructure.port.out.persistence.adapter;

import org.springframework.stereotype.Component;

import dev.ask.authentication.audit_log.domain.model.AuditLog;
import dev.ask.authentication.audit_log.domain.repository.AuditLogRepository;
import dev.ask.authentication.audit_log.infrastructure.port.out.persistence.mapper.AuditLogMapper;
import dev.ask.authentication.audit_log.infrastructure.port.out.persistence.repository.ReactiveAuditLogMongoRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuditLogRepositoryAdapter implements AuditLogRepository {

    private final ReactiveAuditLogMongoRepository repository;

    @Override
    public Mono<AuditLog> save(AuditLog auditLog) {
        return repository.save(AuditLogMapper.toDocument(auditLog))
            .map(AuditLogMapper::toDomain);
    }
    
}
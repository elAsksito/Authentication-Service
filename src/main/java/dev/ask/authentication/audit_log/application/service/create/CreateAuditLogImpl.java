package dev.ask.authentication.audit_log.application.service.create;

import org.springframework.stereotype.Service;

import dev.ask.authentication.audit_log.domain.model.AuditLog;
import dev.ask.authentication.audit_log.domain.repository.AuditLogRepository;
import dev.ask.authentication.audit_log.domain.service.create.CreateAuditLog;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateAuditLogImpl implements CreateAuditLog {

    private final AuditLogRepository repository;

    @Override
    public Mono<AuditLog> createAuditLog(AuditLog auditLog) {
        return repository.save(auditLog);
    }
    
}
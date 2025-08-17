package dev.ask.authentication.audit_log.infrastructure.port.out.persistence.document;

import java.time.Instant;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.ask.authentication.audit_log.domain.enums.Actions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "audit_log")
public class AuditLogDocument {
    @Id
    private String id;
    private String userId;
    private Actions action;
    private Map<String, Object> metadata;
    private String ipAddress;
    private String userAgent;
    private Instant createdAt;
}
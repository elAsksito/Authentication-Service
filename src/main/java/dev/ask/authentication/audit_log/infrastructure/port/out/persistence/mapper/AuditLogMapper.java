package dev.ask.authentication.audit_log.infrastructure.port.out.persistence.mapper;

import org.springframework.beans.BeanUtils;

import dev.ask.authentication.audit_log.domain.model.AuditLog;
import dev.ask.authentication.audit_log.infrastructure.port.out.persistence.document.AuditLogDocument;

public class AuditLogMapper {
    public static AuditLog toDomain(AuditLogDocument doc){
        if(doc == null) return null;
        AuditLog auditLog = new AuditLog();
        BeanUtils.copyProperties(doc, auditLog);
        return auditLog;
    }
    
    public static AuditLogDocument toDocument(AuditLog auditLog){
        if(auditLog == null) return null;
        AuditLogDocument document = new AuditLogDocument();
        BeanUtils.copyProperties(auditLog, document);
        return document;
    }
}
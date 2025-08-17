package dev.ask.authentication.password_history.infrastructure.port.out.persistence.mapper;

import org.springframework.beans.BeanUtils;

import dev.ask.authentication.password_history.domain.model.PasswordHistory;
import dev.ask.authentication.password_history.infrastructure.port.out.persistence.document.PasswordHistoryDocument;

public class PasswordHistoryMapper {
    public static PasswordHistory toDomain(PasswordHistoryDocument doc){
        if(doc == null) return null;
        PasswordHistory passwordHistory = new PasswordHistory();
        BeanUtils.copyProperties(doc, passwordHistory);
        return passwordHistory;
    }
    
    public static PasswordHistoryDocument toDocument(PasswordHistory passwordHistory){
        if(passwordHistory == null) return null;
        PasswordHistoryDocument document = new PasswordHistoryDocument();
        BeanUtils.copyProperties(passwordHistory, document);
        return document;
    }
}
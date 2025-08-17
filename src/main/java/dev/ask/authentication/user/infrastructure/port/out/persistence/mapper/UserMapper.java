package dev.ask.authentication.user.infrastructure.port.out.persistence.mapper;


import dev.ask.authentication.user.domain.model.User;
import dev.ask.authentication.user.infrastructure.port.out.persistence.document.UserDocument;

public class UserMapper {

    public static User toDomain(UserDocument doc) {
        if (doc == null) return null;
        return User.builder()
                .id(doc.getId())
                .email(doc.getEmail())
                .phoneNumber(doc.getPhoneNumber())
                .password(doc.getPassword())
                .isEmailVerified(doc.isEmailVerified())
                .status(doc.getStatus())
                .failedLoginAttempts(doc.getFailedLoginAttempts())
                .lockUntil(doc.getLockUntil())
                .twoFaEnabled(doc.isTwoFaEnabled())
                .twoFaSecret(doc.getTwoFaSecret())
                .lastLogin(doc.getLastLogin())
                .createdAt(doc.getCreatedAt())
                .updatedAt(doc.getUpdatedAt())
                .version(doc.getVersion())
                .passwordLastChanged(doc.getPasswordLastChanged())
                .mustChangePassword(doc.isMustChangePassword())
                .roles(doc.getRoles())
                .build();
    }

    public static UserDocument toDocument(User user) {
        if (user == null) return null;
        return UserDocument.builder()
                .id(user.getId())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .password(user.getPassword())
                .isEmailVerified(user.isEmailVerified())
                .status(user.getStatus())
                .failedLoginAttempts(user.getFailedLoginAttempts())
                .lockUntil(user.getLockUntil())
                .twoFaEnabled(user.isTwoFaEnabled())
                .twoFaSecret(user.getTwoFaSecret())
                .lastLogin(user.getLastLogin())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .version(user.getVersion())
                .passwordLastChanged(user.getPasswordLastChanged())
                .mustChangePassword(user.isMustChangePassword())
                .roles(user.getRoles())
                .build();
    }
}
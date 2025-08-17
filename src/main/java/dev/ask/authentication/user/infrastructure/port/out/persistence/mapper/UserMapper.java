package dev.ask.authentication.user.infrastructure.port.out.persistence.mapper;


import org.springframework.beans.BeanUtils;

import dev.ask.authentication.user.domain.model.User;
import dev.ask.authentication.user.infrastructure.port.out.persistence.document.UserDocument;

public class UserMapper {

    public static User toDomain(UserDocument doc) {
        if (doc == null) return null;
        User user = new User();
        BeanUtils.copyProperties(doc, user);
        return user;
    }

    public static UserDocument toDocument(User user) {
        if (user == null) return null;
        UserDocument document = new UserDocument();
        BeanUtils.copyProperties(user, document);
        return document;
    }
}
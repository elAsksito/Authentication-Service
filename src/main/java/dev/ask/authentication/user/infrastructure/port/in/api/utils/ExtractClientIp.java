package dev.ask.authentication.user.infrastructure.port.in.api.utils;

import java.util.Optional;

import org.springframework.http.server.reactive.ServerHttpRequest;

public class ExtractClientIp {
    public static String extractClientIp(ServerHttpRequest request) {
        String xForwardedFor = request.getHeaders().getFirst("X-Forwarded-For");
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            return xForwardedFor.split(",")[0];
        }
        return Optional.ofNullable(request.getRemoteAddress())
            .map(addr -> addr.getAddress().getHostAddress())
            .orElse("IDK Man");
    }
}
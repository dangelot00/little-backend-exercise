package com.exercise.headermirror.service;

import com.exercise.headermirror.data.UserAgentInfo;
import com.exercise.headermirror.dbmodel.entity.UserAgentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.headermirror.dbmodel.repository.UserAgentRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAgentService {

    @Autowired
    private UserAgentRepository repository;

    public void saveOrUpdateUserAgent(String userAgent) {
        String hash = generateHash(userAgent);
        UserAgentInfo info = repository.findById(hash)
                                       .map(entity -> new UserAgentInfo(entity.getUaHash(), entity.getUserAgent(), entity.getLastUpdated()))
                                       .orElse(new UserAgentInfo());

        info.setUaHash(hash);
        info.setUserAgent(userAgent);
        info.setLastUpdated(Instant.now());

        repository.save(new UserAgentEntity(info.getUaHash(), info.getUserAgent(), info.getLastUpdated()));

    }

    public List<UserAgentInfo> getLastTenUserAgents() {
        return repository.findAll().stream()
                         .sorted((a, b) -> b.getLastUpdated().compareTo(a.getLastUpdated()))
                         .limit(10)
                         .map(entity -> new UserAgentInfo(entity.getUaHash(), entity.getUserAgent(), entity.getLastUpdated()))
                         .collect(Collectors.toList());
    }

    private String generateHash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate hash", e);
        }
    }
}

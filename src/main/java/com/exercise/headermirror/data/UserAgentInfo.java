package com.exercise.headermirror.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAgentInfo {
    private String uaHash;
    private String userAgent;
    private Instant lastUpdated;
}
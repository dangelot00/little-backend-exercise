package com.exercise.headermirror.dbmodel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserAgentEntity {

    @Id
    @Column(name = "ua_hash")
    private String uaHash;

    @Column(name = "user_agent")
    private String userAgent;

    @Column(name = "last_updated")
    private Instant lastUpdated;

}

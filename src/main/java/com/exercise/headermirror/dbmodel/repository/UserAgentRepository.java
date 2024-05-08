package com.exercise.headermirror.dbmodel.repository;

import com.exercise.headermirror.dbmodel.entity.UserAgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAgentRepository extends JpaRepository<UserAgentEntity, String> {

}
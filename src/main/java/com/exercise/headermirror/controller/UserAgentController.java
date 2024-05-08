package com.exercise.headermirror.controller;

import com.exercise.headermirror.data.UserAgentInfo;
import com.exercise.headermirror.service.UserAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/useragents")
public class UserAgentController {

    @Autowired
    private UserAgentService userAgentService;

    @PostMapping
    public ResponseEntity<?> captureUserAgent(@RequestHeader("User-Agent") String userAgent) {
        userAgentService.saveOrUpdateUserAgent(userAgent);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UserAgentInfo>> getUserAgents() {
        return ResponseEntity.ok(userAgentService.getLastTenUserAgents());
    }
}
package com.exercise.headermirror.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@RestController
public class HeaderMirrorController {

    @GetMapping("/headers/mirror")
    public ResponseEntity<Map<String, String>> mirrorHeaders(@RequestHeader HttpHeaders headers) {
        Map<String, String> headerMap = headers.toSingleValueMap();
        return ResponseEntity.ok(headerMap);
    }
}
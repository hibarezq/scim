package com.scim.demo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value =  "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class ScimController {
	
	@GetMapping(value = "/loggedOnUser")
	public ResponseEntity<Void> findById() {
		return ResponseEntity.noContent().build();
	}
}

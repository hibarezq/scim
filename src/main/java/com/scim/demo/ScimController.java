package com.scim.demo;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value =  "/v1/scim", produces = {MediaType.APPLICATION_JSON_VALUE,"application/scim+json"})
public class ScimController {
	private static final Logger logger = LoggerFactory.getLogger(ScimController.class);
	
	@GetMapping(value = "/Users")
	public ResponseEntity<UserResponse> findById(@RequestParam(required = false) String filter,@RequestParam(required = false) Integer startIndex,@RequestParam(required = false) Integer count) {
		logger.info("enter get rest");
		
		UserResponse response= UserResponse.builder().build();
		
		
		return ResponseEntity.ok(UserResponse.builder().schemas(List.of("urn:ietf:params:scim:api:messages:2.0:ListResponse")).totalResults(0).startIndex(1).itemsPerPage(0).Resources(List.of()).build());
	}
	/*
	@GetMapping(value = "/Users")
	public ResponseEntity<UserResponse> findById(@RequestParam(required = false) String filter) {
		logger.info("enter get rest");
		CreateUserResponse responsee= CreateUserResponse.builder().id("hiba.rezquellah@cpexterne.org").active(true).build();
		
		UserResponse response= UserResponse.builder().startIndex(1).totalResults(1).itemsPerPage(0).Resources(List.of(responsee)).build();
		
		return ResponseEntity.ok().body(response);
	}*/
	
	@GetMapping(value = "/Users/{userName}")
	public ResponseEntity<CreateUserResponse> findByIdd(@PathVariable String userName) {
		logger.info("enter get rest");
		CreateUserResponse responsee= CreateUserResponse.builder().schemas(List.of("")).id("hiba.rezquellah@cpexterne.org").build();
		
		
		return ResponseEntity.ok(responsee);
	}

	@PostMapping(value = "/Users")
	public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
		logger.info("enter post rest");
		logger.info(request.isActive()+" hiba");
		CreateUserResponse response= CreateUserResponse.builder().schemas(request.getSchemas()).id(request.getUserName()).active(true).build();
		logger.info(request.getCreatedBy()+" hiba");
		//request1.setId("hiba.rezquellah@cpexterne.org");
		return ResponseEntity.created(URI.create(String.format("/users/%s", request.getUserName()))).body(response);
	}
	
	@PutMapping(value = "/Users/{userName}")
	public ResponseEntity<CreateUserResponse> updateUser(@RequestBody CreateUserRequest request) {
		logger.info("enter put rest");
		logger.info(request.isActive()+" hiba");
		CreateUserResponse response= CreateUserResponse.builder().id(request.getUserName()).build();
		//CreateUserResponse response= CreateUserResponse.builder().schemas(request.getSchemas())
		//		.userName(request.getUserName()).name(request.getName()).emails(request.getEmails()).profileDetails(request.getProfileDetails()).build();
		logger.info(request+" hiba");
		return ResponseEntity.ok(response);
	}
}

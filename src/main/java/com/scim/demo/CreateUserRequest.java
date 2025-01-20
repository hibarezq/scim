package com.scim.demo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateUserRequest {
	private List<String> schemas;
	private String userName;
	private Name name;
	private List<MultiValued> emails;
	private List<String> profileDetails;
	private boolean active;
	private String createdBy;
}

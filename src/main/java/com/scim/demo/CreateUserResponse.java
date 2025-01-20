package com.scim.demo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateUserResponse {
	private List<String> schemas;
	private String id;
	private String userName;
	private boolean active;
}

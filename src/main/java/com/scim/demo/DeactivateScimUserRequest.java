package com.scim.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public record DeactivateScimUserRequest(@JsonProperty("Operations") List<Operation> operations) {
	
	@Builder
	public static record Operation(@JsonProperty("value") Value value) {
		
		@Builder
		public static record Value(@JsonProperty("active") boolean active) {
		}
	}
}

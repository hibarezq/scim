package com.scim.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Name {
	private String givenName;
	private String familyName;
}

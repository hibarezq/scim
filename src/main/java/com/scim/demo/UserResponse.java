package com.scim.demo;

import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserResponse {
	private Object schemas;
	private int totalResults;
	private int startIndex;
	private int itemsPerPage;
	private Object Resources;
}

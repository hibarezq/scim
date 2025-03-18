package com.scim.demo;

import java.util.List;

import lombok.Builder;

@Builder
public record ScimUser(List<String> schemas, String id, String userName, boolean active) {
}

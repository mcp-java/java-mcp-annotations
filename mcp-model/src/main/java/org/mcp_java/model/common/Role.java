/*
 * Copyright 2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mcp_java.model.common;

/**
 * The role of a message sender in a conversation.
 *
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/schema#role">MCP Specification - Role</a>
 */
public enum Role {
    /**
     * Messages from the user/human.
     */
    USER("user"),

    /**
     * Messages from the AI assistant.
     */
    ASSISTANT("assistant");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    /**
     * Gets the string value of this role.
     *
     * @return the role value
     */
    public String getValue() {
        return value;
    }

    /**
     * Parses a role from its string value.
     *
     * @param value the string value
     * @return the corresponding Role
     * @throws IllegalArgumentException if the value is not recognized
     */
    public static Role fromValue(String value) {
        for (Role role : values()) {
            if (role.value.equals(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown role: " + value);
    }
}

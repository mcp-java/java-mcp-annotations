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
package org.mcp_java.model.lifecycle;

/**
 * Information about an MCP implementation.
 *
 * @param name    the name of the implementation
 * @param version the version of the implementation
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic/lifecycle#initialization">MCP Specification - Initialization</a>
 */
public record Implementation(
    String name,
    String version
) {

    /**
     * Creates a new implementation info.
     */
    public Implementation {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Implementation name cannot be null or blank");
        }
        if (version == null || version.isBlank()) {
            throw new IllegalArgumentException("Implementation version cannot be null or blank");
        }
    }

    /**
     * Creates implementation info.
     *
     * @param name    the implementation name
     * @param version the implementation version
     * @return new implementation info
     */
    public static Implementation of(String name, String version) {
        return new Implementation(name, version);
    }
}

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
package org.mcp_java.model.tool;

import java.util.Map;

/**
 * Request to call a tool.
 *
 * @param name      the name of the tool to call
 * @param arguments the arguments to pass to the tool (optional)
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/tools/#call-tool-request">MCP Specification - Call Tool Request</a>
 */
public record CallToolRequest(
    String name,
    Map<String, Object> arguments
) {

    /**
     * Creates a new call tool request.
     */
    public CallToolRequest {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Tool name cannot be null or blank");
        }
    }

    /**
     * Creates a call tool request with arguments.
     *
     * @param name      the tool name
     * @param arguments the tool arguments
     * @return new request
     */
    public static CallToolRequest of(String name, Map<String, Object> arguments) {
        return new CallToolRequest(name, arguments);
    }

    /**
     * Creates a call tool request without arguments.
     *
     * @param name the tool name
     * @return new request
     */
    public static CallToolRequest of(String name) {
        return new CallToolRequest(name, null);
    }
}

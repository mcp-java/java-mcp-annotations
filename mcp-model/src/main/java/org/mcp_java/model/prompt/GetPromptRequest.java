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
package org.mcp_java.model.prompt;

import java.util.Map;

/**
 * Request to get a prompt.
 *
 * @param name      the name of the prompt
 * @param arguments the arguments to pass to the prompt (optional)
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/prompts/#get-prompt-request">MCP Specification - Get Prompt Request</a>
 */
public record GetPromptRequest(
    String name,
    Map<String, String> arguments
) {

    /**
     * Creates a new get prompt request.
     */
    public GetPromptRequest {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Prompt name cannot be null or blank");
        }
    }

    /**
     * Creates a get prompt request with arguments.
     *
     * @param name      the prompt name
     * @param arguments the prompt arguments
     * @return new request
     */
    public static GetPromptRequest of(String name, Map<String, String> arguments) {
        return new GetPromptRequest(name, arguments);
    }

    /**
     * Creates a get prompt request without arguments.
     *
     * @param name the prompt name
     * @return new request
     */
    public static GetPromptRequest of(String name) {
        return new GetPromptRequest(name, null);
    }
}

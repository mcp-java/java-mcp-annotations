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

/**
 * An argument that a prompt can accept.
 *
 * @param name        the name of the argument
 * @param description a description of the argument (optional)
 * @param required    whether this argument is required
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/prompts#getting-a-prompt">MCP Specification - Getting a Prompt</a>
 */
public record PromptArgument(
    String name,
    String description,
    boolean required
) {

    /**
     * Creates a new prompt argument.
     */
    public PromptArgument {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Argument name cannot be null or blank");
        }
    }

    /**
     * Creates a required argument.
     *
     * @param name        the argument name
     * @param description the description
     * @return a new required argument
     */
    public static PromptArgument required(String name, String description) {
        return new PromptArgument(name, description, true);
    }

    /**
     * Creates an optional argument.
     *
     * @param name        the argument name
     * @param description the description
     * @return a new optional argument
     */
    public static PromptArgument optional(String name, String description) {
        return new PromptArgument(name, description, false);
    }
}

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

import java.util.List;

/**
 * A prompt template that can be used to generate messages.
 *
 * @param name        the unique name of the prompt
 * @param description a description of what this prompt does (optional)
 * @param arguments   the arguments this prompt accepts (optional)
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/prompts">MCP Specification - Prompts</a>
 */
public record Prompt(
    String name,
    String description,
    List<PromptArgument> arguments
) {

    /**
     * Creates a new prompt definition.
     */
    public Prompt {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Prompt name cannot be null or blank");
        }
    }

    /**
     * Creates a prompt with all fields.
     *
     * @param name        the prompt name
     * @param description the description
     * @param arguments   the prompt arguments
     * @return a new prompt
     */
    public static Prompt of(String name, String description, List<PromptArgument> arguments) {
        return new Prompt(name, description, arguments);
    }

    /**
     * Creates a prompt with just a name.
     *
     * @param name the prompt name
     * @return a new prompt
     */
    public static Prompt of(String name) {
        return new Prompt(name, null, null);
    }
}

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
 * Result of getting a prompt.
 *
 * @param description a description of the prompt (optional)
 * @param messages    the messages in the prompt
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/prompts/#get-prompt-result">MCP Specification - Get Prompt Result</a>
 */
public record GetPromptResult(
    String description,
    List<PromptMessage> messages
) {

    /**
     * Creates a new prompt result.
     */
    public GetPromptResult {
        if (messages == null || messages.isEmpty()) {
            throw new IllegalArgumentException("Messages cannot be null or empty");
        }
    }

    /**
     * Creates a prompt result with a description.
     *
     * @param description the description
     * @param messages    the messages
     * @return a new prompt result
     */
    public static GetPromptResult of(String description, List<PromptMessage> messages) {
        return new GetPromptResult(description, messages);
    }

    /**
     * Creates a prompt result without a description.
     *
     * @param messages the messages
     * @return a new prompt result
     */
    public static GetPromptResult of(List<PromptMessage> messages) {
        return new GetPromptResult(null, messages);
    }
}

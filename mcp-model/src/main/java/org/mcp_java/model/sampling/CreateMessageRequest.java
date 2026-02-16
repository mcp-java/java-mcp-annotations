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
package org.mcp_java.model.sampling;

import java.util.List;

/**
 * Request to sample/generate a message from an LLM.
 *
 * @param messages         the conversation messages
 * @param modelPreferences optional preferences for model selection
 * @param systemPrompt     optional system prompt
 * @param includeContext   which MCP context to include (e.g., "none", "thisServer", "allServers")
 * @param temperature      sampling temperature (optional)
 * @param maxTokens        maximum tokens to generate
 * @param stopSequences    sequences that stop generation (optional)
 * @param metadata         additional metadata (optional)
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/client/sampling/">MCP Specification - Sampling</a>
 */
public record CreateMessageRequest(
    List<SamplingMessage> messages,
    ModelPreferences modelPreferences,
    String systemPrompt,
    String includeContext,
    Double temperature,
    int maxTokens,
    List<String> stopSequences,
    Object metadata
) {

    /**
     * Creates a new message request.
     */
    public CreateMessageRequest {
        if (messages == null || messages.isEmpty()) {
            throw new IllegalArgumentException("Messages cannot be null or empty");
        }
        if (maxTokens <= 0) {
            throw new IllegalArgumentException("Max tokens must be positive");
        }
        if (temperature != null && (temperature < 0 || temperature > 2)) {
            throw new IllegalArgumentException("Temperature must be between 0 and 2");
        }
    }

    /**
     * Creates a simple message request.
     *
     * @param messages  the messages
     * @param maxTokens maximum tokens
     * @return new request
     */
    public static CreateMessageRequest of(List<SamplingMessage> messages, int maxTokens) {
        return new CreateMessageRequest(messages, null, null, "none", null, maxTokens, null, null);
    }
}

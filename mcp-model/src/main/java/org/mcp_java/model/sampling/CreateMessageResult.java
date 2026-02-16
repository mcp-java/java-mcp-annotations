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

import org.mcp_java.model.content.ContentBlock;
import java.util.List;

/**
 * Result of a message sampling request.
 *
 * @param content     the generated content
 * @param model       the model that was used
 * @param stopReason  why generation stopped (e.g., "endTurn", "maxTokens")
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/client/sampling/#create-message-result">MCP Specification - Create Message Result</a>
 */
public record CreateMessageResult(
    List<ContentBlock> content,
    String model,
    String stopReason
) {

    /**
     * Creates a new message result.
     */
    public CreateMessageResult {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model cannot be null or blank");
        }
    }

    /**
     * Creates a message result.
     *
     * @param content    the generated content
     * @param model      the model used
     * @param stopReason the stop reason
     * @return new result
     */
    public static CreateMessageResult of(List<ContentBlock> content, String model, String stopReason) {
        return new CreateMessageResult(content, model, stopReason);
    }
}

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
package org.mcp_java.server;

import org.mcp_java.model.common.Role;
import org.mcp_java.model.content.ContentBlock;

/**
 * A response to a {@link SamplingRequest}.
 * <p>
 * Contains the sampled content from the client's LLM along with metadata about
 * the model used and why sampling stopped.
 * </p>
 *
 * @param content the sampled content (never null)
 * @param model the name of the model that generated the response (never null)
 * @param role the role of the message sender (never null)
 * @param stopReason the reason why sampling stopped, if known
 *
 * @see SamplingRequest
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/client/sampling">MCP Specification - Sampling</a>
 */
public record SamplingResponse(ContentBlock content, String model, Role role, String stopReason) {

    public SamplingResponse {
        if (content == null) {
            throw new IllegalArgumentException("content must not be null");
        }
        if (model == null) {
            throw new IllegalArgumentException("model must not be null");
        }
        if (role == null) {
            throw new IllegalArgumentException("role must not be null");
        }
    }
}

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

import org.mcp_java.model.common.Role;
import org.mcp_java.model.content.ContentBlock;
import java.util.List;

/**
 * A message in a sampling request or response.
 *
 * @param role    the role of the message sender
 * @param content the content blocks of the message
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/client/sampling/">MCP Specification - Sampling</a>
 */
public record SamplingMessage(
    Role role,
    List<ContentBlock> content
) {

    /**
     * Creates a new sampling message.
     */
    public SamplingMessage {
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }
    }

    /**
     * Creates a user message.
     *
     * @param content the message content
     * @return a new user message
     */
    public static SamplingMessage user(List<ContentBlock> content) {
        return new SamplingMessage(Role.USER, content);
    }

    /**
     * Creates an assistant message.
     *
     * @param content the message content
     * @return a new assistant message
     */
    public static SamplingMessage assistant(List<ContentBlock> content) {
        return new SamplingMessage(Role.ASSISTANT, content);
    }
}

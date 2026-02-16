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

import org.mcp_java.model.content.ContentBlock;
import java.util.List;

/**
 * Result of calling a tool.
 *
 * @param content the result content blocks
 * @param isError whether the tool call resulted in an error
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/tools/#call-tool-result">MCP Specification - Call Tool Result</a>
 */
public record CallToolResult(
    List<ContentBlock> content,
    Boolean isError
) {

    /**
     * Creates a new tool result.
     */
    public CallToolResult {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }
    }

    /**
     * Creates a successful tool result.
     *
     * @param content the result content
     * @return a new success result
     */
    public static CallToolResult success(List<ContentBlock> content) {
        return new CallToolResult(content, false);
    }

    /**
     * Creates an error tool result.
     *
     * @param content the error content
     * @return a new error result
     */
    public static CallToolResult error(List<ContentBlock> content) {
        return new CallToolResult(content, true);
    }
}

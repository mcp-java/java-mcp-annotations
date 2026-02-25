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

import org.mcp_java.model.common.Cursor;
import java.util.List;

/**
 * Result of listing tools.
 *
 * @param tools      the list of available tools
 * @param nextCursor optional cursor for pagination
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/tools/#list-tools-result">MCP Specification - List Tools Result</a>
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/schema#listtoolsresult">MCP Schema Reference - ListToolsResult</a>
 */
public record ListToolsResult(
    List<Tool> tools,
    Cursor nextCursor
) {

    /**
     * Creates a new list tools result.
     */
    public ListToolsResult {
        if (tools == null) {
            throw new IllegalArgumentException("Tools cannot be null");
        }
    }

    /**
     * Creates a result without pagination.
     *
     * @param tools the tools list
     * @return new result
     */
    public static ListToolsResult of(List<Tool> tools) {
        return new ListToolsResult(tools, null);
    }

    /**
     * Creates a result with pagination.
     *
     * @param tools      the tools list
     * @param nextCursor the cursor for next page
     * @return new result
     */
    public static ListToolsResult of(List<Tool> tools, Cursor nextCursor) {
        return new ListToolsResult(tools, nextCursor);
    }
}

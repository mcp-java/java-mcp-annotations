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

/**
 * Request to list available tools.
 *
 * @param cursor optional cursor for pagination
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/tools#listing-tools">MCP Specification - Listing Tools</a>
 */
public record ListToolsRequest(
    Cursor cursor
) {

    /**
     * Creates a list tools request without pagination.
     *
     * @return new request
     */
    public static ListToolsRequest create() {
        return new ListToolsRequest(null);
    }

    /**
     * Creates a list tools request with pagination.
     *
     * @param cursor the pagination cursor
     * @return new request
     */
    public static ListToolsRequest withCursor(Cursor cursor) {
        return new ListToolsRequest(cursor);
    }
}

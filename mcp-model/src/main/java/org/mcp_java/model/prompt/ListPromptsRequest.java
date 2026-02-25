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

import org.mcp_java.model.common.Cursor;

/**
 * Request to list available prompts.
 *
 * @param cursor optional cursor for pagination
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/prompts#listing-prompts">MCP Specification - Listing Prompts</a>
 */
public record ListPromptsRequest(
    Cursor cursor
) {

    /**
     * Creates a list prompts request without pagination.
     *
     * @return new request
     */
    public static ListPromptsRequest create() {
        return new ListPromptsRequest(null);
    }

    /**
     * Creates a list prompts request with pagination.
     *
     * @param cursor the pagination cursor
     * @return new request
     */
    public static ListPromptsRequest withCursor(Cursor cursor) {
        return new ListPromptsRequest(cursor);
    }
}

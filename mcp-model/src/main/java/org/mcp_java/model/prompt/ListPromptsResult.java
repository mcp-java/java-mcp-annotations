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
import java.util.List;

/**
 * Result of listing prompts.
 *
 * @param prompts    the list of available prompts
 * @param nextCursor optional cursor for pagination
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/prompts#listing-prompts">MCP Specification - Listing Prompts</a>
 */
public record ListPromptsResult(
    List<Prompt> prompts,
    Cursor nextCursor
) {

    /**
     * Creates a new list prompts result.
     */
    public ListPromptsResult {
        if (prompts == null) {
            throw new IllegalArgumentException("Prompts cannot be null");
        }
    }

    /**
     * Creates a result without pagination.
     *
     * @param prompts the prompts list
     * @return new result
     */
    public static ListPromptsResult of(List<Prompt> prompts) {
        return new ListPromptsResult(prompts, null);
    }

    /**
     * Creates a result with pagination.
     *
     * @param prompts    the prompts list
     * @param nextCursor the cursor for next page
     * @return new result
     */
    public static ListPromptsResult of(List<Prompt> prompts, Cursor nextCursor) {
        return new ListPromptsResult(prompts, nextCursor);
    }
}

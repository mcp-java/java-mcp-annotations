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
package org.mcp_java.model.roots;

import java.util.List;

/**
 * Result of listing roots.
 *
 * @param roots the list of roots
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/client/roots#listing-roots">MCP Specification - Listing Roots</a>
 */
public record ListRootsResult(
    List<Root> roots
) {

    /**
     * Creates a new list roots result.
     */
    public ListRootsResult {
        if (roots == null) {
            throw new IllegalArgumentException("Roots cannot be null");
        }
    }

    /**
     * Creates a list roots result.
     *
     * @param roots the roots list
     * @return new result
     */
    public static ListRootsResult of(List<Root> roots) {
        return new ListRootsResult(roots);
    }
}

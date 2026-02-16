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
package org.mcp_java.model.resource;

import org.mcp_java.model.common.Cursor;
import java.util.List;

/**
 * Result of listing resources.
 *
 * @param resources  the list of available resources
 * @param nextCursor optional cursor for pagination
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/resources/#list-resources-result">MCP Specification - List Resources Result</a>
 */
public record ListResourcesResult(
    List<Resource> resources,
    Cursor nextCursor
) {

    /**
     * Creates a new list resources result.
     */
    public ListResourcesResult {
        if (resources == null) {
            throw new IllegalArgumentException("Resources cannot be null");
        }
    }

    /**
     * Creates a result without pagination.
     *
     * @param resources the resources list
     * @return new result
     */
    public static ListResourcesResult of(List<Resource> resources) {
        return new ListResourcesResult(resources, null);
    }

    /**
     * Creates a result with pagination.
     *
     * @param resources  the resources list
     * @param nextCursor the cursor for next page
     * @return new result
     */
    public static ListResourcesResult of(List<Resource> resources, Cursor nextCursor) {
        return new ListResourcesResult(resources, nextCursor);
    }
}

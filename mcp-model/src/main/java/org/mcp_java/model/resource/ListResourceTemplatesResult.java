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
 * Result of listing resource templates.
 *
 * @param resourceTemplates the list of available resource templates
 * @param nextCursor        optional cursor for pagination
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/resources/#list-resource-templates-result">MCP Specification - List Resource Templates Result</a>
 */
public record ListResourceTemplatesResult(
    List<ResourceTemplate> resourceTemplates,
    Cursor nextCursor
) {

    /**
     * Creates a new list resource templates result.
     */
    public ListResourceTemplatesResult {
        if (resourceTemplates == null) {
            throw new IllegalArgumentException("Resource templates cannot be null");
        }
    }

    /**
     * Creates a result without pagination.
     *
     * @param resourceTemplates the resource templates list
     * @return new result
     */
    public static ListResourceTemplatesResult of(List<ResourceTemplate> resourceTemplates) {
        return new ListResourceTemplatesResult(resourceTemplates, null);
    }

    /**
     * Creates a result with pagination.
     *
     * @param resourceTemplates the resource templates list
     * @param nextCursor        the cursor for next page
     * @return new result
     */
    public static ListResourceTemplatesResult of(List<ResourceTemplate> resourceTemplates, Cursor nextCursor) {
        return new ListResourceTemplatesResult(resourceTemplates, nextCursor);
    }
}

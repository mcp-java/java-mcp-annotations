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

import java.util.List;

/**
 * Result of reading a resource.
 *
 * @param contents the resource contents
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/resources#reading-resources">MCP Specification - Reading Resources</a>
 */
public record ReadResourceResult(
    List<ResourceContents> contents
) {

    /**
     * Creates a new read resource result.
     */
    public ReadResourceResult {
        if (contents == null || contents.isEmpty()) {
            throw new IllegalArgumentException("Contents cannot be null or empty");
        }
    }

    /**
     * Creates a read resource result.
     *
     * @param contents the resource contents
     * @return new result
     */
    public static ReadResourceResult of(List<ResourceContents> contents) {
        return new ReadResourceResult(contents);
    }
}

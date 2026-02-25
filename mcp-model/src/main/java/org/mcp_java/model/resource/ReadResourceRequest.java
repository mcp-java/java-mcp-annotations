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

/**
 * Request to read a resource.
 *
 * @param uri the URI of the resource to read
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/resources#reading-resources">MCP Specification - Reading Resources</a>
 */
public record ReadResourceRequest(
    String uri
) {

    /**
     * Creates a new read resource request.
     */
    public ReadResourceRequest {
        if (uri == null || uri.isBlank()) {
            throw new IllegalArgumentException("URI cannot be null or blank");
        }
    }

    /**
     * Creates a read resource request.
     *
     * @param uri the resource URI
     * @return new request
     */
    public static ReadResourceRequest of(String uri) {
        return new ReadResourceRequest(uri);
    }
}

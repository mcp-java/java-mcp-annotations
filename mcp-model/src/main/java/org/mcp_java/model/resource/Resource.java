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
 * A resource that can be accessed by the client.
 *
 * @param uri         the unique URI identifying this resource
 * @param name        a human-readable name for the resource
 * @param description a description of what this resource contains (optional)
 * @param mimeType    the MIME type of this resource (optional)
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/resources">MCP Specification - Resources</a>
 */
public record Resource(
    String uri,
    String name,
    String description,
    String mimeType
) {

    /**
     * Creates a new resource definition.
     */
    public Resource {
        if (uri == null || uri.isBlank()) {
            throw new IllegalArgumentException("Resource URI cannot be null or blank");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Resource name cannot be null or blank");
        }
    }

    /**
     * Creates a resource with all fields.
     *
     * @param uri         the resource URI
     * @param name        the resource name
     * @param description the description
     * @param mimeType    the MIME type
     * @return a new resource
     */
    public static Resource of(String uri, String name, String description, String mimeType) {
        return new Resource(uri, name, description, mimeType);
    }

    /**
     * Creates a resource with just URI and name.
     *
     * @param uri  the resource URI
     * @param name the resource name
     * @return a new resource
     */
    public static Resource of(String uri, String name) {
        return new Resource(uri, name, null, null);
    }
}

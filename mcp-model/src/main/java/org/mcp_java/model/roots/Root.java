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

/**
 * A root that defines where the server can operate.
 *
 * @param uri  the URI of the root
 * @param name a human-readable name for the root (optional)
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/client/roots">MCP Specification - Roots</a>
 */
public record Root(
    String uri,
    String name
) {

    /**
     * Creates a new root.
     */
    public Root {
        if (uri == null || uri.isBlank()) {
            throw new IllegalArgumentException("URI cannot be null or blank");
        }
    }

    /**
     * Creates a root with URI and name.
     *
     * @param uri  the root URI
     * @param name the root name
     * @return new root
     */
    public static Root of(String uri, String name) {
        return new Root(uri, name);
    }

    /**
     * Creates a root with just URI.
     *
     * @param uri the root URI
     * @return new root
     */
    public static Root of(String uri) {
        return new Root(uri, null);
    }
}

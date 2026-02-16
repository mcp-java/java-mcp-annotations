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
package org.mcp_java.model.common;

import java.util.Map;

/**
 * Represents additional metadata sent from the client to the server.
 * <p>
 * This corresponds to the {@code _meta} part of MCP messages. Implementations
 * can inject this as a parameter in tool, resource, or prompt methods to
 * access client-provided metadata.
 * </p>
 *
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/basic/utilities/#metadata">MCP Specification - Metadata</a>
 */
public interface Meta {

    /**
     * Gets the value associated with the given metadata key.
     *
     * @param key the metadata key
     * @return the value, or null if not present
     */
    Object getValue(MetaKey key);

    /**
     * Returns all metadata as a map.
     * <p>
     * If {@code _meta} is not present in the message, an empty map is returned.
     * This method never returns null.
     * </p>
     *
     * @return the metadata map (never null)
     */
    Map<String, Object> asMap();
}

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
package org.mcp_java.model.root;

/**
 * Capabilities that a client supports.
 *
 * @param roots    root-related capabilities (optional)
 * @param sampling sampling-related capabilities (optional)
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/basic/lifecycle/#client-capabilities">MCP Specification - Client Capabilities</a>
 */
public record ClientCapabilities(
    RootsCapability roots,
    SamplingCapability sampling
) {

    /**
     * Capabilities related to roots.
     *
     * @param listChanged whether the client supports root list change notifications
     */
    public record RootsCapability(Boolean listChanged) {}

    /**
     * Capabilities related to sampling.
     */
    public record SamplingCapability() {}

    /**
     * Creates an empty capabilities object.
     *
     * @return new empty capabilities
     */
    public static ClientCapabilities empty() {
        return new ClientCapabilities(null, null);
    }
}

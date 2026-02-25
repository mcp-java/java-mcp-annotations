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
package org.mcp_java.model.lifecycle;

/**
 * Capabilities that a server supports.
 *
 * @param tools     tool-related capabilities (optional)
 * @param resources resource-related capabilities (optional)
 * @param prompts   prompt-related capabilities (optional)
 * @param logging   logging capabilities (optional)
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic/lifecycle#capability-negotiation">MCP Specification - Capability Negotiation</a>
 */
public record ServerCapabilities(
    ToolsCapability tools,
    ResourcesCapability resources,
    PromptsCapability prompts,
    LoggingCapability logging
) {

    /**
     * Capabilities related to tools.
     *
     * @param listChanged whether the server supports tool list change notifications
     */
    public record ToolsCapability(Boolean listChanged) {}

    /**
     * Capabilities related to resources.
     *
     * @param subscribe   whether the server supports resource subscriptions
     * @param listChanged whether the server supports resource list change notifications
     */
    public record ResourcesCapability(Boolean subscribe, Boolean listChanged) {}

    /**
     * Capabilities related to prompts.
     *
     * @param listChanged whether the server supports prompt list change notifications
     */
    public record PromptsCapability(Boolean listChanged) {}

    /**
     * Capabilities related to logging.
     */
    public record LoggingCapability() {}

    /**
     * Creates an empty capabilities object.
     *
     * @return new empty capabilities
     */
    public static ServerCapabilities empty() {
        return new ServerCapabilities(null, null, null, null);
    }
}

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
package org.mcp_java.model.tool;

import java.util.Map;

import org.mcp_java.model.common.MetaKey;

/**
 * A tool that can be invoked by the client.
 *
 * @param name        the unique name of the tool
 * @param title       optional human-readable name for the tool
 * @param description optional human-readable description of what the tool does
 * @param inputSchema JSON Schema for the tool's parameters
 * @param outputSchema JSON Schema for the structured content part of the tool's output. {@code null} if the tool does not output structured content.
 * @param annotations optional additional information about the tool
 * @param _meta       optional additional metadata attached to this tool
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/tools/">MCP Specification - Tools</a>
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/schema#tool">MCP Schema Reference - Tool</a>
 */
public record Tool(
    String name,
    String title,
    String description,
    Object inputSchema,
    Object outputSchema,
    ToolAnnotations annotations,
    Map<MetaKey, Object> _meta
) {

    /**
     * Creates a new tool definition.
     */
    public Tool {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Tool name cannot be null or blank");
        }
        if (inputSchema == null) {
            throw new IllegalArgumentException("Input schema cannot be null");
        }
    }

    /**
     * Creates a tool with a description.
     *
     * @param name        the tool name
     * @param description the tool description
     * @param inputSchema the input JSON Schema
     * @return a new tool
     */
    public static Tool of(String name, String description, Map<String, Object> inputSchema) {
        return new Tool(name, null, description, inputSchema, null, null, null);
    }

    /**
     * Creates a tool without a description.
     *
     * @param name        the tool name
     * @param inputSchema the input JSON Schema
     * @return a new tool
     */
    public static Tool of(String name, Map<String, Object> inputSchema) {
        return new Tool(name, null, null, inputSchema, null, null, null);
    }
}

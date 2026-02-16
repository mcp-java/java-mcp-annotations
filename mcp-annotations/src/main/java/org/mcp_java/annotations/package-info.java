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

/**
 * Framework-agnostic annotations for building Model Context Protocol (MCP) servers.
 * <p>
 * This package provides annotations that can be used to declaratively define MCP tools,
 * resources, prompts, and their parameters. Framework-specific implementations can process these
 * annotations to automatically expose functionality to MCP clients.
 * </p>
 *
 * <h2>Core Annotations</h2>
 * <ul>
 * <li>{@link dev.mcp_java.annotations.McpServer @McpServer} - Marks a class as an MCP server component</li>
 * <li>{@link dev.mcp_java.annotations.MetaField @MetaField} - Adds custom metadata fields to MCP definitions</li>
 * </ul>
 *
 * <h2>Sub-packages</h2>
 * <ul>
 * <li>{@link dev.mcp_java.annotations.tools} - Annotations for defining MCP tools</li>
 * <li>{@link dev.mcp_java.annotations.resources} - Annotations for defining MCP resources</li>
 * <li>{@link dev.mcp_java.annotations.prompts} - Annotations for defining MCP prompts</li>
 * <li>{@link dev.mcp_java.annotations.completion} - Annotations for auto-completion functionality</li>
 * </ul>
 *
 * @see <a href="https://modelcontextprotocol.io">Model Context Protocol</a>
 */
package org.mcp_java.annotations;

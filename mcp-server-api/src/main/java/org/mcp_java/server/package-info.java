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
 * Core annotations and APIs for building Model Context Protocol (MCP) servers.
 *
 * <ul>
 * <li>{@link org.mcp_java.server.McpServer @McpServer} - Marks a class as an MCP server component</li>
 * <li>{@link org.mcp_java.server.MetaField @MetaField} - Adds custom metadata fields to MCP definitions</li>
 * <li>{@link org.mcp_java.server.Cancellation} - Request cancellation handling</li>
 * <li>{@link org.mcp_java.server.ContentEncoder} - Custom content encoding</li>
 * <li>{@link org.mcp_java.server.McpException} - Base MCP exception</li>
 * <li>{@link org.mcp_java.server.McpConnection} - Connection metadata and status, including client capabilities</li>
 * <li>{@link org.mcp_java.server.McpLog} - Client-side logging</li>
 * </ul>
 */
package org.mcp_java.server;

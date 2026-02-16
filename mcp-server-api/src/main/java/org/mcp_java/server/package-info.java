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
 * Framework-agnostic server APIs for building MCP servers.
 * <p>
 * This package provides runtime interfaces and utilities that can be used by MCP server
 * implementations. These APIs are designed to be framework-independent and can be
 * implemented by any Java-based MCP server framework.
 * </p>
 *
 * <h2>Core APIs</h2>
 * <ul>
 * <li>{@link dev.mcp_java.server.Cancellation} - Interface for handling request cancellation</li>
 * <li>{@link dev.mcp_java.server.ClientCapability} - Representation of client capabilities</li>
 * <li>{@link dev.mcp_java.server.ContentEncoder} - Interface for encoding objects to MCP content</li>
 * <li>{@link dev.mcp_java.server.McpException} - Base exception for MCP-related errors</li>
 * </ul>
 *
 * @see <a href="https://modelcontextprotocol.io">Model Context Protocol</a>
 */
package org.mcp_java.server;

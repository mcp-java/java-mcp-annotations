/*
 * Copyright 2026 the original author or authors.
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
 * Define MCP tools.
 * <p>
 * Tools are executable functions that can be invoked by MCP clients.
 * Use {@link org.mcp_java.server.tools.Tool @Tool} to mark methods as tools
 * and {@link org.mcp_java.server.tools.ToolArg @ToolArg} to configure their parameters.
 * <p>
 * {@link org.mcp_java.server.tools.ToolResponse ToolResponses} can be returned from
 * {@link org.mcp_java.server.tools.annotations.Tool @Tool}-annotated methods.
 * 
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/tools">MCP Specification - Tools</a>
 */
package org.mcp_java.server.tools;

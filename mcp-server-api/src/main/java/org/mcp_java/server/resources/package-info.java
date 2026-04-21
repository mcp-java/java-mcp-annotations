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
 * Define MCP resources and resource templates.
 * <p>
 * Resources are data sources that can be read by MCP clients. Use
 * {@link org.mcp_java.server.resources.Resource @Resource} for static resources and
 * {@link org.mcp_java.server.resources.ResourceTemplate @ResourceTemplate} for dynamic
 * resources with URI templates.
 * <p>
 * Use {@link org.mcp_java.server.resources.Resources Resources} to start building
 * {@link org.mcp_java.server.resources.ResourceResponse ResourceResponses} which can be returned
 * from {@link org.mcp_java.server.resources.Resource @Resource} or
 * {@link org.mcp_java.server.resources.ResourceTemplate @ResourceTemplate}-annotated methods.
 * 
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/resources">MCP Specification - Resources</a>
 */
package org.mcp_java.server.resources;
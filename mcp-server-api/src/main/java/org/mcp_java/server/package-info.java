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
 * <li>{@link org.mcp_java.server.Cancellation} - Request cancellation handling</li>
 * <li>{@link org.mcp_java.server.ClientCapability} - Client capability representation</li>
 * <li>{@link org.mcp_java.server.ContentEncoder} - Custom content encoding</li>
 * <li>{@link org.mcp_java.server.McpException} - Base MCP exception</li>
 * <li>{@link org.mcp_java.server.McpConnection} - Connection metadata and status</li>
 * <li>{@link org.mcp_java.server.McpLog} - Client-side logging</li>
 * </ul>
 *
 * <h2>Progress Tracking</h2>
 * <ul>
 * <li>{@link org.mcp_java.server.Progress} - Progress reporting for long-running operations</li>
 * <li>{@link org.mcp_java.server.ProgressToken} - Progress token from client requests</li>
 * <li>{@link org.mcp_java.server.ProgressNotification} - Individual progress notifications</li>
 * <li>{@link org.mcp_java.server.ProgressTracker} - Stateful progress tracking</li>
 * </ul>
 *
 * <h2>LLM Sampling</h2>
 * <ul>
 * <li>{@link org.mcp_java.server.Sampling} - Request LLM sampling from client</li>
 * <li>{@link org.mcp_java.server.SamplingRequest} - Sampling request builder and sender</li>
 * <li>{@link org.mcp_java.server.SamplingResponse} - Sampling result from client</li>
 * </ul>
 *
 * <h2>User Elicitation</h2>
 * <ul>
 * <li>{@link org.mcp_java.server.Elicitation} - Request additional information from user</li>
 * <li>{@link org.mcp_java.server.ElicitationRequest} - Elicitation request with schema</li>
 * <li>{@link org.mcp_java.server.ElicitationResponse} - User-provided information</li>
 * </ul>
 *
 * <h2>Roots Access</h2>
 * <ul>
 * <li>{@link org.mcp_java.server.Roots} - Access to client's root directories</li>
 * </ul>
 *
 * <h2>Framework-Agnostic Design</h2>
 * <p>
 * These interfaces use generic types for reactive returns (e.g., {@code <T> T send()}).
 * Framework implementations should return their native reactive types:
 * </p>
 * <ul>
 * <li><strong>Quarkus</strong>: {@code Uni<T>} from SmallRye Mutiny</li>
 * <li><strong>Spring</strong>: {@code Mono<T>} from Project Reactor</li>
 * <li><strong>Standard Java</strong>: {@code CompletableFuture<T>}</li>
 * </ul>
 *
 * @see <a href="https://modelcontextprotocol.io">Model Context Protocol</a>
 * @see <a href="https://spec.modelcontextprotocol.io">MCP Specification</a>
 */
package org.mcp_java.server;

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
package org.mcp_java.server;

/**
 * Provides access to LLM sampling capabilities from the MCP client.
 * <p>
 * If an MCP client supports the sampling capability, the server can request the client
 * to perform LLM sampling operations.
 * </p>
 * <p>
 * Example usage:
 * </p>
 * <pre>
 * &#64;Tool(description = "Generate text using client's LLM")
 * public String generateText(
 *         &#64;ToolArg(name = "prompt") String prompt,
 *         Sampling sampling) {
 *     if (sampling.isSupported()) {
 *         SamplingRequest request = sampling.requestBuilder()
 *             .addMessage(SamplingMessage.withUserRole(prompt))
 *             .setMaxTokens(1000)
 *             .build();
 *         // Framework-specific: cast to Uni/Mono/CompletableFuture
 *         return request.sendAndAwait().content().text();
 *     }
 *     return "Sampling not supported";
 * }
 * </pre>
 *
 * @see SamplingRequest
 * @see org.mcp_java.model.sampling.SamplingMessage
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/sampling/">MCP Specification - Sampling</a>
 */
public interface Sampling {

    /**
     * Checks if the client supports the sampling capability.
     *
     * @return true if the client supports sampling, false otherwise
     */
    boolean isSupported();

    /**
     * Creates a new sampling request builder.
     *
     * @return a new request builder
     * @throws IllegalStateException if the client does not support sampling
     */
    SamplingRequest.Builder requestBuilder();
}

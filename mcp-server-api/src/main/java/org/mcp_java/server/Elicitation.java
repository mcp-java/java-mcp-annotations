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
 * Provides access to elicitation capabilities from the MCP client.
 * <p>
 * If an MCP client supports the elicitation capability, the server can request
 * additional information from the user through the client.
 * </p>
 * <p>
 * Example usage:
 * </p>
 * <pre>
 * &#64;Tool(description = "Create user account")
 * public String createAccount(
 *         &#64;ToolArg(name = "username") String username,
 *         Elicitation elicitation) {
 *     if (elicitation.isSupported()) {
 *         ElicitationRequest request = elicitation.requestBuilder()
 *             .setMessage("Additional information needed")
 *             .addSchemaProperty("email", new StringSchema(true))
 *             .build();
 *         ElicitationResponse response = request.sendAndAwait();
 *         if (response.actionAccepted()) {
 *             String email = response.content().getString("email");
 *             // ... create account
 *         }
 *     }
 *     return "Account created";
 * }
 * </pre>
 *
 * @see ElicitationRequest
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/client/elicitation">MCP Specification - Elicitation</a>
 */
public interface Elicitation {

    /**
     * Checks if the client supports the elicitation capability.
     *
     * @return true if the client supports elicitation, false otherwise
     */
    boolean isSupported();

    /**
     * Creates a new elicitation request builder.
     *
     * @return a new request builder
     * @throws IllegalStateException if the client does not support elicitation
     */
    ElicitationRequest.Builder requestBuilder();
}

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
package org.mcp_java.model.root;

/**
 * Request to initialize an MCP session.
 *
 * @param protocolVersion the version of the MCP protocol
 * @param capabilities    the capabilities of the client
 * @param clientInfo      information about the client implementation
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic/lifecycle#initialization">MCP Specification - Initialization</a>
 */
public record InitializeRequest(
    String protocolVersion,
    ClientCapabilities capabilities,
    Implementation clientInfo
) {

    /**
     * Creates a new initialize request.
     */
    public InitializeRequest {
        if (protocolVersion == null || protocolVersion.isBlank()) {
            throw new IllegalArgumentException("Protocol version cannot be null or blank");
        }
        if (capabilities == null) {
            throw new IllegalArgumentException("Capabilities cannot be null");
        }
        if (clientInfo == null) {
            throw new IllegalArgumentException("Client info cannot be null");
        }
    }

    /**
     * Creates an initialize request.
     *
     * @param protocolVersion the protocol version
     * @param capabilities    the client capabilities
     * @param clientInfo      the client implementation info
     * @return new initialize request
     */
    public static InitializeRequest of(String protocolVersion, ClientCapabilities capabilities, Implementation clientInfo) {
        return new InitializeRequest(protocolVersion, capabilities, clientInfo);
    }
}

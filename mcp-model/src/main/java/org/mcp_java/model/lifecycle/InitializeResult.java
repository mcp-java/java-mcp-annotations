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
package org.mcp_java.model.lifecycle;

/**
 * Result of an initialize request.
 *
 * @param protocolVersion the version of the MCP protocol the server is using
 * @param capabilities    the capabilities of the server
 * @param serverInfo      information about the server implementation
 * @param instructions    optional instructions for using this server
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic/lifecycle#initialization">MCP Specification - Initialization</a>
 */
public record InitializeResult(
    String protocolVersion,
    ServerCapabilities capabilities,
    Implementation serverInfo,
    String instructions
) {

    /**
     * Creates a new initialize result.
     */
    public InitializeResult {
        if (protocolVersion == null || protocolVersion.isBlank()) {
            throw new IllegalArgumentException("Protocol version cannot be null or blank");
        }
        if (capabilities == null) {
            throw new IllegalArgumentException("Capabilities cannot be null");
        }
        if (serverInfo == null) {
            throw new IllegalArgumentException("Server info cannot be null");
        }
    }

    /**
     * Creates an initialize result.
     *
     * @param protocolVersion the protocol version
     * @param capabilities    the server capabilities
     * @param serverInfo      the server implementation info
     * @return new initialize result
     */
    public static InitializeResult of(String protocolVersion, ServerCapabilities capabilities, Implementation serverInfo) {
        return new InitializeResult(protocolVersion, capabilities, serverInfo, null);
    }

    /**
     * Creates an initialize result with instructions.
     *
     * @param protocolVersion the protocol version
     * @param capabilities    the server capabilities
     * @param serverInfo      the server implementation info
     * @param instructions    usage instructions
     * @return new initialize result
     */
    public static InitializeResult of(String protocolVersion, ServerCapabilities capabilities, Implementation serverInfo, String instructions) {
        return new InitializeResult(protocolVersion, capabilities, serverInfo, instructions);
    }
}

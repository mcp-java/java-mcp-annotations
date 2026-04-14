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

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.mcp_java.server.sampling.Sampling;

/**
 * Represents a connection from an MCP client to the server.
 * <p>
 * Provides access to connection metadata including client capabilities,
 * protocol version, and connection status.
 * </p>
 * <p>
 * Example usage:
 * </p>
 * 
 * <pre>
 * &#64;Tool(description = "Get connection info")
 * public String getConnectionInfo(McpConnection connection) {
 *     return String.format("Client: %s, Protocol: %s, Status: %s",
 *                          connection.clientInfo().name(),
 *                          connection.protocolVersion(),
 *                          connection.status());
 * }
 * </pre>
 *
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic/lifecycle">MCP Specification - Lifecycle</a>
 */
public interface McpConnection {

    /**
     * Gets the connection identifier.
     *
     * @return the connection ID (never null)
     */
    String id();

    /**
     * Gets the current connection status.
     *
     * @return the status (never null)
     */
    Status status();

    /**
     * Gets the protocol version in use for this connection.
     * 
     * @return the protocol version
     */
    String protocolVersion();

    /**
     * Gets the capabilities which the client supports.
     * <p>
     * Usually the information in this map should be queried via other mechanisms. E.g. {@link Sampling#isSupported()}
     * 
     * @return the raw map of supported capabilities reported by the client
     */
    Map<String, Object> rawClientCapabilities();

    /**
     * Gets the description of the client, as reported during initialization
     * 
     * @return the client information
     */
    ImplementationInfo clientInfo();

    /**
     * Gets the current log level for this connection.
     *
     * @return the log level
     */
    McpLog.LogLevel logLevel();

    /**
     * The status of an MCP connection.
     */
    enum Status {
        /**
         * A new connection, waiting for the {@code initialize} request from the client.
         */
        NEW,

        /**
         * The server responded to the {@code initialize} request with its capabilities
         * and is now waiting for the {@code initialized} notification from the client.
         */
        INITIALIZING,

        /**
         * The client sent the {@code initialized} notification.
         * The connection is now ready for normal operation.
         */
        IN_OPERATION,

        /**
         * Connection was closed.
         */
        CLOSED;

        /**
         * Checks if the client has completed initialization.
         *
         * @return true if status is IN_OPERATION
         */
        public boolean isClientInitialized() {
            return this == IN_OPERATION;
        }
    }

    /**
     * Provides information about a client implementation
     */
    public interface ImplementationInfo {
        /**
         * Returns a list of icons for this client, may be empty
         * 
         * @return the list of icons
         */
        List<Icon> icons();

        /**
         * Returns the client name
         * 
         * @return the name
         */
        String name();

        /**
         * Returns a human-readable name for the client
         * 
         * @return the human readable name, may be the same as {@code name}
         */
        String title();

        /**
         * Returns the client version
         *
         * @return the client version
         */
        String version();

        /**
         * Returns a human readable description of the client
         * 
         * @return the description
         */
        Optional<String> description();

        /**
         * Returns the URL of the client's website
         * 
         * @return the client's URL
         */
        Optional<String> websiteUrl();
    }
}

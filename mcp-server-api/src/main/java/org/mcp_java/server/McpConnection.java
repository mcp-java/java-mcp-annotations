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

import org.mcp_java.model.root.InitializeRequest;

/**
 * Represents a connection from an MCP client to the server.
 * <p>
 * Provides access to connection metadata including client capabilities,
 * protocol version, and connection status.
 * </p>
 * <p>
 * Example usage:
 * </p>
 * <pre>
 * &#64;Tool(description = "Get connection info")
 * public String getConnectionInfo(McpConnection connection) {
 *     return String.format("Client: %s, Protocol: %s, Status: %s",
 *         connection.initialRequest().clientInfo().name(),
 *         connection.initialRequest().protocolVersion(),
 *         connection.status());
 * }
 * </pre>
 *
 * @see InitializeRequest
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
     * Gets the initial request sent by the client during initialization.
     *
     * @return the initial request (never null)
     */
    InitializeRequest initialRequest();

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
}

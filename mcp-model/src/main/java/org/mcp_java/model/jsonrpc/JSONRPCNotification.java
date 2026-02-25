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
package org.mcp_java.model.jsonrpc;

/**
 * A JSON-RPC 2.0 notification message.
 * Notifications are requests without an ID that do not expect a response.
 *
 * @param jsonrpc the JSON-RPC version (must be "2.0")
 * @param method  the method to invoke
 * @param params  the method parameters (optional)
 * @see <a href="https://www.jsonrpc.org/specification#notification">JSON-RPC 2.0 Notification</a>
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic">MCP Specification - Protocol</a>
 */
public record JSONRPCNotification(
    String jsonrpc,
    String method,
    Object params
) implements JSONRPCMessage {

    /**
     * Creates a new JSON-RPC notification.
     */
    public JSONRPCNotification {
        if (!"2.0".equals(jsonrpc)) {
            throw new IllegalArgumentException("JSON-RPC version must be '2.0'");
        }
        if (method == null || method.isBlank()) {
            throw new IllegalArgumentException("Method cannot be null or blank");
        }
    }

    /**
     * Creates a JSON-RPC notification without parameters.
     *
     * @param method the method name
     * @return a new notification
     */
    public static JSONRPCNotification of(String method) {
        return new JSONRPCNotification("2.0", method, null);
    }

    /**
     * Creates a JSON-RPC notification with parameters.
     *
     * @param method the method name
     * @param params the method parameters
     * @return a new notification
     */
    public static JSONRPCNotification of(String method, Object params) {
        return new JSONRPCNotification("2.0", method, params);
    }
}

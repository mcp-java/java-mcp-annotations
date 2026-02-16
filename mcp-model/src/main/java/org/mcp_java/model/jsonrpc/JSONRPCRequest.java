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

import org.mcp_java.model.common.RequestId;

/**
 * A JSON-RPC 2.0 request message.
 *
 * @param jsonrpc the JSON-RPC version (must be "2.0")
 * @param id      the request identifier
 * @param method  the method to invoke
 * @param params  the method parameters (optional)
 * @see <a href="https://www.jsonrpc.org/specification#request_object">JSON-RPC 2.0 Request</a>
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/basic/protocol/">MCP Specification - Protocol</a>
 */
public record JSONRPCRequest(
    String jsonrpc,
    RequestId id,
    String method,
    Object params
) implements JSONRPCMessage {

    /**
     * Creates a new JSON-RPC request.
     */
    public JSONRPCRequest {
        if (!"2.0".equals(jsonrpc)) {
            throw new IllegalArgumentException("JSON-RPC version must be '2.0'");
        }
        if (id == null) {
            throw new IllegalArgumentException("Request ID cannot be null");
        }
        if (method == null || method.isBlank()) {
            throw new IllegalArgumentException("Method cannot be null or blank");
        }
    }

    /**
     * Creates a JSON-RPC request without parameters.
     *
     * @param id     the request ID
     * @param method the method name
     * @return a new request
     */
    public static JSONRPCRequest of(RequestId id, String method) {
        return new JSONRPCRequest("2.0", id, method, null);
    }

    /**
     * Creates a JSON-RPC request with parameters.
     *
     * @param id     the request ID
     * @param method the method name
     * @param params the method parameters
     * @return a new request
     */
    public static JSONRPCRequest of(RequestId id, String method, Object params) {
        return new JSONRPCRequest("2.0", id, method, params);
    }
}

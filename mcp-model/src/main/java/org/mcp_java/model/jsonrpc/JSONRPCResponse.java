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
 * A JSON-RPC 2.0 response message.
 * Either result or error must be present, but not both.
 *
 * @param jsonrpc the JSON-RPC version (must be "2.0")
 * @param id      the request identifier this response corresponds to
 * @param result  the result of the method invocation (present if successful)
 * @param error   the error object (present if failed)
 * @see <a href="https://www.jsonrpc.org/specification#response_object">JSON-RPC 2.0 Response</a>
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic">MCP Specification - Protocol</a>
 */
public record JSONRPCResponse(
    String jsonrpc,
    RequestId id,
    Object result,
    JSONRPCError error
) implements JSONRPCMessage {

    /**
     * Creates a new JSON-RPC response.
     */
    public JSONRPCResponse {
        if (!"2.0".equals(jsonrpc)) {
            throw new IllegalArgumentException("JSON-RPC version must be '2.0'");
        }
        if (id == null) {
            throw new IllegalArgumentException("Response ID cannot be null");
        }
        if ((result == null && error == null) || (result != null && error != null)) {
            throw new IllegalArgumentException("Either result or error must be present, but not both");
        }
    }

    /**
     * Creates a successful JSON-RPC response.
     *
     * @param id     the request ID
     * @param result the result value
     * @return a new success response
     */
    public static JSONRPCResponse success(RequestId id, Object result) {
        return new JSONRPCResponse("2.0", id, result, null);
    }

    /**
     * Creates an error JSON-RPC response.
     *
     * @param id    the request ID
     * @param error the error object
     * @return a new error response
     */
    public static JSONRPCResponse error(RequestId id, JSONRPCError error) {
        return new JSONRPCResponse("2.0", id, null, error);
    }

    /**
     * Checks if this response represents a successful result.
     *
     * @return true if this is a success response
     */
    public boolean isSuccess() {
        return result != null;
    }

    /**
     * Checks if this response represents an error.
     *
     * @return true if this is an error response
     */
    public boolean isError() {
        return error != null;
    }
}

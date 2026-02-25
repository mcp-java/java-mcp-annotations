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
 * Base interface for all JSON-RPC 2.0 messages.
 * All messages must include the JSON-RPC version field.
 *
 * @see <a href="https://www.jsonrpc.org/specification">JSON-RPC 2.0 Specification</a>
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic">MCP Specification - Protocol</a>
 */
public interface JSONRPCMessage {

    /**
     * The JSON-RPC protocol version. Must be "2.0".
     *
     * @return the JSON-RPC version
     */
    String jsonrpc();
}

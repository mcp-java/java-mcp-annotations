/*
 * Copyright 2026 the original author or authors.
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

import java.util.Map;
import java.util.Optional;

/**
 * Provides information about the current request, including the request ID and the metadata fields.
 * <p>
 * Tool, Prompt, Resource, and ResourceTemplate methods can accept this interface as a parameter.
 * It will be automatically injected by the framework implementation before the method is invoked.
 */
public interface McpRequest extends MetaCarrier {

    /**
     * Gets the request id, either a {@link String} or a {@link Number}.
     * 
     * @return the request id
     */
    Object id();

    /**
     * Gets the session ID, if the request is part of a session
     * 
     * @return the session ID, or an empty {@code Optional} if the request is not associated with a session
     */
    Optional<String> sessionId();

    /**
     * Gets the MCP protocol version in use for this request
     * 
     * @return the protocol version, e.g. {@code 2025-11-25} or {@code 2025-06-18}
     */
    String protocolVersion();

    /**
     * Gets the map of capabilities that the client supports
     * 
     * @return the raw map of supported capabilities reported by the client
     */
    Map<String, Object> rawClientCapabilities();

    /**
     * Gets the description of the client, as sent by the client itself
     * 
     * @return the client information
     */
    ImplementationInfo clientInfo();
}

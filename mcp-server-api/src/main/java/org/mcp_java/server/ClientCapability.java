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

import java.util.Map;

/**
 * Represents a capability supported by an MCP client.
 */
public record ClientCapability(String name, Map<String, Object> properties) {

    /**
     * The "roots" capability allows the server to access root directories.
     */
    public static final String ROOTS = "roots";

    /**
     * The "sampling" capability allows the server to request LLM sampling from the client.
     */
    public static final String SAMPLING = "sampling";

    /**
     * The "elicitation" capability allows the server to request additional information from the user.
     */
    public static final String ELICITATION = "elicitation";
}

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
package org.mcp_java.model.logging;

/**
 * Request to set the logging level.
 *
 * @param level the logging level to set
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/utilities/logging#setting-log-level">MCP Specification - Set Logging Level</a>
 */
public record SetLoggingLevelRequest(
    LoggingLevel level
) {

    /**
     * Creates a new set logging level request.
     */
    public SetLoggingLevelRequest {
        if (level == null) {
            throw new IllegalArgumentException("Level cannot be null");
        }
    }

    /**
     * Creates a set logging level request.
     *
     * @param level the logging level
     * @return new request
     */
    public static SetLoggingLevelRequest of(LoggingLevel level) {
        return new SetLoggingLevelRequest(level);
    }
}

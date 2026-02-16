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
 * The severity level of a log message.
 *
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/utilities/logging/">MCP Specification - Logging</a>
 */
public enum LoggingLevel {
    /**
     * Debug-level messages for detailed diagnostics.
     */
    DEBUG("debug"),

    /**
     * Informational messages about normal operations.
     */
    INFO("info"),

    /**
     * Warning messages about potential issues.
     */
    WARNING("warning"),

    /**
     * Error messages about failures.
     */
    ERROR("error"),

    /**
     * Critical/emergency messages about severe failures.
     */
    CRITICAL("critical"),

    /**
     * Emergency messages (alias for critical).
     */
    EMERGENCY("emergency");

    private final String value;

    LoggingLevel(String value) {
        this.value = value;
    }

    /**
     * Gets the string value of this logging level.
     *
     * @return the level value
     */
    public String getValue() {
        return value;
    }

    /**
     * Parses a logging level from its string value.
     *
     * @param value the string value
     * @return the corresponding LoggingLevel
     * @throws IllegalArgumentException if the value is not recognized
     */
    public static LoggingLevel fromValue(String value) {
        for (LoggingLevel level : values()) {
            if (level.value.equals(value)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Unknown logging level: " + value);
    }
}

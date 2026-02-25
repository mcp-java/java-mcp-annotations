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

/**
 * Sends log message notifications to a connected MCP client.
 * <p>
 * The MCP logger name is typically derived from the context (e.g., for a Tool method
 * named {@code myTool}, the logger name would be {@code tool:myTool}).
 * </p>
 * <p>
 * Example usage:
 * </p>
 * <pre>
 * &#64;Tool(description = "Process data")
 * public String processData(
 *         &#64;ToolArg(name = "data") String data,
 *         McpLog log) {
 *     log.info("Starting data processing");
 *     // ... process data
 *     log.debug("Processed %d items", count);
 *     return result;
 * }
 * </pre>
 *
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/utilities/logging">MCP Specification - Logging</a>
 */
public interface McpLog {

    /**
     * Gets the current log level.
     *
     * @return the current log level
     */
    LogLevel level();

    /**
     * Sends a log message notification to the client if the specified level is
     * higher or equal to the current level.
     *
     * @param level the log level
     * @param data the data to log
     */
    void send(LogLevel level, Object data);

    /**
     * Sends a formatted log message notification to the client if the specified
     * level is higher or equal to the current level.
     *
     * @param level the log level
     * @param format the format string
     * @param params the format parameters
     */
    void send(LogLevel level, String format, Object... params);

    /**
     * Logs a debug message and sends it to the client.
     *
     * @param format the format string
     * @param params the format parameters
     */
    void debug(String format, Object... params);

    /**
     * Logs an info message and sends it to the client.
     *
     * @param format the format string
     * @param params the format parameters
     */
    void info(String format, Object... params);

    /**
     * Logs an error message and sends it to the client.
     *
     * @param format the format string
     * @param params the format parameters
     */
    void error(String format, Object... params);

    /**
     * Logs an error message with throwable and sends it to the client.
     *
     * @param t the throwable
     * @param format the format string
     * @param params the format parameters
     */
    void error(Throwable t, String format, Object... params);

    /**
     * Log levels as defined by the MCP specification.
     */
    enum LogLevel {
        /**
         * Debug-level messages.
         */
        DEBUG,

        /**
         * Informational messages.
         */
        INFO,

        /**
         * Notice-level messages.
         */
        NOTICE,

        /**
         * Warning messages.
         */
        WARNING,

        /**
         * Error messages.
         */
        ERROR,

        /**
         * Critical error messages.
         */
        CRITICAL,

        /**
         * Alert messages requiring immediate attention.
         */
        ALERT,

        /**
         * Emergency messages indicating system is unusable.
         */
        EMERGENCY;

        /**
         * Parses a log level from a string value.
         *
         * @param value the string value
         * @return the log level, or null if invalid
         */
        public static LogLevel from(String value) {
            if (value == null || value.isBlank()) {
                return null;
            }
            try {
                return valueOf(value.toUpperCase());
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }
}

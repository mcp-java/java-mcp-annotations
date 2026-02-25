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

import java.util.Map;

/**
 * Notification containing a log message.
 *
 * @param level  the severity level of the message
 * @param logger the name of the logger (optional)
 * @param data   the log message data
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/utilities/logging#log-message-notifications">MCP Specification - Logging Message</a>
 */
public record LoggingMessageNotification(
    LoggingLevel level,
    String logger,
    Object data
) {

    /**
     * Creates a new logging message notification.
     */
    public LoggingMessageNotification {
        if (level == null) {
            throw new IllegalArgumentException("Level cannot be null");
        }
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
    }

    /**
     * Creates a logging notification.
     *
     * @param level  the logging level
     * @param logger the logger name
     * @param data   the log data
     * @return new logging notification
     */
    public static LoggingMessageNotification of(LoggingLevel level, String logger, Object data) {
        return new LoggingMessageNotification(level, logger, data);
    }

    /**
     * Creates a logging notification without logger name.
     *
     * @param level the logging level
     * @param data  the log data
     * @return new logging notification
     */
    public static LoggingMessageNotification of(LoggingLevel level, Object data) {
        return new LoggingMessageNotification(level, null, data);
    }
}

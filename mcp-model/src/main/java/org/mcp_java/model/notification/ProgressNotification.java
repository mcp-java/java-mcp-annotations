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
package org.mcp_java.model.notification;

import org.mcp_java.model.common.ProgressToken;

/**
 * Notification about progress of a long-running operation.
 *
 * @param progressToken the token identifying the operation
 * @param progress      current progress value
 * @param total         total expected progress value (optional)
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic/utilities/progress">MCP Specification - Progress Notifications</a>
 */
public record ProgressNotification(
    ProgressToken progressToken,
    double progress,
    Double total
) {

    /**
     * Creates a new progress notification.
     */
    public ProgressNotification {
        if (progressToken == null) {
            throw new IllegalArgumentException("Progress token cannot be null");
        }
        if (progress < 0) {
            throw new IllegalArgumentException("Progress cannot be negative");
        }
        if (total != null && total < 0) {
            throw new IllegalArgumentException("Total cannot be negative");
        }
    }

    /**
     * Creates a progress notification without total.
     *
     * @param progressToken the progress token
     * @param progress      the current progress
     * @return new progress notification
     */
    public static ProgressNotification of(ProgressToken progressToken, double progress) {
        return new ProgressNotification(progressToken, progress, null);
    }

    /**
     * Creates a progress notification with total.
     *
     * @param progressToken the progress token
     * @param progress      the current progress
     * @param total         the total expected progress
     * @return new progress notification
     */
    public static ProgressNotification of(ProgressToken progressToken, double progress, double total) {
        return new ProgressNotification(progressToken, progress, total);
    }
}

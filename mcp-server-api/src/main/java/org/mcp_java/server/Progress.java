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

import java.util.Optional;

/**
 * Provides access to progress reporting capabilities for MCP requests.
 * <p>
 * If an MCP client specifies a progress token in a request, the server can send
 * progress notification messages back to the client during request processing.
 * </p>
 * <p>
 * Tool, Prompt, Resource, and ResourceTemplate methods can accept this interface
 * as a parameter. Framework implementations will automatically inject it before
 * invoking the method.
 * </p>
 * <p>
 * Example usage:
 * </p>
 * <pre>
 * &#64;Tool(description = "Process large dataset")
 * public String processData(
 *         &#64;ToolArg(name = "data") String data,
 *         Progress progress) {
 *     if (progress.token().isPresent()) {
 *         ProgressTracker tracker = progress.trackerBuilder()
 *             .setTotal(100)
 *             .setDefaultStep(10)
 *             .build();
 *         // Use tracker.advanceAndForget() as work progresses
 *     }
 *     // ... process data
 * }
 * </pre>
 *
 * @see ProgressToken
 * @see ProgressNotification
 * @see ProgressTracker
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic/utilities/progress">MCP Specification - Progress</a>
 */
public interface Progress {

    /**
     * Gets the progress token if present in the request.
     * <p>
     * If the client didn't include a progress token, this returns {@code Optional.empty()}.
     * </p>
     *
     * @return the progress token if present
     */
    Optional<ProgressToken> token();

    /**
     * Creates a builder for a progress notification.
     * <p>
     * {@link ProgressNotification} can be used to send individual notification messages.
     * </p>
     *
     * @return a new notification builder
     * @throws IllegalStateException if the progress token is not present
     */
    ProgressNotification.Builder notificationBuilder();

    /**
     * Creates a builder for a progress tracker.
     * <p>
     * {@link ProgressTracker} is a stateful, thread-safe construct that can be used to
     * update progress status and send notification messages automatically.
     * </p>
     *
     * @return a new tracker builder
     * @throws IllegalStateException if the progress token is not present
     */
    ProgressTracker.Builder trackerBuilder();
}

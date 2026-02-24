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

import java.math.BigDecimal;

/**
 * Represents a {@code notifications/progress} message to send to the client.
 * <p>
 * Progress notifications allow servers to report progress on long-running operations.
 * </p>
 *
 * @see Progress
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/basic/utilities/#progress">MCP Specification - Progress</a>
 */
public interface ProgressNotification {

    /**
     * Gets the original progress token from the request.
     *
     * @return the progress token
     */
    ProgressToken token();

    /**
     * Gets the total expected value for the operation.
     *
     * @return the total value, or null if not set
     */
    BigDecimal total();

    /**
     * Gets the current progress value.
     *
     * @return the progress value
     */
    BigDecimal progress();

    /**
     * Gets the progress message.
     *
     * @return the message, or null if not set
     */
    String message();

    /**
     * Sends the progress notification to the client without waiting for acknowledgment.
     * <p>
     * This method is fire-and-forget and can be called from any thread.
     * Framework implementations may send the message asynchronously.
     * </p>
     */
    void sendAndForget();

    /**
     * Sends the progress notification to the client asynchronously.
     * <p>
     * Framework implementations should return their native reactive type:
     * </p>
     * <ul>
     * <li>Quarkus: {@code Uni<Void>}</li>
     * <li>Spring: {@code Mono<Void>}</li>
     * <li>Standard Java: {@code CompletableFuture<Void>}</li>
     * </ul>
     *
     * @param <T> the framework-specific reactive type
     * @return a reactive result that completes when the notification is sent
     */
    <T> T send();

    /**
     * Builder for creating progress notifications.
     */
    interface Builder {

        /**
         * Sets the current progress value.
         *
         * @param progress the progress value
         * @return this builder
         */
        Builder setProgress(long progress);

        /**
         * Sets the current progress value.
         *
         * @param progress the progress value
         * @return this builder
         */
        Builder setProgress(double progress);

        /**
         * Sets the total expected value.
         *
         * @param total the total value
         * @return this builder
         */
        Builder setTotal(long total);

        /**
         * Sets the total expected value.
         *
         * @param total the total value
         * @return this builder
         */
        Builder setTotal(double total);

        /**
         * Sets the progress message.
         *
         * @param message the message
         * @return this builder
         */
        Builder setMessage(String message);

        /**
         * Builds the progress notification.
         *
         * @return the progress notification
         */
        ProgressNotification build();
    }
}

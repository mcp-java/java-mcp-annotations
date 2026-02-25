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
import java.util.function.Function;

/**
 * Tracks progress updates and sends notifications to the client.
 * <p>
 * This interface provides a thread-safe, stateful way to track and report progress
 * for long-running operations. It maintains the current progress value and can
 * automatically send notifications to the client.
 * </p>
 * <p>
 * Implementations must be thread-safe and may be used concurrently.
 * </p>
 *
 * @see Progress
 * @see ProgressNotification
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic/utilities/progress">MCP Specification - Progress</a>
 */
public interface ProgressTracker {

    /**
     * Gets the original progress token from the request.
     *
     * @return the progress token
     */
    ProgressToken token();

    /**
     * Advances the progress by the specified value and sends a notification without waiting.
     * <p>
     * This is a fire-and-forget operation that can be called from any thread.
     * </p>
     *
     * @param value the amount to advance
     * @throws IllegalStateException if the total has been set and the progress would exceed it
     */
    void advanceAndForget(BigDecimal value);

    /**
     * Advances the progress by the specified value and sends a notification asynchronously.
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
     * @param value the amount to advance
     * @return a reactive result that completes when the notification is sent
     */
    <T> T advance(BigDecimal value);

    /**
     * Advances the progress by the default step and sends a notification without waiting.
     *
     * @throws IllegalStateException if the total has been set and the progress would exceed it
     * @see #step()
     */
    default void advanceAndForget() {
        advanceAndForget(step());
    }

    /**
     * Advances the progress by the specified value and sends a notification without waiting.
     *
     * @param value the amount to advance
     * @throws IllegalStateException if the total has been set and the progress would exceed it
     */
    default void advanceAndForget(long value) {
        advanceAndForget(new BigDecimal(value));
    }

    /**
     * Advances the progress by the specified value and sends a notification without waiting.
     *
     * @param value the amount to advance
     * @throws IllegalStateException if the total has been set and the progress would exceed it
     */
    default void advanceAndForget(double value) {
        advanceAndForget(new BigDecimal(value));
    }

    /**
     * Gets the current progress value.
     *
     * @return the current progress (never null)
     */
    BigDecimal progress();

    /**
     * Gets the expected total value.
     *
     * @return the total value, or null if not set
     */
    BigDecimal total();

    /**
     * Gets the default step value used by {@link #advanceAndForget()}.
     *
     * @return the default step (never null)
     */
    BigDecimal step();

    /**
     * Builder for creating progress trackers.
     */
    interface Builder {

        /**
         * Sets the expected total value.
         *
         * @param total the total value
         * @return this builder
         */
        Builder setTotal(long total);

        /**
         * Sets the expected total value.
         *
         * @param total the total value
         * @return this builder
         */
        Builder setTotal(double total);

        /**
         * Sets the default step value.
         * <p>
         * The default step is used when calling {@link ProgressTracker#advanceAndForget()}
         * without arguments.
         * </p>
         *
         * @param step the default step value
         * @return this builder
         * @see ProgressTracker#advanceAndForget()
         */
        Builder setDefaultStep(long step);

        /**
         * Sets the default step value.
         * <p>
         * The default step is used when calling {@link ProgressTracker#advanceAndForget()}
         * without arguments.
         * </p>
         *
         * @param step the default step value
         * @return this builder
         * @see ProgressTracker#advanceAndForget()
         */
        Builder setDefaultStep(double step);

        /**
         * Sets a message builder function.
         * <p>
         * The message builder accepts the current progress value and produces a
         * notification message. This is called each time progress is advanced.
         * </p>
         *
         * @param messageBuilder the message builder function
         * @return this builder
         */
        Builder setMessageBuilder(Function<BigDecimal, String> messageBuilder);

        /**
         * Builds the progress tracker.
         *
         * @return a new progress tracker
         */
        ProgressTracker build();
    }
}

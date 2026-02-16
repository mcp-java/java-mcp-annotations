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
 * Interface for determining if an MCP client requested cancellation of an in-progress request.
 * <p>
 * Tool, Prompt, Resource, and ResourceTemplate methods can accept this interface as a parameter.
 * It will be automatically injected by the framework implementation before the method is invoked.
 * </p>
 *
 * @see #check()
 */
public interface Cancellation {

    /**
     * Perform the cancellation check.
     * <p>
     * A feature method should throw an {@link OperationCancelledException} if cancellation was requested by the client.
     * </p>
     *
     * @return the result containing cancellation status
     * @see Result#isRequested()
     * @see OperationCancelledException
     */
    Result check();

    /**
     * Perform the check and if cancellation is requested then skip the processing.
     *
     * @throws OperationCancelledException if cancellation is requested
     */
    default void skipProcessingIfCancelled() {
        if (check().isRequested()) {
            throw new OperationCancelledException();
        }
    }

    /**
     * Result of a cancellation check.
     *
     * @param isRequested {@code true} if a client wants to cancel an in-progress request
     * @param reason      an optional reason for cancellation
     */
    record Result(boolean isRequested, Optional<String> reason) {
    }

    /**
     * Exception indicating that an MCP request cannot be completed because it was cancelled by the client.
     */
    class OperationCancelledException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public OperationCancelledException() {
            super();
        }

        public OperationCancelledException(String message) {
            super(message);
        }
    }
}

/*
 * Copyright 2026 the original author or authors.
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
package org.mcp_java.server.completion;

import static org.mcp_java.server.spi.McpServerSPILoader.getSPI;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.mcp_java.server.MetaCarrier;

/**
 * The result of a completion request, listing the possible completion values for a variable.
 */
public interface CompletionResult extends MetaCarrier {

    /**
     * Returns the list of suggestions (max 100).
     * 
     * @return the list of suggestions
     */
    List<String> values();

    /**
     * Returns the total number of suggestions available, if known.
     * <p>
     * This may exceed the size of {@link #values()}.
     * 
     * @return the total number of suggestions available, or an empty optional if not known
     */
    OptionalInt total();

    /**
     * Returns whether or not there are more suggestions than are included in {@link #values()}, if
     * known.
     * 
     * @return An {@code Optional} containing {@code true} if there are more suggestions,
     * {@code false} if there are not, or an empty {@code Optional} if it is not known
     */
    Optional<Boolean> hasMore();

    /**
     * Create a new builder for a {@link CompletionResult}.
     * 
     * @return the new {@code CompletionResult} builder
     */
    static CompletionResult.Builder builder() {
        return getSPI().completeResultBuilder();
    }

    /**
     * Creates a new {@code CompletionResult} with a list of suggestions that is the complete set of available suggestions.
     * 
     * @param values the list of suggestions
     * @return the new completion result
     */
    static CompletionResult newCompleteResult(List<String> values) {
        return getSPI().newCompleteResult(values);
    }

    /**
     * Creates a new {@code CompletionResult} with a list of suggestions that is not the complete set of available suggestions.
     * 
     * @param values the list of suggestions
     * @return the new completion result
     */
    static CompletionResult newIncompleteResult(List<String> values) {
        return getSPI().newIncompleteResult(values);
    }

    /**
     * Creates a new {@code CompletionResult} which includes a list of suggestions and the total number of available suggestions.
     * 
     * @param values the list of suggestions
     * @param total the total number of available suggestions
     * @return the new completion result
     * @throws IllegalArgumentException if {@code total} is less than {@code values.size()}
     */
    static CompletionResult newResult(List<String> values, int total) {
        return getSPI().newResult(values, total);
    }

    
    /**
     * Builder for creation completion responses.
     */
    interface Builder extends MetaCarrier.Builder<Builder> {

        /**
         * Adds a value to the list of completion suggestions.
         * <p>
         * The number of suggestions added should not be greater than 100
         * 
         * @param value the value to add
         * @return this builder
         */
        Builder addValue(String value);

        /**
         * Adds a collection of values to the list of completion suggestions.
         * <p>
         * The number of suggestions added should be greater than 100
         * 
         * @param values the values to add
         * @return this builder
         */
        Builder addValues(Collection<String> values);

        /**
         * Sets the total number of suggestions available. This may be greater than the number of
         * suggestions added with {@link #addValue(String)} and
         * {@link #addValues(Collection)}
         * 
         * @param total the total number of suggestions available
         * @return this builder
         */
        Builder setTotal(int total);

        /**
         * Sets whether there are more suggestions available than are added using
         * {@link #addValue(String)} or {@link #addValues(Collection)}.
         * 
         * @param hasMore {@code true} if there are more suggestions, {@code false} if there are not
         * @return this builder
         */
        Builder setHasMore(Boolean hasMore);

        /**
         * Builds the new completion result.
         * 
         * @return the new completion result
         */
        CompletionResult build();
    }
}

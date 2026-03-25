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

import java.util.List;

/**
 * Provides access to builders for Completion responses.
 * <p>
 * This class can be injected as a parameter to a {@code @CompletePrompt} or {@code @CompleteResourceTemplate}-annotated method, or using framework-specific mechanisms.
 */
public interface Completions {

    /**
     * Create a new builder for a {@link CompletionResult}.
     * 
     * @return the new {@code CompletionResult} builder
     */
    CompletionResult.Builder newResult();

    /**
     * Creates a new {@code CompletionResult} with a list of suggestions that is the complete set of available suggestions.
     * 
     * @param values the list of suggestions
     * @return the new completion result
     */
    CompletionResult newCompleteResult(List<String> values);

    /**
     * Creates a new {@code CompletionResult} with a list of suggestions that is not the complete set of available suggestions.
     * 
     * @param values the list of suggestions
     * @return the new completion result
     */
    CompletionResult newIncompleteResult(List<String> values);

    /**
     * Creates a new {@code CompletionResult} which includes a list of suggestions and the total number of available suggestions.
     * 
     * @param values the list of suggestions
     * @param total the total number of available suggestions
     * @return the new completion result
     * @throws IllegalArgumentException if {@code total} is less than {@code values.size()}
     */
    CompletionResult newResult(List<String> values, int total);
}

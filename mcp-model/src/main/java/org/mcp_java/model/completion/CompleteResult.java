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
package org.mcp_java.model.completion;

import java.util.List;

/**
 * Result of a completion request.
 *
 * @param completion the completion result
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/client/completion/#completion-result">MCP Specification - Completion Result</a>
 */
public record CompleteResult(
    Completion completion
) {

    /**
     * Creates a new completion result.
     */
    public CompleteResult {
        if (completion == null) {
            throw new IllegalArgumentException("Completion cannot be null");
        }
    }

    /**
     * Completion suggestions and metadata.
     *
     * @param values      the list of completion values
     * @param total       total number of available completions (optional)
     * @param hasMore     whether there are more completions available
     */
    public record Completion(
        List<String> values,
        Integer total,
        Boolean hasMore
    ) {
        public Completion {
            if (values == null) {
                throw new IllegalArgumentException("Values cannot be null");
            }
        }
    }
}

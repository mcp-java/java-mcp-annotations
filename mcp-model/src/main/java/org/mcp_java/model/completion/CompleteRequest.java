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

/**
 * Request for completion suggestions.
 *
 * @param ref      reference to what is being completed
 * @param argument the argument being completed
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/client/completion/">MCP Specification - Completion</a>
 */
public record CompleteRequest(
    CompletionRef ref,
    CompleteArgument argument
) {

    /**
     * Creates a new completion request.
     */
    public CompleteRequest {
        if (ref == null) {
            throw new IllegalArgumentException("Ref cannot be null");
        }
        if (argument == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
    }

    /**
     * Reference to what is being completed.
     *
     * @param type the type of reference (e.g., "ref/prompt", "ref/resource")
     * @param name the name of the referenced item
     */
    public record CompletionRef(String type, String name) {
        public CompletionRef {
            if (type == null || type.isBlank()) {
                throw new IllegalArgumentException("Type cannot be null or blank");
            }
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be null or blank");
            }
        }
    }

    /**
     * Argument being completed.
     *
     * @param name  the name of the argument
     * @param value the current partial value
     */
    public record CompleteArgument(String name, String value) {
        public CompleteArgument {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be null or blank");
            }
            if (value == null) {
                throw new IllegalArgumentException("Value cannot be null");
            }
        }
    }
}

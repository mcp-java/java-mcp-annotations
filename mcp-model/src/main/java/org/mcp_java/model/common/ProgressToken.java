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
package org.mcp_java.model.common;

/**
 * A token used to track progress of long-running operations.
 * Can be either a string or a number.
 *
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic/utilities/progress">MCP Specification - Progress Token</a>
 */
public sealed interface ProgressToken permits ProgressToken.StringToken, ProgressToken.NumberToken {

    /**
     * String-based progress token.
     *
     * @param value the string value
     */
    record StringToken(String value) implements ProgressToken {
        public StringToken {
            if (value == null) {
                throw new IllegalArgumentException("Progress token value cannot be null");
            }
        }
    }

    /**
     * Number-based progress token.
     *
     * @param value the numeric value
     */
    record NumberToken(long value) implements ProgressToken {}

    /**
     * Creates a string-based progress token.
     *
     * @param value the string value
     * @return a new StringToken
     */
    static ProgressToken of(String value) {
        return new StringToken(value);
    }

    /**
     * Creates a number-based progress token.
     *
     * @param value the numeric value
     * @return a new NumberToken
     */
    static ProgressToken of(long value) {
        return new NumberToken(value);
    }
}

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
package org.mcp_java.server.progress;

/**
 * The progress token sent by the client in a request.
 * <p>
 * Progress tokens can be either strings or numbers, as defined by the MCP specification.
 * </p>
 *
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/basic/utilities/progress">MCP Specification - Progress</a>
 */
public interface ProgressToken {

    /**
     * Gets the type of this progress token.
     *
     * @return the token type
     */
    Type type();

    /**
     * Gets the token value as a number.
     *
     * @return the numeric value
     * @throws IllegalArgumentException if the token is not a number
     */
    Number asInteger();

    /**
     * Gets the token value as a string.
     *
     * @return the string representation
     */
    String asString();

    /**
     * The type of progress token.
     */
    public enum Type {
        /**
         * Integer/numeric token.
         */
        INTEGER,

        /**
         * String token.
         */
        STRING
    }
}

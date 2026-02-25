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
 * A unique identifier for a request in JSON-RPC.
 * Can be either a string or a number.
 *
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/schema#requestid">MCP Specification - Request ID</a>
 */
public sealed interface RequestId permits RequestId.StringId, RequestId.NumberId {

    /**
     * String-based request identifier.
     *
     * @param value the string value
     */
    record StringId(String value) implements RequestId {
        public StringId {
            if (value == null) {
                throw new IllegalArgumentException("Request ID value cannot be null");
            }
        }
    }

    /**
     * Number-based request identifier.
     *
     * @param value the numeric value
     */
    record NumberId(long value) implements RequestId {}

    /**
     * Creates a string-based request ID.
     *
     * @param value the string value
     * @return a new StringId
     */
    static RequestId of(String value) {
        return new StringId(value);
    }

    /**
     * Creates a number-based request ID.
     *
     * @param value the numeric value
     * @return a new NumberId
     */
    static RequestId of(long value) {
        return new NumberId(value);
    }
}

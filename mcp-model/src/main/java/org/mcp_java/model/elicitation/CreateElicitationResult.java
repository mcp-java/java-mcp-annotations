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
package org.mcp_java.model.elicitation;

import java.util.Map;

/**
 * Result of an elicitation request containing the user's responses.
 *
 * @param values the field values provided by the user (field name to value)
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/utilities/elicitation/#elicitation-result">MCP Specification - Elicitation Result</a>
 */
public record CreateElicitationResult(
    Map<String, String> values
) {

    /**
     * Creates a new elicitation result.
     */
    public CreateElicitationResult {
        if (values == null) {
            throw new IllegalArgumentException("Values cannot be null");
        }
    }

    /**
     * Creates an elicitation result.
     *
     * @param values the field values
     * @return new elicitation result
     */
    public static CreateElicitationResult of(Map<String, String> values) {
        return new CreateElicitationResult(values);
    }
}

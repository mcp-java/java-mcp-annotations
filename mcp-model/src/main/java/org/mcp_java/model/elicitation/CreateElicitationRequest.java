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

import java.util.List;

/**
 * Request to elicit user input.
 * Servers can use this to request additional information from the user through the client.
 *
 * @param prompt  the prompt to show to the user
 * @param fields  the fields to collect from the user
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/utilities/elicitation">MCP Specification - Elicitation</a>
 */
public record CreateElicitationRequest(
    String prompt,
    List<ElicitationField> fields
) {

    /**
     * Creates a new elicitation request.
     */
    public CreateElicitationRequest {
        if (prompt == null || prompt.isBlank()) {
            throw new IllegalArgumentException("Prompt cannot be null or blank");
        }
        if (fields == null || fields.isEmpty()) {
            throw new IllegalArgumentException("Fields cannot be null or empty");
        }
    }

    /**
     * Creates an elicitation request.
     *
     * @param prompt the prompt text
     * @param fields the fields to collect
     * @return new elicitation request
     */
    public static CreateElicitationRequest of(String prompt, List<ElicitationField> fields) {
        return new CreateElicitationRequest(prompt, fields);
    }
}

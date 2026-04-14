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
package org.mcp_java.server.tools;

import org.mcp_java.server.content.TextContent;

/**
 * Provides access to builders for Tool responses
 * <p>
 * This class can be injected as a parameter to a {@code @Tool}-annotated method, or using framework-specific mechanisms.
 */
public interface Tools {

    /**
     * Create a builder for a new {@link ToolResponse}
     * 
     * @return the new {@code ToolResponse} builder
     */
    ToolResponse.Builder newResult();

    /**
     * Creates a new {@code ToolResponse} with {@link ToolResponse#isError() isError} set to {@code true} and a {@link TextContent} containing the given error message.
     * 
     * @param error the error message
     * @return the tool result
     */
    ToolResponse newErrorResult(String error);

    /**
     * Creates a new successful {@link ToolResponse} with a single {@link TextContent}.
     *  
     * @param text the text content
     * @return the tool result
     */
    ToolResponse newTextResult(String text);

}

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

import static org.mcp_java.server.spi.McpServerSPILoader.getSPI;

import java.util.List;
import java.util.Optional;

import org.mcp_java.server.MetaCarrier;
import org.mcp_java.server.content.ContentBlock;

/**
 * The response to a tool call
 * <p>
 * The result can represent either success or an error. In both cases it can contain structured and
 * unstructured content.
 * <p>
 * Returning a {@code ToolResponse} from a {@link Tool}-annotated method gives more control over the
 * response that's returned to the client.
 */
public interface ToolResponse extends MetaCarrier {

    /**
     * The unstructured result data.
     * <p>
     * A tool call can return one or more unstructured {@link ContentBlock content} objects as the
     * result of a tool call.
     * 
     * @return the result contents
     */
    List<ContentBlock> content();

    /**
     * The structured response data.
     * <p>
     * Tools which declare an output schema return structured content. The structured content will
     * be converted to JSON using a platform-specific mechanism.
     * 
     * @return the structured content, or an empty {@code Optional} if there is no structured
     * content
     */
    Optional<Object> structuredContent();

    /**
     * Whether or not the tool call resulted in an error.
     * <p>
     * When a tool call results in an error, the content should describe the error.
     * 
     * @return {@code true} if the response represents an error, {@code false} otherwise
     */
    boolean isError();

    /**
     * Create a builder for a new {@code ToolResponse}
     *
     * @return the new {@code ToolResponse} builder
     */
    static ToolResponse.Builder builder() {
        return getSPI().toolResponseBuilder();
    }

    /**
     * Creates a new successful {@code ToolResponse} with a single text content block.
     *
     * @param text the text content
     * @return the new tool response
     */
    static ToolResponse ofText(String text) {
        return getSPI().newTextToolResponse(text);
    }

    /**
     * Creates a new error {@code ToolResponse} with a single text content block containing the error message.
     *
     * @param error the error message
     * @return the new tool response
     */
    static ToolResponse ofError(String error) {
        return getSPI().newErrorToolResponse(error);
    }

    /**
     * Creates a new successful {@code ToolResponse} with structured content.
     *
     * @param structuredContent the structured content
     * @return the new tool response
     */
    static ToolResponse ofStructured(Object structuredContent) {
        return getSPI().newStructuredToolResponse(structuredContent);
    }

    /**
     * Builder for creating tool responses
     */
    interface Builder extends MetaCarrier.Builder<Builder> {

        /**
         * Add some unstructured content to the response
         * 
         * @param content the unstructured content to add
         * @return this builder
         */
        Builder addContent(ContentBlock content);

        /**
         * Create a text content block from a string and add it to the response
         * 
         * @param textContent the text content to add
         * @return this builder
         */
        Builder addTextContent(String textContent);

        /**
         * Sets the structured content of the response
         * 
         * @param structuredContent the structured content
         * @return this builder
         */
        Builder setStructuredContent(Object structuredContent);

        /**
         * Sets whether or not the response represents an error
         * 
         * @param isError {@code true} if the response represents an error, {@code false} otherwise
         * @return this builder
         */
        Builder setError(boolean isError);

        /**
         * Builds the tool response
         * 
         * @return the new tool response
         */
        ToolResponse build();
    }
}

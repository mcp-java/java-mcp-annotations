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
package org.mcp_java.server.content;

import static org.mcp_java.server.spi.McpServerSPILoader.getSPI;

import java.util.Optional;

import org.mcp_java.server.MetaCarrier;

/**
 * Text content
 */
public non-sealed interface TextContent extends ContentBlock, SamplingMessageContentBlock {

    /**
     * Returns the text
     *
     * @return the text
     */
    String text();

    /**
     * Optional annotations for the client
     * 
     * @return the annotations
     */
    Optional<Annotations> annotations();

    /**
     * Creates a new builder for a {@code TextContent}
     * 
     * @param text the text
     * @return the text content builder
     */
    static TextContent.Builder builder(String text) {
        return getSPI().textContentBuilder(text);
    }

    /**
     * Creates a new {@code TextContent}
     * 
     * @param text the text
     * @return the new text content object
     */
    static TextContent of(String text) {
        return getSPI().newTextContent(text);
    }

    /**
     * Builder for creating text contents
     */
    interface Builder extends MetaCarrier.Builder<Builder> {

        /**
         * Sets the annotations for the content
         * 
         * @param annotations the annotations
         * @return this builder
         */
        Builder setAnnotations(Annotations annotations);

        /**
         * Builds the text content
         * 
         * @return the new text content
         */
        TextContent build();
    }
}

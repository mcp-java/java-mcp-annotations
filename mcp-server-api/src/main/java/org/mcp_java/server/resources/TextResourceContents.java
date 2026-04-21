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
package org.mcp_java.server.resources;

import static org.mcp_java.server.spi.McpServerSPILoader.getSPI;

/**
 * The content of a resource which contains text data.
 */
public non-sealed interface TextResourceContents extends ResourceContents {

    /**
     * The text data in the resource.
     * 
     * @return the data
     */
    String text();

    /**
     * Creates a new {@code TextResourceContents} with a URI and text.
     * 
     * @param uri the resource URI
     * @param text the text content
     * @return the new text resource
     */
    static TextResourceContents of(String uri, String text) {
        return getSPI().newTextResourceContents(uri, text);
    }

    /**
     * Creates a builder for a {@code TextResourceContents}
     * 
     * @param uri the resource URI
     * @param text the text content
     * @return the new text resource builder
     */
    static TextResourceContents.Builder builder(String uri, String text) {
        return getSPI().textResourceContentsBuilder(uri, text);
    }

    /**
     * Builder for creating text resource contents.
     */
    interface Builder extends ResourceContents.Builder<Builder> {

        /**
         * Builds the resource content object.
         * 
         * @return the new text resource content object
         */
        TextResourceContents build();
    }

}

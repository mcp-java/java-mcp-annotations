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
package org.mcp_java.model.content;

import org.mcp_java.model.common.Annotations;

/**
 * Text content block.
 *
 * @param type        the content type (always "text")
 * @param text        the text content
 * @param annotations optional annotations
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/tools#text-content">MCP Specification - Text Content</a>
 */
public record TextContent(
    String type,
    String text,
    Annotations annotations
) implements ContentBlock {

    /**
     * Creates a new text content block.
     */
    public TextContent {
        if (!"text".equals(type)) {
            throw new IllegalArgumentException("Type must be 'text'");
        }
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
    }

    /**
     * Creates a text content block without annotations.
     *
     * @param text the text content
     * @return a new text content block
     */
    public static TextContent of(String text) {
        return new TextContent("text", text, null);
    }

    /**
     * Creates a text content block with annotations.
     *
     * @param text        the text content
     * @param annotations the annotations
     * @return a new text content block
     */
    public static TextContent of(String text, Annotations annotations) {
        return new TextContent("text", text, annotations);
    }
}

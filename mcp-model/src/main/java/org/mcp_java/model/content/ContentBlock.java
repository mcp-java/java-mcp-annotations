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
 * Base interface for all content blocks.
 * Content blocks represent different types of content that can be exchanged in MCP.
 *
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/tools#tool-result">MCP Specification - Tool Result</a>
 */
public sealed interface ContentBlock permits TextContent, ImageContent, AudioContent, EmbeddedResource {

    /**
     * The type of this content block.
     *
     * @return the content type
     */
    String type();

    /**
     * Annotations providing additional context about this content.
     *
     * @return the annotations, or null if none
     */
    Annotations annotations();
}

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
 * Image content block.
 *
 * @param type        the content type (always "image")
 * @param data        the base64-encoded image data
 * @param mimeType    the MIME type of the image
 * @param annotations optional annotations
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/basic/messages/#image-content">MCP Specification - Image Content</a>
 */
public record ImageContent(
    String type,
    String data,
    String mimeType,
    Annotations annotations
) implements ContentBlock {

    /**
     * Creates a new image content block.
     */
    public ImageContent {
        if (!"image".equals(type)) {
            throw new IllegalArgumentException("Type must be 'image'");
        }
        if (data == null || data.isBlank()) {
            throw new IllegalArgumentException("Data cannot be null or blank");
        }
        if (mimeType == null || mimeType.isBlank()) {
            throw new IllegalArgumentException("MIME type cannot be null or blank");
        }
    }

    /**
     * Creates an image content block without annotations.
     *
     * @param data     the base64-encoded image data
     * @param mimeType the MIME type
     * @return a new image content block
     */
    public static ImageContent of(String data, String mimeType) {
        return new ImageContent("image", data, mimeType, null);
    }

    /**
     * Creates an image content block with annotations.
     *
     * @param data        the base64-encoded image data
     * @param mimeType    the MIME type
     * @param annotations the annotations
     * @return a new image content block
     */
    public static ImageContent of(String data, String mimeType, Annotations annotations) {
        return new ImageContent("image", data, mimeType, annotations);
    }
}

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
package org.mcp_java.model.resource;

import java.util.List;

/**
 * The contents of a resource.
 *
 * @param uri      the URI of the resource
 * @param mimeType the MIME type of the resource (optional)
 * @param text     text contents (for text resources)
 * @param blob     binary contents as base64 (for binary resources)
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/server/resources/#resource-contents">MCP Specification - Resource Contents</a>
 */
public record ResourceContents(
    String uri,
    String mimeType,
    String text,
    String blob
) {

    /**
     * Creates new resource contents.
     */
    public ResourceContents {
        if (uri == null || uri.isBlank()) {
            throw new IllegalArgumentException("URI cannot be null or blank");
        }
        if ((text == null && blob == null) || (text != null && blob != null)) {
            throw new IllegalArgumentException("Either text or blob must be present, but not both");
        }
    }

    /**
     * Creates text resource contents.
     *
     * @param uri  the resource URI
     * @param text the text content
     * @return new resource contents
     */
    public static ResourceContents text(String uri, String text) {
        return new ResourceContents(uri, null, text, null);
    }

    /**
     * Creates text resource contents with MIME type.
     *
     * @param uri      the resource URI
     * @param mimeType the MIME type
     * @param text     the text content
     * @return new resource contents
     */
    public static ResourceContents text(String uri, String mimeType, String text) {
        return new ResourceContents(uri, mimeType, text, null);
    }

    /**
     * Creates binary resource contents.
     *
     * @param uri  the resource URI
     * @param blob the base64-encoded binary data
     * @return new resource contents
     */
    public static ResourceContents blob(String uri, String blob) {
        return new ResourceContents(uri, null, null, blob);
    }

    /**
     * Creates binary resource contents with MIME type.
     *
     * @param uri      the resource URI
     * @param mimeType the MIME type
     * @param blob     the base64-encoded binary data
     * @return new resource contents
     */
    public static ResourceContents blob(String uri, String mimeType, String blob) {
        return new ResourceContents(uri, mimeType, null, blob);
    }

    /**
     * Checks if this resource contains text.
     *
     * @return true if text content is present
     */
    public boolean isText() {
        return text != null;
    }

    /**
     * Checks if this resource contains binary data.
     *
     * @return true if binary content is present
     */
    public boolean isBlob() {
        return blob != null;
    }
}

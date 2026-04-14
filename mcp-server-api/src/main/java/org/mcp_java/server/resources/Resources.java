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

/**
 * Provides access to builders for resource responses and contents.
 * <p>
 * This class can be injected as a parameter to a {@code @Resource}-annotated method, or using framework-specific mechanisms.
 */
public interface Resources {

    /**
     * Create a builder for a {@link ResourceResponse}
     * 
     * @return the new {@code ResourceResponse} builder
     */
    ResourceResponse.Builder responseBuilder();

    /**
     * Creates a new {@code ResourceResponse} with text content and no MIME type
     * 
     * @param uri the resource URI
     * @param text the text content
     * @return the new resource response
     */
    ResourceResponse textResponse(String uri, String text);

    /**
     * Creates a new {@code ResourceResponse} with text content and the given MIME type
     * 
     * @param uri the resource URI
     * @param text the text content
     * @param mimeType the MIME type
     * @return the new resource response
     */
    ResourceResponse textResponse(String uri, String text, String mimeType);

    /**
     * Creates a new {@code ResourceResponse} with binary content and no MIME type
     * 
     * @param uri the resource URI
     * @param blob the binary content
     * @return the new resource response
     */
    ResourceResponse blobResponse(String uri, char[] blob);

    /**
     * Creates a new {@code ResourceResponse} with binary content and the given MIME type
     * 
     * @param uri the resource URI
     * @param blob the binary content
     * @param mimeType the MIME type
     * @return the new resource response
     */
    ResourceResponse blobResponse(String uri, char[] blob, String mimeType);

    /**
     * Creates a builder for a {@link TextResourceContents}
     * 
     * @param uri the resource URI
     * @param text the text content
     * @return the new text resource builder
     */
    TextResourceContents.Builder textContentsBuilder(String uri, String text);

    /**
     * Creates a builder for a {@link BlobResourceContents}
     * 
     * @param uri the resource URI
     * @param data the binary content
     * @return the new text resource builder
     */
    BlobResourceContents.Builder blobContentsBuilder(String uri, byte[] data);
}

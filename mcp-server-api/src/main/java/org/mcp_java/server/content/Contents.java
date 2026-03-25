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

import org.mcp_java.server.resources.BlobResourceContents;
import org.mcp_java.server.resources.ResourceContents;
import org.mcp_java.server.resources.TextResourceContents;

/**
 * Provides methods to create {@link ContentBlock ContentBlocks} and {@link ResourceContents} for
 * use in constructing requests and responses.
 */
public interface Contents {

    /**
     * Creates a new builder for a {@link TextContent}
     * 
     * @param text the text
     * @return the text content builder
     */
    TextContent.Builder textContentBuilder(String text);

    /**
     * Creates a new builder for an {@link AudioContent}
     * 
     * @param data the audio data
     * @param mimeType the MIME type of the audio data
     * @return the audio content builder
     */
    AudioContent.Builder audioContentBuilder(byte[] data, String mimeType);

    /**
     * Creates a new builder for an {@link ImageContent}
     * 
     * @param data the image data
     * @param mimeType the MIME type of the image data
     * @return the image content builder
     */
    ImageContent.Builder imageContentBuilder(byte[] data, String mimeType);

    /**
     * Creates a new builder for an {@link EmbeddedResource} with {@link TextResourceContents}
     * 
     * @param text the text content for the embedded resource
     * @param uri the URI of the resource
     * @return the embedded resource builder
     */
    EmbeddedResource.Builder textResourceBuilder(String text, String uri);

    /**
     * Creates a new builder for an {@link EmbeddedResource} with {@link BlobResourceContents}
     * 
     * @param data the data for the embedded resource
     * @param uri the URI of the resource
     * @return the embedded resource builder
     */
    EmbeddedResource.Builder blobResourceBuilder(byte[] data, String uri);

    /**
     * Creates a new builder for a {@link ResourceLink}
     * 
     * @param name the name of the link
     * @param uri the URI of the target resource
     * @return the resource link builder
     */
    ResourceLink.Builder resourceLinkBuilder(String name, String uri);

    /**
     * Creates a new builder for an {@code Annotations}
     * 
     * @return the annotations builder
     */
    Annotations.Builder annotationsBuilder();
}

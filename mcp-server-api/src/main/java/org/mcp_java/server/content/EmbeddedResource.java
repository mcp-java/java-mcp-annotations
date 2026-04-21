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
import org.mcp_java.server.resources.BlobResourceContents;
import org.mcp_java.server.resources.ResourceContents;
import org.mcp_java.server.resources.TextResourceContents;

/**
 * Embedded resource content. This content block contains information about a resource, including
 * its data.
 * 
 * @see ResourceLink
 */
public non-sealed interface EmbeddedResource extends ContentBlock {

    /**
     * Returns the resource contents, which may be either {@link TextResourceContents} or
     * {@link BlobResourceContents}
     * 
     * @return the resource contents
     */
    ResourceContents resource();

    /**
     * Optional annotations for the client
     *
     * @return the annotations
     */
    Optional<Annotations> annotations();
    
    /**
     * Creates a new builder for an {@code EmbeddedResource} with {@link TextResourceContents}
     * 
     * @param text the text content for the embedded resource
     * @param uri the URI of the resource
     * @return the embedded resource builder
     */
    static EmbeddedResource.Builder builder(String text, String uri) {
        return getSPI().textEmbeddedResourceBuilder(text, uri);
    }

    /**
     * Creates a new builder for an {@code EmbeddedResource} with {@link BlobResourceContents}
     * 
     * @param data the data for the embedded resource
     * @param uri the URI of the resource
     * @return the embedded resource builder
     */
    static EmbeddedResource.Builder builder(byte[] data, String uri) {
        return getSPI().blobEmbeddedResourceBuilder(data, uri);
    }

    /**
     * Builder for an embedded resource
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
         * Sets the MIME type of the embedded resource
         * 
         * @param mimeType the MIME type
         * @return this builder
         */
        Builder setMimeType(String mimeType);

        /**
         * Adds a key value pair to the {@code _meta} entry of the
         * {@link EmbeddedResource#resource() resource contents}
         * 
         * @param key the meta key
         * @param value the value
         * @return this builder
         */
        Builder putResourceMeta(String key, Object value);

        /**
         * Builds the embedded resource content
         * 
         * @return the embedded resource content
         */
        EmbeddedResource build();
    }
}

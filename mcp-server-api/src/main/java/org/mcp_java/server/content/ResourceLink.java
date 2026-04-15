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

import java.util.Optional;
import java.util.OptionalLong;

import org.mcp_java.server.MetaCarrier;

/**
 * Content which links to a resource. Contains information about a resource, including its URI but
 * not the text or data within the resource.
 * 
 * @see EmbeddedResource
 */
public non-sealed interface ResourceLink extends ContentBlock {

    /**
     * Returns the name of the resource
     * 
     * @return the name of the resource
     */
    String name();

    /**
     * Returns a human-friendly name for the resource.
     * <p>
     * Defaults to {@link #name()} if not set
     * 
     * @return the human-readable name of the resource
     */
    String title();

    /**
     * The URI of the resource
     * 
     * @return the URI
     */
    String uri();

    /**
     * A description of the linked resource. May be used to help the LLM's understanding of
     * available resources
     * 
     * @return the resource description
     */
    Optional<String> description();

    /**
     * The MIME type of the linked resource
     * 
     * @return the MIME type
     */
    Optional<String> mimeType();

    /**
     * Optional annotations for the client
     *
     * @return the annotations
     */
    Optional<Annotations> annotations();

    /**
     * The size of the resource content, if known
     * 
     * @return the size of the resource content in bytes
     */
    OptionalLong size();

    /**
     * Creates a new builder for a {@link ResourceLink}
     * 
     * @param name the name of the link
     * @param uri the URI of the target resource
     * @return the resource link builder
     */
    ResourceLink.Builder builder(String name, String uri);

    /**
     * A builder for creating resource link contents
     */
    interface Builder extends MetaCarrier.Builder<Builder> {

        /**
         * Sets the human-friendly name for this resource
         * 
         * @param title the human-friendly name
         * @return this builder
         */
        Builder setTitle(String title);

        /**
         * Sets the description of this resource
         * 
         * @param description the description
         * @return this builder
         */
        Builder setDescription(String description);

        /**
         * Sets the MIME type of this resource, if known
         * 
         * @param mimeType the MIME type
         * @return this builder
         */
        Builder setMimeType(String mimeType);

        /**
         * Sets the annotations for the content
         * 
         * @param annotations the annotations
         * @return this builder
         */
        Builder setAnnotations(Annotations annotations);

        /**
         * Sets the size of the resource content
         * 
         * @param size the size in bytes
         * @return this builder
         */
        Builder setSize(long size);

        /**
         * Builds the resource link content
         * 
         * @return the new resource link content
         */
        ResourceLink build();
    }
}

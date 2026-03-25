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

import org.mcp_java.server.MetaCarrier;

/**
 * Image data content
 */
public non-sealed interface ImageContent extends ContentBlock, SamplingMessageContentBlock {

    /**
     * Returns the image data
     * 
     * @return the image data as a byte array
     */
    byte[] data();

    /**
     * Returns the MIME type of the image data
     * 
     * @return the MIME type
     */
    String mimeType();

    /**
     * Optional annotations for the client
     *
     * @return the annotations
     */
    Optional<Annotations> annotations();

    /**
     * Builder for creating image contents
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
         * Builds the image content
         * 
         * @return the new image content
         */
        ImageContent build();
    }

}

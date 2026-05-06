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

/**
 * Audio data content
 */
public non-sealed interface AudioContent extends ContentBlock, SamplingMessageContentBlock {

    /**
     * Returns the audio data
     * 
     * @return the audio data as a byte array
     */
    byte[] data();

    /**
     * Returns the MIME type of the audio data
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
     * Creates a new builder for an {@link AudioContent}
     * 
     * @param data the audio data
     * @param mimeType the MIME type of the audio data
     * @return the audio content builder
     */
    static AudioContent.Builder builder(byte[] data, String mimeType) {
        return getSPI().audioContentBuilder(data, mimeType);
    }

    /**
     * Creates a new {@code AudioContent}
     * 
     * @param data the audio data
     * @param mimeType the MIME type of the audio data
     * @return the new audio content
     */
    static AudioContent of(byte[] data, String mimeType) {
        return getSPI().newAudioContent(data, mimeType);
    }

    /**
     * Builder for creating audio contents
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
         * Builds the audio content
         * 
         * @return the new audio content
         */
        AudioContent build();
    }
}

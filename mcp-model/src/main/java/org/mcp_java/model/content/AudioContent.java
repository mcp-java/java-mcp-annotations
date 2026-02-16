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
 * Audio content block.
 *
 * @param type        the content type (always "audio")
 * @param data        the base64-encoded audio data
 * @param mimeType    the MIME type of the audio
 * @param annotations optional annotations
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/basic/messages/#audio-content">MCP Specification - Audio Content</a>
 */
public record AudioContent(
    String type,
    String data,
    String mimeType,
    Annotations annotations
) implements ContentBlock {

    /**
     * Creates a new audio content block.
     */
    public AudioContent {
        if (!"audio".equals(type)) {
            throw new IllegalArgumentException("Type must be 'audio'");
        }
        if (data == null || data.isBlank()) {
            throw new IllegalArgumentException("Data cannot be null or blank");
        }
        if (mimeType == null || mimeType.isBlank()) {
            throw new IllegalArgumentException("MIME type cannot be null or blank");
        }
    }

    /**
     * Creates an audio content block without annotations.
     *
     * @param data     the base64-encoded audio data
     * @param mimeType the MIME type
     * @return a new audio content block
     */
    public static AudioContent of(String data, String mimeType) {
        return new AudioContent("audio", data, mimeType, null);
    }

    /**
     * Creates an audio content block with annotations.
     *
     * @param data        the base64-encoded audio data
     * @param mimeType    the MIME type
     * @param annotations the annotations
     * @return a new audio content block
     */
    public static AudioContent of(String data, String mimeType, Annotations annotations) {
        return new AudioContent("audio", data, mimeType, annotations);
    }
}

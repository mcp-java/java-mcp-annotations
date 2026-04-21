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

package org.mcp_java.server.spi;

import java.util.List;
import java.util.ServiceLoader;

import org.mcp_java.server.Role;
import org.mcp_java.server.completion.CompletionResult;
import org.mcp_java.server.content.Annotations;
import org.mcp_java.server.content.AudioContent;
import org.mcp_java.server.content.ContentBlock;
import org.mcp_java.server.content.EmbeddedResource;
import org.mcp_java.server.content.ImageContent;
import org.mcp_java.server.content.ResourceLink;
import org.mcp_java.server.content.TextContent;
import org.mcp_java.server.prompts.PromptResponse;
import org.mcp_java.server.resources.BlobResourceContents;
import org.mcp_java.server.resources.ResourceResponse;
import org.mcp_java.server.resources.TextResourceContents;
import org.mcp_java.server.tools.ToolResponse;

/**
 * Factory interface for data objects and builders in the API.
 * <p>
 * Implementers must implement this interface and register their implementation to be loadable with
 * the {@link ServiceLoader#load(Class, ClassLoader)} and the classloader of {@code McpServerSPI}.
 * <p>
 * Users should use static constructor methods (e.g. {@link TextContent#of(String)} rather than this
 * interface and must not implement this interface.
 */
public interface McpServerSPI {

    /**
     * Create a new builder for a {@link CompletionResult}.
     * 
     * @return the new {@code CompletionResult} builder
     */
    CompletionResult.Builder completeResultBuilder();

    /**
     * Creates a new {@code CompletionResult} with a list of suggestions that is the complete set of
     * available suggestions.
     * 
     * @param values the list of suggestions
     * @return the new completion result
     */
    default CompletionResult newCompleteResult(List<String> values) {
        return completeResultBuilder().addValues(values)
                                      .setHasMore(false)
                                      .setTotal(values.size())
                                      .build();
    };

    /**
     * Creates a new {@code CompletionResult} with a list of suggestions that is not the complete
     * set of available suggestions.
     * 
     * @param values the list of suggestions
     * @return the new completion result
     */
    default CompletionResult newIncompleteResult(List<String> values) {
        return completeResultBuilder().addValues(values)
                                      .setHasMore(true)
                                      .build();
    }

    /**
     * Creates a new {@code CompletionResult} which includes a list of suggestions and the total
     * number of available suggestions.
     * 
     * @param values the list of suggestions
     * @param total the total number of available suggestions
     * @return the new completion result
     * @throws IllegalArgumentException if {@code total} is less than {@code values.size()}
     */
    default CompletionResult newResult(List<String> values, int total) {
        if (total < values.size()) {
            throw new IllegalArgumentException();
        }
        return completeResultBuilder().addValues(values)
                                      .setHasMore(total > values.size())
                                      .setTotal(total)
                                      .build();
    }

    /**
     * Creates a new builder for a {@link TextContent}
     * 
     * @param text the text
     * @return the text content builder
     */
    TextContent.Builder textContentBuilder(String text);

    /**
     * Creates a new {@code TextContent}
     * 
     * @param text the text
     * @return the new text content object
     */
    TextContent newTextContent(String text);

    /**
     * Creates a new builder for an {@link AudioContent}
     * 
     * @param data the audio data
     * @param mimeType the MIME type of the audio data
     * @return the audio content builder
     */
    AudioContent.Builder audioContentBuilder(byte[] data, String mimeType);

    /**
     * Creates a new {@code AudioContent}
     * 
     * @param data the audio data
     * @param mimeType the MIME type of the audio data
     * @return the new audio content
     */
    AudioContent newAudioContent(byte[] data, String mimeType);

    /**
     * Creates a new builder for an {@link ImageContent}
     * 
     * @param data the image data
     * @param mimeType the MIME type of the image data
     * @return the image content builder
     */
    ImageContent.Builder imageContentBuilder(byte[] data, String mimeType);

    /**
     * Creates a new {@code ImageContent}
     * 
     * @param data the image data
     * @param mimeType the MIME type of the image data
     * @return the new image content
     */
    ImageContent newImageContent(byte[] data, String mimeType);

    /**
     * Creates a new builder for an {@link EmbeddedResource} with {@link TextResourceContents}
     * 
     * @param text the text content for the embedded resource
     * @param uri the URI of the resource
     * @return the embedded resource builder
     */
    EmbeddedResource.Builder textEmbeddedResourceBuilder(String text, String uri);

    /**
     * Creates a new builder for an {@link EmbeddedResource} with {@link BlobResourceContents}
     * 
     * @param data the data for the embedded resource
     * @param uri the URI of the resource
     * @return the embedded resource builder
     */
    EmbeddedResource.Builder blobEmbeddedResourceBuilder(byte[] data, String uri);

    /**
     * Creates a new builder for a {@link ResourceLink}
     * 
     * @param name the name of the link
     * @param uri the URI of the target resource
     * @return the resource link builder
     */
    ResourceLink.Builder resourceLinkBuilder(String name, String uri);

    /**
     * Creates a new builder for an {@link Annotations}
     * 
     * @return the annotations builder
     */
    Annotations.Builder annotationsBuilder();

    /**
     * Create a builder for a new {@link PromptResponse}
     * 
     * @return the new {@link PromptResponse} builder
     */
    PromptResponse.Builder promptResponseBuilder();

    /**
     * Create a new {@link PromptResponse} with a single message
     * 
     * @param role the role for the message
     * @param content the content of the message
     * @return the new prompt response
     */
    default PromptResponse newPromptResponse(Role role, ContentBlock content) {
        return promptResponseBuilder().addMessage(role, content)
                                      .build();
    }

    /**
     * Create a builder for a {@link ResourceResponse}
     * 
     * @return the new {@code ResourceResponse} builder
     */
    ResourceResponse.Builder resourceResponseBuilder();

    /**
     * Creates a new {@code ResourceResponse} with text content and no MIME type
     * 
     * @param uri the resource URI
     * @param text the text content
     * @return the new resource response
     */
    default ResourceResponse resourceTextResponse(String uri, String text) {
        return resourceResponseBuilder().addContents(newTextResourceContents(uri, text))
                                        .build();
    }

    /**
     * Creates a new {@code ResourceResponse} with text content and the given MIME type
     * 
     * @param uri the resource URI
     * @param text the text content
     * @param mimeType the MIME type
     * @return the new resource response
     */
    default ResourceResponse resourceTextResponse(String uri, String text, String mimeType) {
        return resourceResponseBuilder().addContents(textResourceContentsBuilder(uri, text).setMimeType(mimeType)
                                                                                           .build())
                                        .build();
    }

    /**
     * Creates a new {@code ResourceResponse} with binary content and no MIME type
     * 
     * @param uri the resource URI
     * @param data the binary content
     * @return the new resource response
     */
    default ResourceResponse resourceBlobResponse(String uri, byte[] data) {
        return resourceResponseBuilder().addContents(newBlobResourceContent(uri, data))
                                        .build();
    }

    /**
     * Creates a new {@code ResourceResponse} with binary content and the given MIME type
     * 
     * @param uri the resource URI
     * @param data the binary content
     * @param mimeType the MIME type
     * @return the new resource response
     */
    default ResourceResponse resourceBlobResponse(String uri, byte[] data, String mimeType) {
        return resourceResponseBuilder().addContents(blobResourceContentsBuilder(uri, data).setMimeType(mimeType)
                                                                                           .build())
                                        .build();
    }

    /**
     * Creates a new {@link TextResourceContents} with a URI and text.
     *
     * @param uri the resource URI
     * @param text the text content
     * @return the new text resource
     */
    default TextResourceContents newTextResourceContents(String uri, String text) {
        return textResourceContentsBuilder(uri, text).build();
    }

    /**
     * Creates a builder for a {@link TextResourceContents}
     * 
     * @param uri the resource URI
     * @param text the text content
     * @return the new text resource builder
     */
    TextResourceContents.Builder textResourceContentsBuilder(String uri, String text);

    /**
     * Creates a new {@link BlobResourceContents} with a URI and data.
     * 
     * @param uri the resource URI
     * @param data the binary content
     * @return the new blob resource
     */
    default BlobResourceContents newBlobResourceContent(String uri, byte[] data) {
        return blobResourceContentsBuilder(uri, data).build();
    }

    /**
     * Creates a builder for a {@link BlobResourceContents}
     * 
     * @param uri the resource URI
     * @param data the binary content
     * @return the new blob resource builder
     */
    BlobResourceContents.Builder blobResourceContentsBuilder(String uri, byte[] data);

    /**
     * Create a builder for a new {@link ToolResponse}
     *
     * @return the new {@code ToolResponse} builder
     */
    ToolResponse.Builder toolResponseBuilder();

    /**
     * Creates a new successful {@link ToolResponse} with a single text content block.
     *
     * @param text the text content
     * @return the new tool response
     */
    default ToolResponse newTextToolResponse(String text) {
        return toolResponseBuilder().addTextContent(text)
                                    .setError(false)
                                    .build();
    }

    /**
     * Creates a new error {@link ToolResponse} with a single text content block containing the
     * error message.
     *
     * @param error the error message
     * @return the new tool response
     */
    default ToolResponse newErrorToolResponse(String error) {
        return toolResponseBuilder().addTextContent(error)
                                    .setError(true)
                                    .build();
    }

    /**
     * Creates a new successful {@link ToolResponse} with structured content.
     *
     * @param structuredContent the structured content
     * @return the new tool response
     */
    default ToolResponse newStructuredToolResponse(Object structuredContent) {
        return toolResponseBuilder().setStructuredContent(structuredContent)
                                    .setError(false)
                                    .build();
    }

}

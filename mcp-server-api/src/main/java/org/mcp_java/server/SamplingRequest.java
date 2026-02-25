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
package org.mcp_java.server;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.mcp_java.model.sampling.ModelPreferences;
import org.mcp_java.model.sampling.SamplingMessage;

/**
 * A request from the server to sample an LLM via the client.
 * <p>
 * Sampling requests allow servers to ask the client to generate text using
 * the client's LLM. This is useful for servers that need LLM capabilities
 * but don't have direct access to an LLM.
 * </p>
 *
 * @see Sampling
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/client/sampling">MCP Specification - Sampling</a>
 */
public interface SamplingRequest {

    /**
     * Gets the maximum number of tokens to sample.
     *
     * @return the maximum tokens
     */
    long maxTokens();

    /**
     * Gets the sampling messages (conversation history).
     *
     * @return the messages (never null)
     */
    List<SamplingMessage> messages();

    /**
     * Gets the stop sequences.
     *
     * @return the stop sequences, or null if not set
     */
    List<String> stopSequences();

    /**
     * Gets the system prompt.
     *
     * @return the system prompt, or null if not set
     */
    String systemPrompt();

    /**
     * Gets the temperature parameter for sampling.
     *
     * @return the temperature, or null if not set
     */
    BigDecimal temperature();

    /**
     * Gets the context inclusion setting.
     *
     * @return the context inclusion setting, or null if not set
     */
    IncludeContext includeContext();

    /**
     * Gets the model preferences.
     *
     * @return the model preferences, or null if not set
     */
    ModelPreferences modelPreferences();

    /**
     * Gets the optional metadata.
     *
     * @return the metadata map (never null, but may be empty)
     */
    Map<String, Object> metadata();

    /**
     * Sends the sampling request to the client asynchronously.
     * <p>
     * Framework implementations should return their native reactive type:
     * </p>
     * <ul>
     * <li>Quarkus: {@code Uni<SamplingResponse>}</li>
     * <li>Spring: {@code Mono<SamplingResponse>}</li>
     * <li>Standard Java: {@code CompletableFuture<SamplingResponse>}</li>
     * </ul>
     * <p>
     * If the client does not respond before the timeout, the result should fail
     * with a timeout exception.
     * </p>
     *
     * @param <T> the framework-specific reactive type
     * @return a reactive result that completes with the sampling response
     */
    <T> T send();

    /**
     * Sends the sampling request and waits synchronously for the result.
     * <p>
     * This method blocks until the client sends the response.
     * </p>
     * <p>
     * If the client does not respond before the timeout, this method throws
     * a timeout exception.
     * </p>
     *
     * @return the sampling response
     */
    SamplingResponse sendAndAwait();

    /**
     * Specifies which servers' context to include in the sampling request.
     */
    enum IncludeContext {
        /**
         * Include context from all connected servers.
         */
        ALL_SERVERS("allServers"),

        /**
         * Don't include any server context.
         */
        NONE("none"),

        /**
         * Include only this server's context.
         */
        THIS_SERVER("thisServer");

        private final String value;

        IncludeContext(String value) {
            this.value = value;
        }

        /**
         * Gets the JSON value for this context setting.
         *
         * @return the JSON value
         */
        public String getValue() {
            return value;
        }
    }

    /**
     * Builder for creating sampling requests.
     */
    interface Builder {

        /**
         * Adds a message to the conversation.
         *
         * @param message the message to add
         * @return this builder
         */
        Builder addMessage(SamplingMessage message);

        /**
         * Sets the maximum number of tokens to sample.
         *
         * @param maxTokens the maximum tokens
         * @return this builder
         */
        Builder setMaxTokens(long maxTokens);

        /**
         * Sets the temperature parameter.
         *
         * @param temperature the temperature value
         * @return this builder
         */
        Builder setTemperature(BigDecimal temperature);

        /**
         * Sets the system prompt.
         *
         * @param systemPrompt the system prompt
         * @return this builder
         */
        Builder setSystemPrompt(String systemPrompt);

        /**
         * Sets the context inclusion setting.
         *
         * @param includeContext the context setting
         * @return this builder
         */
        Builder setIncludeContext(IncludeContext includeContext);

        /**
         * Sets the model preferences.
         *
         * @param modelPreferences the model preferences
         * @return this builder
         */
        Builder setModelPreferences(ModelPreferences modelPreferences);

        /**
         * Sets the metadata.
         *
         * @param metadata the metadata map
         * @return this builder
         */
        Builder setMetadata(Map<String, Object> metadata);

        /**
         * Sets the stop sequences.
         *
         * @param stopSequences the stop sequences
         * @return this builder
         */
        Builder setStopSequences(List<String> stopSequences);

        /**
         * Sets the timeout for this request.
         * <p>
         * If no timeout is set, framework implementations should use their
         * default timeout configuration.
         * </p>
         *
         * @param timeout the timeout duration
         * @return this builder
         */
        Builder setTimeout(Duration timeout);

        /**
         * Builds the sampling request.
         *
         * @return a new sampling request
         */
        SamplingRequest build();
    }
}

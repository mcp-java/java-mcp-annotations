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

import java.time.Duration;
import java.util.Map;

/**
 * A request from the server to obtain additional information from the client.
 * <p>
 * Elicitation requests allow servers to ask the user (via the client) for additional
 * information using structured schemas.
 * </p>
 *
 * @see Elicitation
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/client/elicitation">MCP Specification - Elicitation</a>
 */
public interface ElicitationRequest {

    /**
     * Gets the message to display to the user.
     *
     * @return the message
     */
    String message();

    /**
     * Gets the requested schema defining the information to elicit.
     *
     * @return the schema as a map of field names to schemas
     */
    Map<String, PrimitiveSchema> requestedSchema();

    /**
     * Sends the elicitation request to the client asynchronously.
     * <p>
     * Framework implementations should return their native reactive type:
     * </p>
     * <ul>
     * <li>Quarkus: {@code Uni<ElicitationResponse>}</li>
     * <li>Spring: {@code Mono<ElicitationResponse>}</li>
     * <li>Standard Java: {@code CompletableFuture<ElicitationResponse>}</li>
     * </ul>
     *
     * @param <T> the framework-specific reactive type
     * @return a reactive result that completes with the response
     */
    <T> T send();

    /**
     * Sends the elicitation request and waits synchronously for the result.
     * <p>
     * This method blocks until the client sends the response.
     * </p>
     *
     * @return the elicitation response
     */
    ElicitationResponse sendAndAwait();

    /**
     * Builder for creating elicitation requests.
     */
    interface Builder {

        /**
         * Sets the message to display to the user.
         *
         * @param message the message
         * @return this builder
         */
        Builder setMessage(String message);

        /**
         * Adds a property to the requested schema.
         *
         * @param key the property name
         * @param schema the property schema
         * @return this builder
         */
        Builder addSchemaProperty(String key, PrimitiveSchema schema);

        /**
         * Sets the timeout for this request.
         *
         * @param timeout the timeout duration
         * @return this builder
         */
        Builder setTimeout(Duration timeout);

        /**
         * Builds the elicitation request.
         *
         * @return a new elicitation request
         */
        ElicitationRequest build();
    }

    /**
     * Base interface for primitive JSON schemas.
     * <p>
     * Framework implementations should provide concrete schema types that implement this interface.
     * </p>
     */
    interface PrimitiveSchema {
        /**
         * Checks if this field is required.
         *
         * @return true if required
         */
        boolean required();

        /**
         * Converts this schema to a JSON object representation.
         * <p>
         * Framework implementations should return their JSON type:
         * </p>
         * <ul>
         * <li>Quarkus/Vert.x: {@code JsonObject}</li>
         * <li>Jackson: {@code ObjectNode}</li>
         * <li>Others: {@code Map<String, Object>}</li>
         * </ul>
         *
         * @return the JSON representation
         */
        Object asJson();
    }
}

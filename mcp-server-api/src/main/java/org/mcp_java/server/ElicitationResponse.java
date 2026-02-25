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

import java.util.List;
import java.util.Map;

/**
 * A response to an {@link ElicitationRequest}.
 * <p>
 * The response includes an action (accept/decline/cancel) and content containing
 * the elicited values.
 * </p>
 *
 * @see ElicitationRequest
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/client/elicitation">MCP Specification - Elicitation</a>
 */
public interface ElicitationResponse {

    /**
     * Gets the action taken by the user.
     *
     * @return the action (never null)
     */
    Action action();

    /**
     * Gets the elicited content.
     *
     * @return the content (never null)
     */
    Content content();

    /**
     * Checks if the user accepted the elicitation request.
     *
     * @return true if action is ACCEPT
     */
    default boolean actionAccepted() {
        return action() == Action.ACCEPT;
    }

    /**
     * The action taken by the user in response to an elicitation request.
     */
    enum Action {
        /**
         * User accepted and provided the requested information.
         */
        ACCEPT,

        /**
         * User declined to provide the information.
         */
        DECLINE,

        /**
         * User cancelled the operation.
         */
        CANCEL
    }

    /**
     * The elicited content values.
     */
    interface Content {

        /**
         * Gets a boolean value from the elicited content.
         *
         * @param key the field name
         * @return the boolean value, or null if not present
         */
        Boolean getBoolean(String key);

        /**
         * Gets a string value from the elicited content.
         *
         * @param key the field name
         * @return the string value, or null if not present
         */
        String getString(String key);

        /**
         * Gets a list of string values from the elicited content.
         *
         * @param key the field name
         * @return the list of strings, or null if not present
         */
        List<String> getStrings(String key);

        /**
         * Gets an integer value from the elicited content.
         *
         * @param key the field name
         * @return the integer value, or null if not present
         */
        Integer getInteger(String key);

        /**
         * Gets a numeric value from the elicited content.
         *
         * @param key the field name
         * @return the number value, or null if not present
         */
        Number getNumber(String key);

        /**
         * Gets the content as a map.
         *
         * @return all elicited values as a map
         */
        Map<String, Object> asMap();
    }
}

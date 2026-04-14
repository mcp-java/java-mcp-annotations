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
package org.mcp_java.server;

import java.util.List;
import java.util.Optional;

/**
 * Represents an icon that can be associated with tools, resources, or prompts.
 */
public interface Icon {

    /**
     * Gets the source URI
     * 
     * @return the icon source URI
     */
    String src();

    /**
     * Gets the MIME type
     * 
     * @return the MIME type of the icon
     */
    Optional<String> mimeType();

    /**
     * Gets the sizes available for this icon
     * 
     * @return the list of sizes, may be empty
     */
    List<String> sizes();

    /**
     * The theme for this icon
     * 
     * @return the theme
     */
    Optional<Theme> theme();

    /**
     * The theme for an icon
     */
    public enum Theme {
        /**
         * Indicates this icon is appropriate for a light theme
         */
        LIGHT,
        /**
         * Indicates this icon is appropriate for a dark theme
         */
        DARK
    }
}

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

import static org.mcp_java.server.spi.McpServerSPILoader.getSPI;

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
    enum Theme {
        /**
         * Indicates this icon is appropriate for use with a light background
         */
        LIGHT,
        /**
         * Indicates this icon is appropriate for use with a dark background
         */
        DARK
    }

    /**
     * Creates a new {@code Icon}.
     * 
     * @param uri the icon URI
     * @param mimeType the icon MIME type
     * @return the new icon
     */
    static Icon of(String uri, String mimeType) {
        return getSPI().newIcon(uri, mimeType);
    }

    /**
     * Creates a builder for an {@code Icon}.
     * 
     * @param uri the icon URI
     * @return the new icon builder
     */
    static Icon.Builder builder(String uri) {
        return getSPI().iconBuilder(uri);
    }

    /**
     * Builder for creating icons.
     */
    interface Builder {

        /**
         * Sets the MIME type of the icon
         * 
         * @param mimeType the MIME type
         * @return this builder
         */
        Builder setMimeType(String mimeType);

        /**
         * Adds a size that this icon can be displayed at.
         * <p>
         * May not be used with {@link #setAnySize()}.
         * 
         * @param width the width
         * @param height the height
         * @return this builder
         */
        Builder addSize(int width, int height);

        /**
         * Sets that the icon may be used at any size. Usually for scalable icons.
         * <p>
         * May not be used with {@link #addSize(int, int)}.
         * 
         * @return this builder
         */
        Builder setAnySize();

        /**
         * Sets the theme that this icon is designed for.
         * 
         * @param theme the theme
         * @return this builder
         */
        Builder setTheme(Theme theme);

        /**
         * Builds the icon
         * 
         * @return the new icon
         */
        Icon build();
    }
}

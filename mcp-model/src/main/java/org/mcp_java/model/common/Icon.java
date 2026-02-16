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
package org.mcp_java.model.common;

import java.util.List;

/**
 * Represents an icon that can be associated with tools, resources, or prompts.
 *
 * @param src      the icon source URI (required)
 * @param mimeType the MIME type of the icon (optional)
 * @param sizes    list of sizes available for this icon (optional)
 * @param theme    the theme for this icon (optional)
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/basic/utilities/#icons">MCP Specification - Icons</a>
 */
public record Icon(
    String src,
    String mimeType,
    List<String> sizes,
    Theme theme
) {

    /**
     * Creates a new icon.
     */
    public Icon {
        if (src == null || src.isBlank()) {
            throw new IllegalArgumentException("Icon source cannot be null or blank");
        }
    }

    /**
     * Creates an icon with just source and MIME type.
     *
     * @param src      the icon source URI
     * @param mimeType the MIME type
     * @return a new icon
     */
    public static Icon of(String src, String mimeType) {
        return new Icon(src, mimeType, null, null);
    }

    /**
     * Creates an icon with source, MIME type, and theme.
     *
     * @param src      the icon source URI
     * @param mimeType the MIME type
     * @param theme    the theme
     * @return a new icon
     */
    public static Icon of(String src, String mimeType, Theme theme) {
        return new Icon(src, mimeType, null, theme);
    }

    /**
     * Theme for an icon.
     */
    public enum Theme {
        /**
         * Light theme variant.
         */
        LIGHT("light"),

        /**
         * Dark theme variant.
         */
        DARK("dark");

        private final String value;

        Theme(String value) {
            this.value = value;
        }

        /**
         * Gets the string value of this theme.
         *
         * @return the theme value
         */
        public String getValue() {
            return value;
        }

        /**
         * Parses a theme from its string value.
         *
         * @param value the string value
         * @return the corresponding Theme
         * @throws IllegalArgumentException if the value is not recognized
         */
        public static Theme fromValue(String value) {
            if (value == null) {
                return null;
            }
            for (Theme theme : values()) {
                if (theme.value.equalsIgnoreCase(value)) {
                    return theme;
                }
            }
            throw new IllegalArgumentException("Unknown theme: " + value);
        }
    }
}

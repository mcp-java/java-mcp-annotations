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

import java.util.regex.Pattern;

/**
 * A metadata key consisting of an optional prefix and a name.
 * <p>
 * Metadata keys follow a specific format:
 * </p>
 * <ul>
 * <li>Names must match: {@code [a-zA-Z0-9][a-zA-Z0-9_.-]*[a-zA-Z0-9]}</li>
 * <li>Prefixes must be dot-separated labels ending with {@code /}</li>
 * <li>Full key format: {@code prefix/name} or just {@code name}</li>
 * </ul>
 *
 * @param prefix the optional prefix (e.g., "modelcontextprotocol.io/")
 * @param name   the name segment
 * @see <a href="https://spec.modelcontextprotocol.io/specification/2025-11-05/basic/utilities/#metadata">MCP Specification - Metadata</a>
 */
public record MetaKey(String prefix, String name) {

    private static final Pattern NAME_PATTERN = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.-]*[a-zA-Z0-9]");
    private static final Pattern PREFIX_PATTERN = Pattern.compile("([a-zA-Z0-9][a-zA-Z0-9_.-]*[a-zA-Z0-9]\\.)*[a-zA-Z0-9][a-zA-Z0-9_.-]*[a-zA-Z0-9]/");

    /**
     * Creates a new metadata key.
     */
    public MetaKey {
        if (name == null || !NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(
                "Name must match pattern: [a-zA-Z0-9][a-zA-Z0-9_.-]*[a-zA-Z0-9], got: " + name);
        }
        if (prefix != null && !prefix.isEmpty() && !PREFIX_PATTERN.matcher(prefix).matches()) {
            throw new IllegalArgumentException(
                "Prefix must be dot-separated labels ending with /, got: " + prefix);
        }
    }

    /**
     * Parses a metadata key from a string.
     * <p>
     * If the string contains a {@code /}, the part before is treated as the prefix
     * and the part after as the name. Otherwise, the entire string is the name.
     * </p>
     *
     * @param key the key string (e.g., "modelcontextprotocol.io/myKey" or "myKey")
     * @return a new MetaKey
     */
    public static MetaKey from(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }

        int slashIndex = key.lastIndexOf('/');
        if (slashIndex > 0 && slashIndex < key.length() - 1) {
            String prefix = key.substring(0, slashIndex + 1);
            String name = key.substring(slashIndex + 1);
            return new MetaKey(prefix, name);
        } else {
            return new MetaKey(null, key);
        }
    }

    /**
     * Creates a metadata key with just a name.
     *
     * @param name the name
     * @return a new MetaKey
     */
    public static MetaKey of(String name) {
        return new MetaKey(null, name);
    }

    /**
     * Creates a metadata key with a prefix and name.
     * <p>
     * The prefix labels will be joined with dots and a trailing slash will be added.
     * </p>
     *
     * @param name          the name
     * @param prefixLabels  the prefix labels (e.g., "io", "myapp")
     * @return a new MetaKey
     */
    public static MetaKey of(String name, String... prefixLabels) {
        if (prefixLabels == null || prefixLabels.length == 0) {
            return new MetaKey(null, name);
        }
        String prefix = String.join(".", prefixLabels) + "/";
        return new MetaKey(prefix, name);
    }

    /**
     * Returns the full key string.
     * <p>
     * If a prefix is present, returns {@code prefix + name}, otherwise just {@code name}.
     * </p>
     *
     * @return the full key string
     */
    @Override
    public String toString() {
        return (prefix != null && !prefix.isEmpty()) ? prefix + name : name;
    }
}

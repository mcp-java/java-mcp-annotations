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

import java.util.Map;

/**
 * Super-interface for API types which include data in a {@code _meta} field.
 * <p>
 * Many objects in the model context protocol allow additional data to be sent in the {@code _meta}
 * field and this interface allows that data to be read.
 */
public interface MetaCarrier {

    /**
     * Gets the contents of {@code _meta}.
     * 
     * @return {@code _meta} as a {@code Map}
     */
    Map<String, Object> metadata();

    /**
     * Super-interface for builders which can include data in a {@code _meta} field.
     * 
     * @param <THIS> the builder type
     */
    public interface Builder<THIS extends Builder<THIS>> {

        /**
         * Adds a key value pair to the {@code _meta} entry of the object created by this builder.
         * 
         * @param key the key
         * @param value the value
         * @return this builder
         */
        THIS putMetadata(String key, Object value);

        /**
         * Sets the metadata, replacing any previously added metadata entries.
         *
         * @param metadata the metadata map
         * @return this builder
         */
        THIS setMetadata(Map<String, Object> metadata);
    }
}

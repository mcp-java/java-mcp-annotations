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

import org.mcp_java.model.content.ContentBlock;

/**
 * Encodes an object into MCP content.
 * <p>
 * Implementations of this interface can be registered to customize how tool results,
 * prompts, and resources are encoded into MCP content.
 * </p>
 *
 * @param <T> the type to encode
 */
public interface ContentEncoder<T> {

    /**
     * Encode the given object into MCP content.
     *
     * @param object the object to encode
     * @return the encoded content
     */
    ContentBlock encode(T object);

    /**
     * @return the type this encoder handles
     */
    Class<T> getType();
}

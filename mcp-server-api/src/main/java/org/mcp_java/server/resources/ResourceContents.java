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
package org.mcp_java.server.resources;

import java.util.Optional;

import org.mcp_java.server.MetaCarrier;

/**
 * The content of a resource, which can be {@link TextResourceContents text} or {@link BlobResourceContents binary} data.
 */
public sealed interface ResourceContents extends MetaCarrier permits TextResourceContents, BlobResourceContents {

    /**
     * Returns the URI of this resource.
     * 
     * @return the URI of the resource
     */
    String uri();

    /**
     * Returns the MIME type of this resource.
     * 
     * @return the MIME type of the resource, if provided, otherwise an empty {@code Optional}
     */
    Optional<String> mimeType();

    /**
     * Builder for creating resource contents. This interface shouldn't be used directly, one of its subclasses should be used instead.
     * 
     * @param <THIS> the builder type
     */
    interface Builder<THIS extends Builder<THIS>> extends MetaCarrier.Builder<THIS> {

        /**
         * Sets the MIME type of the resource
         * 
         * @param mimeType the MIME type
         * @return this builder
         */
        THIS setMimeType(String mimeType);
    }
}

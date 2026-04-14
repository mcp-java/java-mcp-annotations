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

import org.mcp_java.server.MetaCarrier;

/**
 * The content of a resource which contains binary data.
 * <p>
 * Instances of this interface can be created using {@link Resources}.
 */
public non-sealed interface BlobResourceContents extends MetaCarrier, ResourceContents {

    /**
     * The binary data of the resource.
     * 
     * @return the data
     */
    byte[] blob();

    /**
     * Builder for creating binary resource contents.
     */
    interface Builder extends MetaCarrier.Builder<Builder> {

        /**
         * Builds the resource content object.
         * 
         * @return the new binary resource content object
         */
        BlobResourceContents build();
    }
}

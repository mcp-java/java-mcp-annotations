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

import java.util.List;

import org.mcp_java.server.MetaCarrier;

/**
 * The result of a {@code resources/read} request.
 * <p>
 * Returning a {@code ResourceResponse} from a {@link Resource} or
 * {@link ResourceTemplate}-annotated method gives more control over the response that's
 * returned to the client.
 * <p>
 * Instances of this interface can be created using {@link Resources}.
 */
public interface ResourceResponse extends MetaCarrier {

    /**
     * The resource contents. Usually a response will contain a single content object.
     * 
     * @return the list of resource contents
     */
    List<ResourceContents> getContents();

    /**
     * Builder for creating resource read responses.
     */
    interface Builder extends MetaCarrier.Builder<Builder> {
        /**
         * Add a content object to the response. Usually a response will contain a single content
         * object.
         * 
         * @param contents the content object
         * @return this builder
         */
        Builder addContents(ResourceContents contents);

        /**
         * Builds the resource read response
         * 
         * @return the new resource read response
         */
        ResourceResponse build();
    }
}

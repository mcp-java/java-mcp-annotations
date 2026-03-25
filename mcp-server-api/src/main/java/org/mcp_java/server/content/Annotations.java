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
package org.mcp_java.server.content;

import java.time.Instant;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;

import org.mcp_java.server.Role;

/**
 * Annotations for content and resources to provide additional information
 */
public interface Annotations {

    /**
     * The intended audience for the data or object
     * 
     * @return the roles which make up the audience
     */
    Optional<Set<Role>> audience();

    /**
     * How important the data is.
     * <p>
     * {@code 1.0} indicates the greatest importance, {@code 0.0} indicates the least importance
     * 
     * @return the priority, between {@code 1.0} and {@code 0.0}
     */
    OptionalDouble priority();

    /**
     * When the data or object was last modified
     * 
     * @return the last modified timestamp
     */
    Optional<Instant> lastModified();

    /**
     * Builder for resource annotations
     */
    interface Builder {
        /**
         * Sets the intended audience for the content
         * 
         * @param roles the audience roles
         * @return this builder
         */
        Builder setAudience(Role... roles);

        /**
         * Sets the intended audience for the content
         * 
         * @param roles the set of audience roles
         * @return this builder
         */
        Builder setAudience(Set<Role> roles);

        /**
         * Sets the priority of the content to indicate its importance.
         * <p>
         * {@code 1.0} indicates the greatest importance, {@code 0.0} indicates the least importance
         * 
         * @param priority the priority, between {@code 1.0} and {@code 0.0}
         * @return this builder
         */
        Builder setPriority(double priority);

        /**
         * Sets when the content was last modified.
         * 
         * @param lastModified the last modified timestamp
         * @return this builder
         */
        Builder setLastModified(Instant lastModified);
    }
}

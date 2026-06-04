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

import java.util.List;
import java.util.Optional;

/**
 * Provides information about a client or server MCP implementation
 */
public interface ImplementationInfo {
    /**
     * Returns a list of icons for this implementation, may be empty
     * 
     * @return the list of icons
     */
    List<Icon> icons();

    /**
     * Returns the implementation name
     * 
     * @return the name
     */
    String name();

    /**
     * Returns a human-readable name for the implementation
     * 
     * @return the human readable name, may be the same as {@code name}
     */
    String title();

    /**
     * Returns the implementation version
     *
     * @return the implementation version
     */
    String version();

    /**
     * Returns a human readable description of the implementation
     * 
     * @return the description
     */
    Optional<String> description();

    /**
     * Returns the URL of the implementation's website
     * 
     * @return the implementation's URL
     */
    Optional<String> websiteUrl();
}
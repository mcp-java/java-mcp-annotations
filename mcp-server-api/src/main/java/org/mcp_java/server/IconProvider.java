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

import java.util.List;

/**
 * Provides icons for a prompt, resource, or tool.
 * <p>
 * The lifecycle of an {@code IconProvider} is implementation-specific. For example,
 * implementations may require an {@code IconProvider} to have a no-argument constructor,
 * or may require integration with a component framework.
 */
public interface IconProvider {
    
    /**
     * Returns a list of icons for an MCP server feature. The list may include various different
     * icons for the same feature for display at different sizes or for different themes.
     * 
     * @param featureType the type of feature to retrieve icons for (e.g. prompt, tool etc.)
     * @param name the name of the feature (i.e. the tool name, the prompt name etc.)
     * @return the list of icons, which may be empty if no icons are available
     */
    List<Icon> getIcons(FeatureType featureType, String name);

}

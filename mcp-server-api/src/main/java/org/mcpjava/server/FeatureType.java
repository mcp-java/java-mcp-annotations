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

package org.mcpjava.server;

import org.mcpjava.server.prompts.Prompt;
import org.mcpjava.server.resources.Resource;
import org.mcpjava.server.resources.ResourceTemplate;
import org.mcpjava.server.tools.Tool;

/**
 * The types of features that an MCP server implemented with this API can provide.
 */
public enum FeatureType {

    /**
     * A {@link Prompt}
     */
    PROMPT,
    /**
     * A {@link Resource}
     */
    RESOURCE,
    /**
     * A {@link ResourceTemplate}
     */
    RESOURCE_TEMPLATE,
    /**
     * A {@link Tool}
     */
    TOOL
}

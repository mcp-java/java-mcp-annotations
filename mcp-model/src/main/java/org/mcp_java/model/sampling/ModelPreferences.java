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
package org.mcp_java.model.sampling;

import java.util.List;

/**
 * Preferences for model selection in sampling.
 *
 * @param hints             hints about desired model characteristics (optional)
 * @param costPriority      priority for cost optimization (0-1, optional)
 * @param speedPriority     priority for speed (0-1, optional)
 * @param intelligencePriority priority for intelligence/capability (0-1, optional)
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/client/sampling#model-preferences">MCP Specification - Sampling Model Preferences</a>
 */
public record ModelPreferences(
    List<String> hints,
    Double costPriority,
    Double speedPriority,
    Double intelligencePriority
) {

    /**
     * Creates new model preferences.
     */
    public ModelPreferences {
        if (costPriority != null && (costPriority < 0 || costPriority > 1)) {
            throw new IllegalArgumentException("Cost priority must be between 0 and 1");
        }
        if (speedPriority != null && (speedPriority < 0 || speedPriority > 1)) {
            throw new IllegalArgumentException("Speed priority must be between 0 and 1");
        }
        if (intelligencePriority != null && (intelligencePriority < 0 || intelligencePriority > 1)) {
            throw new IllegalArgumentException("Intelligence priority must be between 0 and 1");
        }
    }
}

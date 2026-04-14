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
package org.mcp_java.server.sampling;

import java.util.List;
import java.util.Optional;

import org.mcp_java.server.MetaCarrier;
import org.mcp_java.server.Role;
import org.mcp_java.server.content.SamplingMessageContentBlock;

/**
 * A response to a {@link SamplingRequest}.
 * <p>
 * Contains the sampled content from the client's LLM along with metadata about
 * the model used and why sampling stopped.
 * </p>
 *
 * @see SamplingRequest
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/client/sampling">MCP Specification - Sampling</a>
 */
public interface SamplingResponse extends MetaCarrier {

    /**
     * Gets the sampled content
     * 
     * @return the sampled content (never null, never empty)
     */
    List<SamplingMessageContentBlock> content();

    /**
     * Gets the name of the model that generated the response
     * 
     * @return the name of the model that generated the response (never null)
     */
    String model();

    /**
     * Gets the role of the message sender
     * 
     * @return the role of the message sender (never null)
     */
    Role role();

    /**
     * Gets the reason why sampling stopped.
     * 
     * @return the reason why sampling stopped, or an empty {@code Optional} if not known
     */
    Optional<String> stopReason();
}

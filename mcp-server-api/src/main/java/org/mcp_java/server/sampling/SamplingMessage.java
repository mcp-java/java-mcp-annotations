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
package org.mcp_java.server.sampling;

import java.util.List;

import org.mcp_java.server.MetaCarrier;
import org.mcp_java.server.Role;
import org.mcp_java.server.content.SamplingMessageContentBlock;

/**
 * A message which is part of a {@link SamplingRequest}.
 */
public interface SamplingMessage extends MetaCarrier {

    /**
     * Returns the sender of the message
     * 
     * @return the message sender's role
     */
    Role role();

    /**
     * Gets the content of the message
     * 
     * @return the message content
     */
    List<SamplingMessageContentBlock> content();
}

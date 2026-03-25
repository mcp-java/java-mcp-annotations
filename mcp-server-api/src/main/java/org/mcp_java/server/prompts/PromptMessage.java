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
package org.mcp_java.server.prompts;

import org.mcp_java.server.Role;
import org.mcp_java.server.content.ContentBlock;

/**
 * A single message within a prompt.
 * <p>
 * A message consists of the message content, plus the role of the sender of the message.
 */
public interface PromptMessage {

    /**
     * The message sender
     * 
     * @return the role of the message sender
     */
    Role role();

    /**
     * The message content
     * 
     * @return the message content
     */
    ContentBlock content();
}

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
 * Provides access to builders for Prompt responses
 * <p>
 * This class can be injected as a parameter to a {@code @Prompt}-annotated method, or using framework-specific mechanisms.
 */
public interface Prompts {

    /**
     * Create a builder for a new {@link PromptResponse}
     * 
     * @return the new {@code PromptResponse} builder
     */
    PromptResponse.Builder newResponse();

    /**
     * Create a new {@link PromptResponse} with a single message with the given role and content
     * 
     * @param role the role
     * @param content the content
     * @return the new prompt response
     */
    PromptResponse newResponse(Role role, ContentBlock content);
}

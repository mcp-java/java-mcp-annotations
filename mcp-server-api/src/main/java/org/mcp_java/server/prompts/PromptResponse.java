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

import static org.mcp_java.server.spi.McpServerSPILoader.getSPI;

import java.util.List;
import java.util.Optional;

import org.mcp_java.server.MetaCarrier;
import org.mcp_java.server.Role;
import org.mcp_java.server.content.ContentBlock;

/**
 * Represents the result of a {@code prompts/get} call.
 * <p>
 * The result contains a list of messages which should be used to prompt the LLM.
 * <p>
 * Returning a {@code PromptResponse} from a {@link Prompt}-annotated method gives more control over
 * the response that's returned to the client.
 */
public interface PromptResponse extends MetaCarrier {

    /**
     * A description of the prompt
     * 
     * @return the description, or an empty {@code Optional} if not provided
     */
    Optional<String> description();

    /**
     * The prompt messages
     * 
     * @return the messages
     */
    List<PromptMessage> messages();

    /**
     * Create a builder for a new {cide PromptResponse}
     * 
     * @return the new {@code PromptResponse} builder
     */
    static PromptResponse.Builder builder() {
        return getSPI().promptResponseBuilder();
    }

    /**
     * Create a new {@code PromptResponse} with a single message
     * 
     * @param role the role for the message
     * @param content the content of the message
     * @return the new prompt response
     */
    static PromptResponse of(Role role, ContentBlock content) {
        return getSPI().newPromptResponse(role, content);
    }

    /**
     * Builder for creating a prompt response
     */
    interface Builder extends MetaCarrier.Builder<Builder> {

        /**
         * Set a description for the prompt
         * 
         * @param description the description
         * @return this builder
         */
        Builder setDescription(String description);

        /**
         * Add a message to the result
         * 
         * @param role the sender's role
         * @param content the content of the message
         * @return this builder
         */
        Builder addMessage(Role role, ContentBlock content);

        /**
         * Builds the prompt response
         * 
         * @return the new prompt response
         */
        PromptResponse build();
    }
}

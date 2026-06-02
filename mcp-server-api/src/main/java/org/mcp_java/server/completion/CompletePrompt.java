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
package org.mcp_java.server.completion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.mcp_java.server.Cancellation;
import org.mcp_java.server.McpConnection;
import org.mcp_java.server.progress.Progress;
import org.mcp_java.server.prompts.Prompt;

/**
 * Marks a method as providing completion suggestions for a prompt argument.
 * <p>
 * The annotated method returns completion values for a specific prompt argument.
 * 
 * <h2>Parameters</h2>
 * <p>
 * Prompt completion methods may have parameters of the following types:
 * <ul>
 * <li>{@link String} - the method must have exactly one {@code String} parameter representing
 * the partial value that needs to be completed. In most cases it must be annotated with {@link CompleteArg}
 * with the {@link CompleteArg#name() name} attribute set, unless the code was compiled with the
 * {@code -parameters} option. The name must match the name of one of the arguments of the related prompt.
 * <li>{@link CompletionContext} - to access values already chosen for other arguments
 * <li>{@link McpConnection} - to access information about the MCP connection
 * <li>{@link Cancellation} - to allow processing to be stopped if the client cancels the tool call
 * <li>{@link Progress} - to send progress reports back to the client
 * <li>Implementations may define additional types that can be used as parameters
 * </ul>
 * 
 * <h2>Return Type Handling</h2>
 * <p>
 * Return types can be:
 * <ul>
 * <li>{@code String} - single completion value</li>
 * <li>{@code List<String>} - multiple completion values</li>
 * <li>{@link CompletionResult} - full completion response with metadata</li>
 * <li>Other types - Encoded according to framework-specific rules</li>
 * </ul>
 * <p>
 * Example:
 * </p>
 * <pre>
 * &#64;CompletePrompt("myPrompt")
 * public List&lt;String&gt; completeMyPromptArg(&#64;CompleteArg(name = "value") String partialValue) {
 *     return List.of("option1", "option2", "option3");
 * }
 * </pre>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CompletePrompt {

    /**
     * The name of the prompt this completion method is for.
     * <p>
     * This must reference an existing {@link Prompt @Prompt} annotation's name.
     * </p>
     *
     * @return the prompt name
     */
    String value();
}

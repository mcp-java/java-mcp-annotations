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
package org.mcp_java.annotations.completion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a method as providing completion suggestions for a prompt argument.
 * <p>
 * The annotated method should return completion values for a specific prompt argument.
 * The method must consume exactly one {@link String} argument representing the
 * partial value that needs to be completed.
 * </p>
 * <p>
 * Return types can be:
 * </p>
 * <ul>
 * <li>{@code String} - single completion value</li>
 * <li>{@code List<String>} - multiple completion values</li>
 * <li>{@code CompletionResponse} - full completion response with metadata</li>
 * </ul>
 * <p>
 * Example:
 * </p>
 * <pre>
 * &#64;CompletePrompt("myPrompt")
 * public List&lt;String&gt; completeMyPromptArg(&#64;CompleteArg String partialValue) {
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
     * This must reference an existing {@code @Prompt} annotation's name.
     * </p>
     *
     * @return the prompt name
     */
    String value();
}

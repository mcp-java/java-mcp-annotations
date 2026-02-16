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
 * Marks a method as providing completion suggestions for a resource template URI expression.
 * <p>
 * The annotated method should return completion values for URI template variables.
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
 * &#64;CompleteResourceTemplate("fileTemplate")
 * public List&lt;String&gt; completeFilePath(&#64;CompleteArg String partialPath) {
 *     // Return matching file paths
 *     return findMatchingPaths(partialPath);
 * }
 * </pre>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CompleteResourceTemplate {

    /**
     * The name of the resource template this completion method is for.
     * <p>
     * This must reference an existing {@code @ResourceTemplate} annotation's name.
     * </p>
     *
     * @return the resource template name
     */
    String value();
}

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

package org.mcp_java.server;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates an {@link IconProvider} which can provide icons for the annotated Tool, Resource, Resource
 * Template or Prompt.
 * <p>
 * Note that the lifecycle of an {@code IconProvider} is implementation-specific. For example,
 * implementations may require an {@code IconProvider} to have a no-argument constructor,
 * or may require it to be looked up using a component framework.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, METHOD})
public @interface Icons {
    
    /**
     * The icon provider to use to retrieve icons for the annotated element
     * 
     * @return the icon provider class
     */
    Class<? extends IconProvider> iconProvider();
}

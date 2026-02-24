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
package org.mcp_java.annotations.resources;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Configures a parameter of a {@link ResourceTemplate} method.
 * <p>
 * This annotation allows you to customize the name of parameters that
 * correspond to URI template variables in resource templates.
 * </p>
 *
 * @see ResourceTemplate
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResourceTemplateArg {

    /**
     * Constant value for {@link #name()} indicating that the annotated element's name should be used as-is.
     */
    String ELEMENT_NAME = "<<element name>>";

    /**
     * The name of the URI template variable.
     * <p>
     * By default, the parameter name from the method signature will be used
     * (requires compilation with the {@code -parameters} flag).
     * </p>
     *
     * @return the template variable name
     */
    String name() default ELEMENT_NAME;
}

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
package org.mcp_java.model.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declares the execution models supported by a feature method.
 * <p>
 * This annotation can be applied to Tool, Prompt, Resource, and ResourceTemplate methods
 * to indicate which execution contexts they support.
 * </p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SupportedExecutionModels {

    /**
     * The supported execution models.
     *
     * @return array of supported execution models
     */
    ExecutionModel[] value() default {ExecutionModel.EVENT_LOOP, ExecutionModel.VIRTUAL_THREAD, ExecutionModel.WORKER_THREAD};
}

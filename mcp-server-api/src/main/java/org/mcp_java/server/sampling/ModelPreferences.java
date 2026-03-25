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
import java.util.OptionalDouble;

/**
 * Indicates the server's preferences for the model that should be used to complete a sampling
 * request.
 * <p>
 * Interpreting these preferences is up to the client, and they may ignore them altogether.
 */
public interface ModelPreferences {

    /**
     * A list of model names which should be used for sampling.
     * <p>
     * This may include full model names and substrings.
     * 
     * @return the list of model names, may be empty
     */
    List<String> names();

    /**
     * Indicates how much to prioritize cost when selecting a model, relative to
     * {@link #speedPriority() speed} and {@link #intelligencePriority() intelligence}.
     * 
     * @return a value between {@code 0} and {@code 1}, where {@code 0} means cost is not important
     * and {@code 1} means cost is very important, or an empty optional if not set
     */
    OptionalDouble costPriority();

    /**
     * Indicates how much to prioritize speed when selecting a model, relative to
     * {@link #costPriority() cost} and {@link #intelligencePriority() intelligence}.
     * 
     * @return a value between {@code 0} and {@code 1}, where {@code 0} means speed is not important
     * and {@code 1} means speed is very important, or an empty optional if not set
     */
    OptionalDouble speedPriority();

    /**
     * Indicates how much to prioritize intelligence when selecting a model, relative to
     * {@link #costPriority() cost} and {@link #speedPriority() speed}.
     * 
     * @return a value between {@code 0} and {@code 1}, where {@code 0} means intelligence is not
     * important and {@code 1} means intelligence is very important, or an empty optional if not set
     */
    OptionalDouble intelligencePriority();

    /**
     * Builder for creating model preferences objects
     */
    interface Builder {

        /**
         * Add a name to the list of model names which should be used for sampling.
         * <p>
         * This may include full model names and substrings.
         * 
         * @param name the model name to add
         * @return this builder
         */
        Builder addName(String name);

        /**
         * Sets how much to prioritize cost when selecting a model, relative to
         * {@link #speedPriority() speed} and {@link #intelligencePriority() intelligence}.
         * 
         * @param costPriority a value between {@code 0} and {@code 1}, where {@code 0} means cost
         *     is not important and {@code 1} means cost is very important
         * @return this builder
         */
        Builder setCostPriority(double costPriority);

        /**
         * Sets how much to prioritize speed when selecting a model, relative to
         * {@link #costPriority() cost} and {@link #intelligencePriority() intelligence}.
         * 
         * @param speedPriority a value between {@code 0} and {@code 1}, where {@code 0} means speed
         *     is not important and {@code 1} means speed is very important
         * @return this builder
         */
        Builder setSpeedPriority(double speedPriority);

        /**
         * Sets how much to prioritize intelligence when selecting a model, relative to
         * {@link #costPriority() cost} and {@link #speedPriority() speed}.
         * 
         * @param intelligencePriority a value between {@code 0} and {@code 1}, where {@code 0}
         *     means intelligence is not important and {@code 1} means intelligence is very
         *     important
         * @return this builder
         */
        Builder setIntelligencePriority(double intelligencePriority);

        /**
         * Builds the model preferences object.
         * 
         * @return the new model preferences object
         */
        ModelPreferences build();
    }
}

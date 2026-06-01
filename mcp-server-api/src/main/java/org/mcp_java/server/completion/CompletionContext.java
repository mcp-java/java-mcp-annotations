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

package org.mcp_java.server.completion;

import java.util.Optional;

/**
 * Provides access to values for other arguments that the user has already completed
 * <p>
 * Where a prompt or a resource template has multiple arguments, the valid completions for one argument can be affected by the values already selected for another argument.
 * <p>
 * This interface can be accepted as a parameter to a {@link CompletePrompt} or {@link CompleteResourceTemplate}-annotated method and used to access values for other arguments.
 * 
 * <h2>Example</h2>
 * <p>
 * The {@code city-data} resource template needs arguments for the city and country. When completing the city name, the country name should be taken into account if the user has already provided it.
 * 
 * <pre>{@code
 * @ResourceTemplate(name = "city-data", uriTemplate = "http://example.org/locationdata/{country}/{city}")
 * public String getCityData(@ResourceTemplateArg(name = "country") String country,
 *                           @ResourceTemplateArg(name = "city") String city) {
 *     return cities.find(country, city);
 * }
 * 
 * @CompleteResourceTemplate("city-data")
 * public List<String> completeCity(@CompleteArg(name = "city") String partialCity,
 *                                  CompletionContext context) {
 *     return context.getArgument("country")
 *                     .map(country -> cities.startingWith(country, partialCity))
 *                     .orElseGet(() -> cities.startingWith(partialCity));
 * }
 * }</pre>
 */
public interface CompletionContext {

    /**
     * Returns the value assigned to the named argument, if the user has provided it.
     * 
     * @param name the name of the argument
     * @return the value of the argument, if provided
     */
    Optional<String> getArgument(String name);
}

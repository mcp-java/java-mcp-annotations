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
package org.mcp_java.server;

import java.util.List;

import org.mcp_java.model.roots.Root;

/**
 * Provides access to the client's root directories.
 * <p>
 * If an MCP client supports the roots capability, the server can obtain the list
 * of root objects that define the client's filesystem or resource roots.
 * </p>
 * <p>
 * Example usage:
 * </p>
 * <pre>
 * &#64;Tool(description = "List available roots")
 * public String listRoots(Roots roots) {
 *     if (roots.isSupported()) {
 *         List&lt;Root&gt; rootList = roots.listAndAwait();
 *         return rootList.stream()
 *             .map(r -> r.name() + ": " + r.uri())
 *             .collect(Collectors.joining("\n"));
 *     }
 *     return "Roots not supported";
 * }
 * </pre>
 *
 * @see Root
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/client/roots">MCP Specification - Roots</a>
 */
public interface Roots {

    /**
     * Checks if the client supports the roots capability.
     *
     * @return true if the client supports roots, false otherwise
     */
    boolean isSupported();

    /**
     * Sends a {@code roots/list} message to the client asynchronously.
     * <p>
     * Framework implementations should return their native reactive type:
     * </p>
     * <ul>
     * <li>Quarkus: {@code Uni<List<Root>>}</li>
     * <li>Spring: {@code Mono<List<Root>>}</li>
     * <li>Standard Java: {@code CompletableFuture<List<Root>>}</li>
     * </ul>
     *
     * @param <T> the framework-specific reactive type
     * @return a reactive result that completes with the list of roots
     * @throws IllegalStateException if the client does not support roots
     */
    <T> T list();

    /**
     * Sends a {@code roots/list} message and waits synchronously for the result.
     * <p>
     * This method blocks until the client sends the response.
     * </p>
     *
     * @return the list of roots
     * @throws IllegalStateException if the client does not support roots
     */
    List<Root> listAndAwait();
}

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

/**
 * Mechanism for providing the implementation of the API.
 * <p>
 * Implementations should implement {@link org.mcp_java.server.spi.McpServerSPI} and make it
 * loadable via {@link java.util.ServiceLoader}.
 * <p>
 * Users should not use this package.
 */
package org.mcp_java.server.spi;
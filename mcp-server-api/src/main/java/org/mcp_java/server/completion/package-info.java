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
 * Provide auto-completion functionality to the client.
 * <p>
 * Completion annotations allow you to define methods that provide completion
 * suggestions for prompt arguments and resource template URI expressions.
 * Use {@link org.mcp_java.server.completion.CompletePrompt @CompletePrompt} for prompt
 * completions and {@link org.mcp_java.server.completion.CompleteResourceTemplate @CompleteResourceTemplate}
 * for resource template completions.
 * <p>
 * Use {@link org.mcp_java.server.completion.Completions Completions} to start building
 * {@link org.mcp_java.server.completion.CompletionResult CompletionResults} which can be returned
 * from {@code @CompletePrompt} or {@code @CompleteResourceTemplate} annotated methods.
 * 
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/server/utilities/completion">MCP Specification - Completion</a>
 */
package org.mcp_java.server.completion;
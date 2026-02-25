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

package org.mcp_java.model.tool;

/**
 * Additional information about the properties of a tool, provided as hints for clients.
 * 
 * @param title optional human-readable name for the tool
 * @param readOnlyHint {@code true} if the tool does not modify its environment, {@code false} otherwise. Assumed {@code false} if not set.
 * @param destructiveHint {@code true} if the code may perform destructive updates, {@code false otherwise}. Assumed {@code true} if not set.
 * @param idempotentHint {@code true} if calling the tool twice with the same arguments will not have additional effects on its environment, {@code false} otherwise. Assumed {@code false} if not set.
 * @param openWorldHint {@code true} if the tool may interact with an "open world" of external entities, {@code false} otherwise. Assumed {@code true} if not set.
 * @see <a href="https://modelcontextprotocol.io/specification/2025-11-25/schema#toolannotations">MCP Schema Reference - ToolAnnotations</a>
 */
public record ToolAnnotations(
		String title,
		Boolean readOnlyHint,
		Boolean destructiveHint,
		Boolean idempotentHint,
		Boolean openWorldHint) {
}

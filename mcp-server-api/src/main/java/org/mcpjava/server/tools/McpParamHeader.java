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
package org.mcpjava.server.tools;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Tells clients to mirror a tool argument into an HTTP request header. This annotation must be added to a parameter of a tool method,
 * usually alongside {@link ToolArg}.
 * <p>
 * When this annotation is used, the server sets the property {@code x-mcp-header} to {@link #value()}
 * in the parameter schema. This instructs clients to include a {@code Mcp-Param-<value>} HTTP
 * header with the value of this parameter when calling the tool.
 * <p>
 * This can be used to allow intermediaries such as gateways and load balancers to route or inspect
 * the call without parsing the body.
 * <p>
 * The annotated parameter must have a type that is represented as a {@code string}, {@code integer} or {@code boolean}. Integer values
 * must be in the range -2<sup>53</sup>+1 to 2<sup>53</sup>-1 (the range of integers that can be represented exactly by an IEEE 754
 * double). Note that this is smaller than the range allowed by {@code long}.
 * <p>
 * This functionality is only available when using the <strong>Streamable HTTP transport</strong> and <strong>protocol version
 * {@code 2026-07-28} or later</strong>. Behaviour when using a different transport or protocol version is framework-specific.
 * <p>
 * Avoid annotating parameters that carry sensitive data, such as passwords, API keys, tokens or
 * personal information, since intermediaries may store and log the value.
 *
 * <h2>Example</h2>
 *
 * <pre>{@code
 * @Tool(name = "runQuery")
 * List<Row> runQuery(
 *     @ToolArg(name = "region", description = "The region to execute the query in")
 *     @McpParamHeader("Region") String region,
 *     @ToolArg(name = "query") String query) {
 *     // ...
 * }
 * }</pre>
 * <p>
 * If a client called this tool with {@code region} set to {@code "eu1"}, it would also send an HTTP header {@code Mcp-Param-Region: eu1}.
 *
 * @see ToolArg
 * @see <a href="https://modelcontextprotocol.io/specification/2026-07-28/server/tools#x-mcp-header">MCP
 * Specification - Tools - x-mcp-header</a>
 * @since 1.1
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface McpParamHeader {

    /**
     * The name appended to {@code Mcp-Param-} to make the request header name.
     * <p>
     * This value is used for the {@code x-mcp-header} property in the parameter schema, which instructs clients to send the argument
     * value in an {@code Mcp-Param-<value>} request header.
     * <p>
     * This value must be:
     * <ul>
     * <li>A valid HTTP header name (see <a href="https://datatracker.ietf.org/doc/html/rfc9110#section-5.1">RFC 9110 Section 5.1</a>)
     * <li>Case-insensitively unique among the parameters of the tool
     * </ul>
     * <p>
     * Clients using Streamable HTTP must exclude tools with invalid {@code x-mcp-header} properties. Implementations should therefore
     * validate designations when registering tools, so developers can identify mistakes early.
     *
     * @return the header name suffix
     */
    String value();
}

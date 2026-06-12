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
package org.mcp_java.server.test;

import org.mcp_java.server.prompts.Prompt;
import org.mcp_java.server.prompts.PromptArg;
import org.mcp_java.server.resources.Resource;
import org.mcp_java.server.tools.Tool;
import org.mcp_java.server.tools.ToolArg;

/**
 * Example code from README
 */
public class MyMcpServer {

    @Tool(
        name = "calculate",
        description = "Perform a calculation"
    )
    public int calculate(
            @ToolArg(name = "a", description = "First number") int a,
            @ToolArg(name = "b", description = "Second number") int b) {
        return a + b;
    }

    @Resource(
        uri = "config://settings",
        name = "Application Settings",
        description = "Current application configuration"
    )
    public String getSettings() {
        return "{ \"theme\": \"dark\", \"language\": \"en\" }";
    }

    @Prompt(
        name = "greet",
        description = "Generate a greeting message"
    )
    public String greet(@PromptArg(name = "name") String name) {
        return "Hello, " + name + "!";
    }
}
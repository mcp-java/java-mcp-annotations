# Java MCP Annotations & APIs

A framework-agnostic Java library providing core annotations and APIs for implementing [Model Context Protocol (MCP)](https://modelcontextprotocol.io) servers and clients.

## Overview

This repository provides common Java building blocks for MCP implementations without tying you to any specific runtime framework (Spring, Quarkus, Micronaut, WildFly, Open Liberty, etc.). It enables developers to create portable MCP integrations that can work across different Java ecosystems.

### What is MCP?

The Model Context Protocol (MCP) is an open protocol that standardizes how applications provide context to Large Language Models (LLMs). It enables secure, controlled interactions between AI assistants and data sources, tools, and services.

## Project Structure

### `mcp-server-api`
Framework-agnostic annotations and interfaces for declaratively building MCP servers:

**Tools**:
- `@Tool` - Mark methods as MCP tools
- `@ToolArg` - Configure tool parameters

Package: `org.mcpjava.server.tools`

**Resources**:
- `@Resource` - Expose static resources
- `@ResourceTemplate` - Expose dynamic resources with URI templates
- `@ResourceTemplateArg` - Configure template URI variables

Package: `org.mcpjava.server.resources`

**Prompts**:
- `@Prompt` - Define reusable prompt templates
- `@PromptArg` - Configure prompt arguments

Package: `org.mcpjava.server.prompts`

**Completion**:
- `@CompletePrompt` - Provide completion for prompt arguments
- `@CompleteResourceTemplate` - Provide completion for resource template URIs
- `@CompleteArg` - Customize completion argument names

Package: `org.mcpjava.server.completion`

**Core**:
- `@McpServer` - Mark classes as MCP server components
- `@MetaField` - Add custom metadata to definitions
- `Cancellation` - Interface for handling request cancellation
- `ContentEncoder<T>` - Interface for custom content encoding
- `ClientCapability` - Representation of client capabilities

Package: `org.mcpjava.server`

## Design Principles

- **Framework Agnostic**: Zero dependencies on Spring, Quarkus, or other frameworks
- **Portable**: Use these annotations and interfaces with any Java runtime
- **Extensible**: Framework-specific implementations can build on these foundations
- **Standards-Based**: Fully aligned with the official MCP specification
- **Modern Java**: Uses Java 17+ features (records, sealed interfaces, etc.)

## Getting Started

> **Note**: This project provides the foundational annotations and interfaces. Framework-specific runtime implementations (connection handling, JSON-RPC processing, etc.) are provided by separate projects like [Quarkus MCP Server](https://github.com/quarkiverse/quarkus-mcp-server).

### Requirements

- Java 17 or higher
- Maven 3.9+

### Building

```bash
mvn clean install
```

### Running Tests

```bash
mvn test
```

## Usage Example

Here's a simple example of using the annotations:

```java
import org.mcpjava.server.prompts.Prompt;
import org.mcpjava.server.prompts.PromptArg;
import org.mcpjava.server.resources.Resource;
import org.mcpjava.server.tools.Tool;
import org.mcpjava.server.tools.ToolArg;

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
```

Framework implementations will process these annotations and expose them via the MCP protocol.

## Relationship to Other Projects

This library is inspired by and designed to be compatible with:
- [Quarkus MCP Server](https://github.com/quarkiverse/quarkus-mcp-server) - Quarkus-specific MCP implementation
- [OpenMCPTools](https://github.com/OpenMCPTools) - Collection of MCP tools and integrations

Framework-specific extensions can build on these core annotations to provide runtime-specific features like dependency injection, lifecycle management, and protocol handling.

## Contributing

We welcome contributions! This project aims to serve the broader Java MCP ecosystem.

### How to Contribute

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/amazing-feature`)
3. **Commit** your changes (`git commit -m 'Add some amazing feature'`)
4. **Push** to the branch (`git push origin feature/amazing-feature`)
5. **Open** a Pull Request

### Development Guidelines

- Maintain framework independence - no framework-specific dependencies
- Follow Java naming conventions and code style
- Add tests for new functionality
- Update documentation as needed
- Keep the API surface minimal and focused

## Continuous Integration

This project uses GitHub Actions for continuous integration, running:
- Compilation checks
- Unit and integration tests
- Code quality analysis

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.



package org.mcp_java.model.common;

/**
 * An execution model of a feature method.
 *
 * @see org.mcp_java.model.tool.Tool
 * @see org.mcp_java.model.prompt.Prompt
 * @see org.mcp_java.model.resource.Resource
 */
public enum ExecutionModel {

    /**
     * Feature is considered blocking and should be executed on a worker thread.
     */
    WORKER_THREAD,

    /**
     * Feature is considered blocking and should be executed on a virtual thread.
     */
    VIRTUAL_THREAD,

    /**
     * Feature method is considered non-blocking and should be executed on an event loop thread.
     */
    EVENT_LOOP

}

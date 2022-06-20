package com.example.csvviewer1.interactor;

import com.example.csvviewer1.model.ExecutionParameterContainer;

public class GetExecutionParamContainerInteractor {

    private static final int DEFAULT_PAGE_SIZE = 3;

    public static ExecutionParameterContainer getExecutionParamContainer(String[] args) {
        ExecutionParameterContainer executionParameterContainer = new ExecutionParameterContainer();
        executionParameterContainer.setFilePath(args[0]);
        int pageSize = args.length > 1 ? Integer.parseInt(args[1]) : DEFAULT_PAGE_SIZE;
        executionParameterContainer.setPageSize(pageSize);
        return executionParameterContainer;
    }
}

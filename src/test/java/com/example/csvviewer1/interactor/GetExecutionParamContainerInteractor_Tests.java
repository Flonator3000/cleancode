package com.example.csvviewer1.interactor;

import com.example.csvviewer1.model.ExecutionParameterContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GetExecutionParamContainerInteractor_Tests {

    @Test
    void getExecutionParamContainer_inputParams_correctResult() {
        // Act
        String filePath = "src/test/persons.csv";
        String[] args = new String[]{filePath, "4"};

        // Arrange
        ExecutionParameterContainer executionParameterContainer = GetExecutionParamContainerInteractor.getExecutionParamContainer(args);

        // Assert
        assertEquals(filePath, executionParameterContainer.getFilePath());
        assertEquals(4, executionParameterContainer.getPageSize());
    }

}



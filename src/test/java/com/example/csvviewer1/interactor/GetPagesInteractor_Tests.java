package com.example.csvviewer1.interactor;

import com.example.csvviewer1.model.ExecutionParameterContainer;
import com.example.csvviewer1.model.Page;
import com.example.csvviewer1.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GetPagesInteractor_Tests {

    @Test
    void getPages_inputParameters_correctResult() throws IOException {
        // Arrange
        ExecutionParameterContainer executionParameterContainer = new ExecutionParameterContainer();
        executionParameterContainer.setFilePath("src/test/resources/persons.csv");
        executionParameterContainer.setPageSize(3);

        // Act
        ArrayList<Page> pages = GetPagesInteractor.getPages(executionParameterContainer);

        // Assert
        assertEquals(pages.size(), 3);
        assertEquals(pages.get(0).getPersons().size(), 3);
        assertEquals(pages.get(2).getPersons().size(), 1);
    }
}

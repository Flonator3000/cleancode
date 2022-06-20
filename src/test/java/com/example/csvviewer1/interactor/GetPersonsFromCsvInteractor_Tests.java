package com.example.csvviewer1.interactor;

import com.example.csvviewer1.model.ExecutionParameterContainer;
import com.example.csvviewer1.model.Page;
import com.example.csvviewer1.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GetPersonsFromCsvInteractor_Tests {

    @Test
    void getPersonsFromCsv_validCsv_correctResponse() throws IOException {
        // Arrange
        String filePath = "src/test/resources/persons.csv";

        // Act
        ArrayList<Person> persons = GetPersonsFromCsvInteractor.getPersonsFromCsv(filePath);

        // Assert
        assertEquals(persons.size(), 7);
        assertEquals(persons.get(0).getName(), "Peter");
        assertEquals(persons.get(1).getAge(), 57);
        assertEquals(persons.get(2).getCity(), "Munich");
    }

}

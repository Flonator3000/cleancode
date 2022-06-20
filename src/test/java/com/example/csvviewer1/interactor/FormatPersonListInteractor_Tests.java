package com.example.csvviewer1.interactor;

import com.example.csvviewer1.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FormatPersonListInteractor_Tests {

    @Test
    void formatPersonList_inputPersons_correctResponse() {
        // Arrange
        ArrayList<Person> persons = new ArrayList<>();
        Person person1 = new Person("Peter", 42, "New York");
        Person person2 = new Person("Paul", 57, "London");
        Person person3 = new Person("Mary", 35, "Munich");
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        //Act
        String result = FormatPersonListInteractor.formatPersonList(persons);

        // Assert
        String expectedResult = "Name |Age|City    |\n" +
                "-----+---+--------+\n" +
                "Peter|42 |New York|\n" +
                "Paul |57 |London  |\n" +
                "Mary |35 |Munich  |";
        assertEquals(result, expectedResult);
    }

}

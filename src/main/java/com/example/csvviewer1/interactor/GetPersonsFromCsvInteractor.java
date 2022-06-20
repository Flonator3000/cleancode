package com.example.csvviewer1.interactor;

import com.example.csvviewer1.model.Person;

import java.io.*;
import java.util.ArrayList;

public class GetPersonsFromCsvInteractor {


    public static ArrayList<Person> getPersonsFromCsv(String filepath) throws IOException {
        final String delimiter = ";";
        String line = "";

        ArrayList<Person> persons = new ArrayList<>();

        FileReader fileReader = new FileReader(filepath);
        BufferedReader reader = new BufferedReader(fileReader);
        boolean skippedHeadline = false;
        while ((line = reader.readLine()) != null) {
            if (!skippedHeadline) {
                skippedHeadline = true;
                continue;
            }
            String[] tokens = line.split(delimiter);    // separate every token by comma
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            persons.add(person);
        }

        return persons;
    }


}

package com.example.csvviewer1.interactor;

import com.example.csvviewer1.model.Person;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FormatPersonListInteractor {

    private static final String NAME = "Name";
    private static final String AGE = "Age";
    private static final String CITY = "City";

    public static String formatPersonList(ArrayList<Person> persons) {

        int[] maxCharCounts = getMaxCharCounts(persons);
        String[] lines = getLines(persons, maxCharCounts);
        String output = concatLines(lines);

        return output;
    }

    private static int[] getMaxCharCounts(ArrayList<Person> persons) {
        int[] maxCharCounts = new int[3];
        maxCharCounts[0] = getMaxCharCountName(persons);
        maxCharCounts[1] = 3;
        maxCharCounts[2] = getMaxCharCountCity(persons);
        return maxCharCounts;
    }

    private static int getMaxCharCountName(ArrayList<Person> persons) {
        int max = persons.stream()
                .mapToInt(person -> person.getName().length())
                .max()
                .orElseThrow(NoSuchElementException::new);
        return Math.max(max, NAME.length());
    }

    private static int getMaxCharCountCity(ArrayList<Person> persons) {
        int max = persons.stream()
                .mapToInt(person -> person.getCity().length())
                .max()
                .orElseThrow(NoSuchElementException::new);
        return Math.max(max, CITY.length());
    }

    private static String[] getLines(ArrayList<Person> persons, int[] maxCharCounts) {
        String[] lines = new String[persons.size() + 2];
        lines[0] = buildLine(new String[]{NAME, AGE, CITY}, "|", " ", maxCharCounts);
        lines[1] = buildLine(new String[]{"", "", ""}, "+", "-", maxCharCounts);

        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            lines[i + 2] = buildLine(new String[]{person.getName(), Integer.toString(person.getAge()), person.getCity()}, "|", " ", maxCharCounts);
        }

        return lines;
    }

    private static String buildLine(String[] strings, String separatorChar, String fillerChar, int[] maxCharCounts) {
        String line = "";

        for (int i = 0; i < strings.length; i++) {
            line += strings[i];
            for (int j = strings[i].length(); j < maxCharCounts[i]; j++) {
                line += fillerChar;
            }
            line += separatorChar;
        }

        return line;
    }

    private static String concatLines(String[] lines) {
        return String.join("\n", lines);
    }
}

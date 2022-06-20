package com.example.csvviewer1.interactor;

import com.example.csvviewer1.model.Option;

import java.util.Scanner;

public class GetNextOptionInteractor {

    public static Option getNextOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Option.optionsToString());
        String input = scanner.next();

        try {
            return Option.getByOptionChar(input.toUpperCase());
        } catch (IllegalArgumentException ex) {
            getNextOption();
        }
        return null;
    }
}

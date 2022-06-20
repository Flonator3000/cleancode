package com.example.csvviewer1.interactor;

import com.example.csvviewer1.model.Page;

public class PrintPageInteractor {

    public static void printPage(Page page) {
        String formattedList = FormatPersonListInteractor.formatPersonList(page.getPersons());
        System.out.println(formattedList);
    }
}

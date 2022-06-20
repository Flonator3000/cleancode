package com.example.csvviewer1.interactor;

import com.example.csvviewer1.model.ExecutionParameterContainer;
import com.example.csvviewer1.model.Page;
import com.example.csvviewer1.model.Person;

import java.io.IOException;
import java.util.ArrayList;

public class GetPagesInteractor {

    public static ArrayList<Page> getPages(ExecutionParameterContainer executionParameterContainer) throws IOException {
        ArrayList<Person> persons = GetPersonsFromCsvInteractor.getPersonsFromCsv(executionParameterContainer.getFilePath());
        int pageSize = executionParameterContainer.getPageSize();

        // Iterates over all persons and relates them to pages...
        ArrayList<Page> pages = new ArrayList<>();
        boolean hasMorePersons = true;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            ArrayList<Person> personsForNextPage = new ArrayList();
            for (int j = 0; j < pageSize; j++) {
                if (i * pageSize + j >= persons.size()) {
                    hasMorePersons = false;
                    break;
                }
                Person currentPerson = persons.get(i * pageSize + j);
                personsForNextPage.add(currentPerson);
            }
            Page page = new Page();
            page.setPersons(personsForNextPage);
            pages.add(page);
            if (!hasMorePersons) {
                break;
            }
        }

        return pages;
    }
}

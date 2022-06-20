package com.example.csvviewer1;

import com.example.csvviewer1.interactor.*;
import com.example.csvviewer1.model.ExecutionParameterContainer;
import com.example.csvviewer1.model.Option;
import com.example.csvviewer1.model.Page;

import java.io.IOException;
import java.util.ArrayList;

public class CsvViewer1Application {

    public static void main(String[] args) throws IOException {
        int currentPage = 0;

        ExecutionParameterContainer executionParameterContainer = GetExecutionParamContainerInteractor.getExecutionParamContainer(args);
        ArrayList<Page> pages = GetPagesInteractor.getPages(executionParameterContainer);

        while (true) {
            PrintPageInteractor.printPage(pages.get(currentPage));
            Option option = GetNextOptionInteractor.getNextOption();
            currentPage = AdjustCurrentPageByOptionInteractor.adjustCurrentPageByOption(option, currentPage, pages.size() - 1);
        }
    }

}

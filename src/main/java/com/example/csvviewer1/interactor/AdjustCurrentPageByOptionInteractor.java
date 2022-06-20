package com.example.csvviewer1.interactor;

import com.example.csvviewer1.model.Option;

public class AdjustCurrentPageByOptionInteractor {

    public static int adjustCurrentPageByOption(Option option, int currentPage, int maxPageValue) {
        switch (option) {
            case PREVIOUS_PAGE:
                return currentPage > 0 ? --currentPage : 0;
            case NEXT_PAGE:
                return currentPage < maxPageValue ? ++currentPage : maxPageValue;
            case LAST_PAGE:
                return maxPageValue;
            case EXIT:
                System.exit(0);
            default:
                return 0;
        }
    }
}

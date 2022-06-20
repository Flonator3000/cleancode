package com.example.csvviewer1.interactor;

import com.example.csvviewer1.model.Option;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdjustCurrentPageByOptionInteractor_Tests {

    @Test
    void adjustCurrentPageByOption_previousPageChosen_correctResult() {
        // Arrange
        int currentPage = 2;
        Option option = Option.PREVIOUS_PAGE;

        // Act
        int udaptedPage = AdjustCurrentPageByOptionInteractor.adjustCurrentPageByOption(option, currentPage, Integer.MAX_VALUE);

        // Assert
        assertEquals(udaptedPage, 1);
    }

    @Test
    void adjustCurrentPageByOption_previousPageChosenWhenOnLowerBorder_noOverflowHappened() {
        // Arrange
        int currentPage = 0;
        Option option = Option.PREVIOUS_PAGE;

        // Act
        int udaptedPage = AdjustCurrentPageByOptionInteractor.adjustCurrentPageByOption(option, currentPage, Integer.MAX_VALUE);

        // Assert
        assertEquals(udaptedPage, 0);
    }

    @Test
    void adjustCurrentPageByOption_nextPageChosen_correctResult() {
        // Arrange
        int currentPage = 2;
        Option option = Option.NEXT_PAGE;

        // Act
        int udaptedPage = AdjustCurrentPageByOptionInteractor.adjustCurrentPageByOption(option, currentPage, Integer.MAX_VALUE);

        // Assert
        assertEquals(udaptedPage, 3);
    }

    @Test
    void adjustCurrentPageByOption_nextPageChosenWhenOnUpperBorder_noOverflowHappened() {
        // Arrange
        int currentPage = 2;
        Option option = Option.NEXT_PAGE;

        // Act
        int udaptedPage = AdjustCurrentPageByOptionInteractor.adjustCurrentPageByOption(option, currentPage, 2);

        // Assert
        assertEquals(udaptedPage, 2);
    }

    @Test
    void adjustCurrentPageByOption_firstPageChosen_correctResult() {
        // Arrange
        int currentPage = 2;
        Option option = Option.FIRST_PAGE;

        // Act
        int udaptedPage = AdjustCurrentPageByOptionInteractor.adjustCurrentPageByOption(option, currentPage, 2);

        // Assert
        assertEquals(udaptedPage, 0);
    }

    @Test
    void adjustCurrentPageByOption_lastPageChosen_correctResult() {
        // Arrange
        int currentPage = 0;
        Option option = Option.LAST_PAGE;

        // Act
        int udaptedPage = AdjustCurrentPageByOptionInteractor.adjustCurrentPageByOption(option, currentPage, 2);

        // Assert
        assertEquals(udaptedPage, 2);
    }

}

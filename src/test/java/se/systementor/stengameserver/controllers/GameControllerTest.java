package se.systementor.stengameserver.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.systementor.stengameserver.services.StatisticsService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {

    @Mock
    private StatisticsService statisticsService;

    @BeforeAll
    public static void beforeTests() {
        System.out.println("\nRunning test...\n");
    }

    @DisplayName("When saving selection, then one interaction with save() should be made 1 time ")
    @Test
    void whenSaving_thenExactlyOneInteractionWithStatisticsServiceMethodSave() {

        //when, method invocation
        statisticsService.save("Computer","BAG","Scissors");

        //then, what we expect
        //checks if the method is called, in this case one time

        verify(statisticsService,times(2)).save("Computer","BAG","Scissors");
        verifyNoMoreInteractions(statisticsService);


    }

    /*

    @DisplayName("user is winner")
    @Test
    void whenYourSelectionEqualsScissorAndMySelectionEqualsBag_thenWinnerIsYou() {

        //given
        String yourSelection = "SCISSOR";
        String mySelection = "BAG";
        String winner = "You";

        //when
        //gameRepository.save(winner,yourSelection,mySelection);
        statisticsService.save(winner,yourSelection,mySelection);

        //then
        assertEquals("You", winner);
        verify(statisticsService).save(winner,yourSelection,mySelection);
        verifyNoInteractions(statisticsService);
    }

     */

}
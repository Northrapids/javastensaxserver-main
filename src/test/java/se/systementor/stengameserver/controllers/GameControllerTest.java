package se.systementor.stengameserver.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.systementor.stengameserver.services.StatisticsService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {

    @Mock
    private StatisticsService statisticsService;

    @Test
    @DisplayName("user is winner")
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

}
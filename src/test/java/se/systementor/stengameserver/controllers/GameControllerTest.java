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



}
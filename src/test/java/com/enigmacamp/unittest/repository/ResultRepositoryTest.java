package com.enigmacamp.unittest.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ResultRepositoryTest {
    private ResultRepository repository;

    @BeforeEach
    void setup() {
        repository = new ResultRepository();
    }

    @Test
    public void itShould_ReturnTrue_When_NumberIsEven() {
        //GIVEN
        Double dummbyNumber = 4.0;
        //WHEN
        boolean actualResult = repository.save(dummbyNumber);
        //THEN
        assertTrue(actualResult);
    }

    @Test
    public void itShould_ReturnFalse_When_NumberIsOdd(){
        //GIVEN
        Double dummyNumber = 3.0;
        //WHEN
        boolean actualResult = repository.save(dummyNumber);
        //THEN
        assertFalse(actualResult);
    }

    @Test
    public void itShould_ReturnNumbers_When_FindAll(){
        //GIVEN
        repository.save(2.0);
        repository.save(10.0);
        //WHEN
        List actualResult = repository.findALl();
        //THEN
        assertEquals(2, actualResult.size());
    }
}
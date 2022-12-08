package com.enigmacamp.unittest;

import com.enigmacamp.unittest.repository.ResultRepository;
import com.enigmacamp.unittest.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {
    @Mock
    private ResultRepository mockRepository;
    private CalculatorService service;

    @BeforeEach
    void setup(){
        service = new CalculatorService(mockRepository);
    }
    @Test
    public void itShould_ReturnResult_When_SumTwoNumbePositive(){
        //GIVEN
        Double num1dummy = 1.0;
        Double num2dummy = 9.0;
        Double expextedValue = 10.0;
        when(mockRepository.save(anyDouble())).thenReturn(true);
        //WHEN
        Double actualResult = service.sum(num1dummy, num2dummy);
        //THEN
        assertEquals(expextedValue, actualResult);
    }

    @Test
    public void itShould_throwError_When_SumTwoNumberWithNegativeNumber(){
        //GIVEN
        Double num1dummy = -1.0;
        Double num2dummy = 9.0;
        //THEN
        assertThrows(RuntimeException.class, () -> service.sum(num1dummy, num2dummy));
    }

    @Test
    public void itShould_ThrowError_When_SumTwoNumberWithOddResult(){
       //GIVEN
        Double num1dummy = 1.0;
        Double num2dummy = 2.0;
        when(mockRepository.save(anyDouble())).thenReturn(false);

        //THEN
        RuntimeException result = assertThrows(RuntimeException.class, () -> service.sum(num1dummy, num2dummy));
        assertEquals("Result is odd number", result.getMessage());
    }

    @Test
    public  void itShould_ReturnResult_WhenSecondNumberBiggerThanZero(){
        //GIVEN
        Double num1dummy = 8.0;
        Double num2dummy = 2.0;
        Double expextedValue = 4.0;
        when(mockRepository.save(anyDouble())).thenReturn(true);
        //WHEN
        Double actualResurt = service.divide(num1dummy, num2dummy);
        //THEN
        assertEquals(expextedValue, actualResurt);
    }

    @Test
    public void itSHould_throwError_When_SeconNumberIsZero(){
        //GIVEN
        Double num1dummy = 10.0;
        Double num2dummy = 0.0;
        //THEN
        assertThrows(RuntimeException.class, () -> service.divide(num1dummy, num2dummy));
    }

    @Test
    public void itShoult_ReturnListResult_When_ViewAllResult(){
        List<Double> dummyResult = new ArrayList<>();
        dummyResult.add(2.0);
        dummyResult.add(4.0);
        when(mockRepository.findALl()).thenReturn(dummyResult);

        List actualList = service.viewAllResult();
        assertEquals(2, actualList.size());
    }


}

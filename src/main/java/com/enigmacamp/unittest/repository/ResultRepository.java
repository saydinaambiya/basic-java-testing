package com.enigmacamp.unittest.repository;

import java.util.ArrayList;
import java.util.List;

public class ResultRepository {
    private List<Double> numbers = new ArrayList<>();

    public boolean save(Double number) {
        if (number % 2 == 0) {
                numbers.add(number);
                return true;
        }else {
            return false;
        }
    }

    public List findALl(){
        return numbers;
    }
}

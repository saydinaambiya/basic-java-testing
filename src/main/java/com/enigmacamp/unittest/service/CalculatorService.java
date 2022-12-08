package com.enigmacamp.unittest.service;

import com.enigmacamp.unittest.repository.ResultRepository;

import java.util.List;

public class CalculatorService {
    private ResultRepository repository;

    public CalculatorService(ResultRepository repository) {
        this.repository = repository;
    }

    public Double sum(Double num1, Double num2) {
        if (num1 < 0 || num2 < 0) {
            throw new RuntimeException("Number cannot negative");
        }
        Double result = num1 + num2;
        if (repository.save(result)) {
            return result;
        }else {
            throw new RuntimeException("Result is odd number");
        }
    }

    public Double divide(Double num1, Double num2) {
        if (num2 == 0) {
            throw new RuntimeException("Zero divider is not allowed");
        }
        Double result = num1 / num2;
        if (repository.save(result)) {
            return result;
        }else {
            throw new RuntimeException("Result is odd number");
        }
    }

    public List viewAllResult(){
        return repository.findALl();
    }
}

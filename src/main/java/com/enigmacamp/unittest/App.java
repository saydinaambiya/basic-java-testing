package com.enigmacamp.unittest;

import com.enigmacamp.unittest.repository.ResultRepository;
import com.enigmacamp.unittest.service.CalculatorService;

public class App {
    public static void main(String[] args) {
        ResultRepository repository = new ResultRepository();
        CalculatorService service = new CalculatorService(repository);
        if (args.length!=2) {
            System.out.println("No parameter provided");
        }else {
            Double num1 = Double.valueOf(args[0]);
            Double num2 = Double.valueOf(args[1]);

            Double result = service.sum(num1, num2);
            System.out.println(result);
        }
        service.viewAllResult().forEach(o -> System.out.println(o));
    }
}

package com.nish.calculator.processor.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.nish.calculator.processor.Calculator;
import com.nish.calculator.service.impl.CalculatorServiceImpl;

public class CalculatorImpl implements Calculator {

	public double processArithemeticOperations(String operationInput) {
		List<String> tockens = Arrays.asList(operationInput.split(" "));
		double calculatedValue = CalculatorServiceImpl.getInstance().calculateOutputofOperations(tockens);
		return calculatedValue;
	}

	public static void main(String[] args) {
		Calculator calculator = new CalculatorImpl();
		System.out.println("Please enter a calculation");
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String calcInput = scanner.nextLine();
			double output = calculator.processArithemeticOperations(calcInput);
			System.out.format("Result : %s",String.valueOf(output));
			System.out.println("\nPlease enter a calculation");
		}

	}
}

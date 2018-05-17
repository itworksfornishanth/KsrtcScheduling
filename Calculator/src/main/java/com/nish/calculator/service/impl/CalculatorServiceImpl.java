package com.nish.calculator.service.impl;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.nish.calculator.dto.CalculatorDto;
import com.nish.calculator.service.CalculatorService;
import com.nish.calculator.types.NumberTypes;
import com.nish.calculator.types.OperatorTypes;

/**
 * 
 * @author Nishanth Mathew Joy
 *
 */
public class CalculatorServiceImpl implements CalculatorService {

	private static CalculatorService instance = new CalculatorServiceImpl();

	public static CalculatorService getInstance() {
		return instance;
	}

	@Override
	public double calculateOutputofOperations(List<String> tokens) {
		List<CalculatorDto> rpnToken = infixToRPN(tokens);
		return performFinalOperation(rpnToken);
	}

	private List<CalculatorDto> infixToRPN(List<String> infixInput) {
		List<CalculatorDto> outPut = new ArrayList<>();
		Deque<CalculatorDto> operator = new LinkedList<>();
		infixInput.stream().forEach(token -> {
			if (NumberTypes.isNumber(token)) {
				outPut.add(new CalculatorDto(NumberTypes.getNumberTypeText(token)));
			} else {
				OperatorTypes operatorType = OperatorTypes.getValueOfAlise(token);
				while (!operator.isEmpty() && operatorType.getOperatorPrecedence() < operator.peek().getOperatorTypes()
						.getOperatorPrecedence()) {
					outPut.add(operator.pop());
				}
				operator.push(new CalculatorDto(operatorType));
			}
		});
		System.out.println(operator);
		while (!operator.isEmpty()) {
			outPut.add(operator.pop());
		}
		return outPut;
	}

	private double performFinalOperation(List<CalculatorDto> rpmInput) {
		System.out.println(rpmInput);
		Deque<Double> numbers = new LinkedList<>();
		rpmInput.stream().forEach(calculatorDto -> {
			if (calculatorDto.getOperatorTypes() != null) {
				double rightOperant = numbers.pop();
				double leftOperant = numbers.pop();
				numbers.push(calculatorDto.getOperatorTypes().getDoubleBinaryOperator().applyAsDouble(leftOperant,
						rightOperant));
				System.out.println("Numbers are "+numbers);
			} else {
				numbers.push((double) calculatorDto.getNumberTypes().getNumber());
				System.out.println("Numbers are "+numbers);
			}
		});
		return numbers.pop();
	}

}

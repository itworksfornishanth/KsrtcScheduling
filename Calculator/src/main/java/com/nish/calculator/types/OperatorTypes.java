package com.nish.calculator.types;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.DoubleBinaryOperator;

/**
 * 
 * @author Nishanth Mathew Joy
 *
 */
public enum OperatorTypes {
	ADD("+", "add", 1, (input1, input2) -> input1 + input2), PLUS("+", "plus", 2,
			(input1, input2) -> input1 + input2), SUBTRACT("-", "subtract", 2,
					(input1, input2) -> input1 - input2), MINUS("-", "minus", 2,
							(input1, input2) -> input1 - input2), LESS("-", "less", 2,
									(input1, input2) -> input1 - input2), MULTIPLIED_BY("*", "multiplied-by", 3,
											(input1, input2) -> input1 * input2), TIMES("*", "times", 3,
													(input1, input2) -> input1 * input2), DIVIDED_BY("/", "divided-by",
															3, (input1, input2) -> input1 / input2), OVER("/", "over",
																	3, (input1, input2) -> input1 / input2);

	private String operator;
	private String aliase;
	private int operatorPrecedence;
	private DoubleBinaryOperator doubleBinaryOperator;

	private OperatorTypes(String operator, String aliase, int operatorPrecedence,
			DoubleBinaryOperator doubleBinaryOperator) {
		this.operator = operator;
		this.aliase = aliase;
		this.operatorPrecedence = operatorPrecedence;
		this.doubleBinaryOperator = doubleBinaryOperator;
	}

	/**
	 * 
	 * @return
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * 
	 * @return
	 */
	public DoubleBinaryOperator getDoubleBinaryOperator() {
		return doubleBinaryOperator;
	}

	/**
	 * 
	 * @return
	 */
	public String getAliases() {
		return aliase;
	}

	/**
	 * 
	 * @return
	 */
	public int getOperatorPrecedence() {
		return operatorPrecedence;
	}

	/**
	 * 
	 * @param aliase
	 * @return
	 */
	public static boolean isOperator(String aliase) {
		return Arrays.stream(values()).anyMatch(operatorType -> operatorType.getAliases().equalsIgnoreCase(aliase));
	}

	/**
	 * 
	 * @param aliase
	 * @return
	 */
	public static OperatorTypes getValueOfAlise(String aliase) {
		if (aliase != null) {
			Optional<OperatorTypes> coverted = Arrays.stream(values())
					.filter(operatorType -> operatorType.getAliases().equalsIgnoreCase(aliase)).findFirst();
			if (coverted.isPresent()) {
				return coverted.get();
			} else {
				throw new IllegalArgumentException("Invalid input for convertion");
			}
		} else {
			throw new IllegalArgumentException("Null input cant be converted");
		}

	}
	
}

package com.nish.calculator.types;

import java.util.Arrays;
import java.util.Optional;

public enum NumberTypes {
	ZERO(0,"Zero"),ONE(1, "One"), TWO(2, "Two"), THREE(3, "Three"), FOUR(4, "Four"), FIVE(5, "Five"), SIX(6, "Six"), SEVEN(7,
			"Seven"), EIGHT(8, "Eight"), NINE(9, "Nine"), TEN(10, "Ten");
	private int number;
	private String naturalLanguageNumber;

	private NumberTypes(int number, String naturalLanguageNumber) {
		this.number = number;
		this.naturalLanguageNumber = naturalLanguageNumber;
	}

	public int getNumber() {
		return number;
	}

	public String getNaturalLanguageNumber() {
		return naturalLanguageNumber;
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isNumber(String number) {
		return Arrays.stream(values())
				.anyMatch(numberType -> numberType.getNaturalLanguageNumber().equalsIgnoreCase(number));
	}

	/**
	 * 
	 * @param naturalLanguageNumber
	 * @return
	 */
	public static NumberTypes getNumberTypeText(String naturalLanguageNumber) {
		if (naturalLanguageNumber != null) {
			Optional<NumberTypes> coverted = Arrays.stream(values())
					.filter(numberType -> numberType.getNaturalLanguageNumber().equalsIgnoreCase(naturalLanguageNumber))
					.findFirst();
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

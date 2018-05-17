package com.nish.calculator.dto;

import com.nish.calculator.types.NumberTypes;
import com.nish.calculator.types.OperatorTypes;
/**
 * This will hold ether number type or operator type value
 * @author nisha
 *
 */
public class CalculatorDto {
	private final NumberTypes numberTypes;

	private final OperatorTypes operatorTypes;

	public CalculatorDto(NumberTypes numberTypes) {
		this.numberTypes = numberTypes;
		this.operatorTypes = null;
	}

	public CalculatorDto(OperatorTypes operatorTypes) {
		this.operatorTypes = operatorTypes;
		this.numberTypes = null;
	}

	public NumberTypes getNumberTypes() {
		return numberTypes;
	}

	public OperatorTypes getOperatorTypes() {
		return operatorTypes;
	}

	@Override
	public String toString() {
		String number =  numberTypes!=null ? String.valueOf(numberTypes.getNumber()) : "";
		String operator = operatorTypes !=null ? operatorTypes.getOperator() : "";
		
		return "CalculatorDto [numberTypes=" + number + ", operatorTypes=" + operator + "]";
	}
	
}

package com.droidacid.apticalc.tys.model;

public class Question {
	
	private int varOne = 0;
	private int varTwo = 0;
	private int result = 0;
	private String sign = "";
	
	private final static int EASY = 0;
	private final static int MEDIUM = 1;
	private final static int HARD = 2;
	private static final int ADDITION = 0;
	private static final int SUBTRACT = 1;
	private static final int MULTIPLY = 2;
	private static final int DIVIDE = 3;
	private static final int ALL = 4;
	
	public Question(int type, int difficulty){
		createQuestion(type, difficulty);
	}
	
	public String getCalculation(){
		return Integer.toString(varOne) + sign + Integer.toString(varTwo);
	}
	
	public int getResult(){
		return result;
	}

	private void createQuestion(int type, int difficulty) {
		
		if (type == ALL)	
			type = (int) (Math.random()*4); // randomize over 0,1,2&3

		switch (type){
		case ADDITION:
			sign = " + ";
			createAddition(difficulty);
			break;
		case SUBTRACT:
			sign = " - ";
			createSubtract(difficulty);
			break;
		case MULTIPLY:
			sign = " x ";
			createMultiply(difficulty);
			break;
		case DIVIDE:
			sign = " / ";
			createDivide(difficulty);
			break;
		}
	}
	
	private void createAddition(int difficulty){
		// easy needs one digit numbers to add to each other
		// medium need two digit numbers to add to each other
		// hard needs three digit numbers to add to each other
		// none of them should be zero
		int max = 0; int min = 0;
		switch (difficulty){
		case EASY:
			max = 9; min = 1;
			varOne = (int) (Math.random() * (max - min) + min);
			varTwo = (int) (Math.random() * (max - min) + min);
			break;
		case MEDIUM:
			max = 99; min = 11;
			varOne = (int) (Math.random() * (max - min) + min);
			varTwo = (int) (Math.random() * (max - min) + min);
			break;
		case HARD:
			max = 499; min = 101;
			varOne = (int) (Math.random() * (max - min) + min);
			varTwo = (int) (Math.random() * (max - min) + min);
			break;
		}
		result = varOne + varTwo;
	}
	
	private void createSubtract(int difficulty){
		// all need two numbers that can be subtracted so starting from the result
		// easy needs a result with maximum one digit and highest first variable of 20
		// medim needs a result with maximum two digits and highest first variable of 100
		// hard needs a result of three digits and highest first variable of 999
		int max = 0; int min = 0;
		switch (difficulty){
		case EASY:
			max = 20; min = 8;
			do {
				result = (int) (Math.random() * (max - min) + min);
				varOne = (int) (Math.random() * (max - min) + min);
				varTwo = varOne - result;
			} while (varTwo < 3);
			break;
		case MEDIUM:
			max = 100; min = 23;
			do {
				result = (int) (Math.random() * (max - min) + min);
				varOne = (int) (Math.random() * (max - min) + min);
				varTwo = varOne - result;
			} while (varTwo < 11);
			break;
		case HARD:
			max = 999; min = 123;
			do {
				result = (int) (Math.random() * (max - min) + min);
				varOne = (int) (Math.random() * (max - min) + min);
				varTwo = varOne - result;
			} while (varTwo < 200);
			break;
		}
	}
	
	private void createMultiply(int difficulty){
		// easy needs a calculation with variables between 2 and 10
		// medium needs a calculation with one variable between 2 and 10 and one between 11 and 99 maximum outcome 999
		// hard needs a calculation with two digits per variable and a maximum of 999 as result
		int max = 0; int min = 0;
		switch (difficulty){
		case EASY:
			max = 9; min = 2;
			varOne = (int) (Math.random() * (max - min) + min);
			varTwo = (int) (Math.random() * (max - min) + min);
			result = varOne * varTwo;
			break;
		case MEDIUM:
			do{
				max = 98; min = 12;
				varOne = (int) (Math.random() * (max - min) + min);
				max = 9; min = 2;
				varTwo = (int) (Math.random() * (max - min) + min);
				result = varOne * varTwo;
			} while (result > 999);
			break;
		case HARD:
			do{
				max = 98; min = 12;
				varOne = (int) (Math.random() * (max - min) + min);
				max = 98; min = 12;
				varTwo = (int) (Math.random() * (max - min) + min);
				result = varOne * varTwo;
			} while (result > 999);
			break;
		}
	}
	
	private void createDivide(int difficulty){
		// all need a two numbers that can be divided so starting with a result
		// easy needs a calculation with a result from the table of 10
		// medium will be two digits divided by one digit, not being in the table of ten 
		// hard will have a two digits divided by two digits (one digit result)
		int max = 0; int min = 0; int vOne; int vTwo;
		switch (difficulty){
		case EASY:
			max = 9; min = 2;
			vOne = (int) (Math.random() * (max - min) + min);
			vTwo= (int) (Math.random() * (max - min) + min);
			varOne = vOne * vTwo;
			if (vOne > vTwo) {
				varTwo = vOne;
				result = vTwo;
			} else {
				varTwo = vTwo;
				result = vOne;
			}
			break;
		case MEDIUM:
			max = 9; min = 2;
			vOne = (int) (Math.random() * (max - min) + min);
			max = 99; min = 12;
			vTwo= (int) (Math.random() * (max - min) + min);
			varOne = vOne * vTwo;
			if (vOne < vTwo) {
				varTwo = vOne;
				result = vTwo;
			} else {
				varTwo = vTwo;
				result = vOne;
			}
			break;
		case HARD:
			max = 9; min = 2;
			vOne = (int) (Math.random() * (max - min) + min);
			max = 99; min = 12;
			vTwo= (int) (Math.random() * (max - min) + min);
			varOne = vOne * vTwo;
			if (vOne > vTwo) {
				varTwo = vOne;
				result = vTwo;
			} else {
				varTwo = vTwo;
				result = vOne;
			}
			
			break;
		}
	}
	
}

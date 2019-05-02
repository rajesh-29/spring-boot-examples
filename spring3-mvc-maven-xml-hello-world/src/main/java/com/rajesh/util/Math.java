package com.rajesh.util;

public class Math {

	public static double getPercentagedValue(double number, double percentage){

		  double x = number;
		  double y = percentage;

		  double result = x * y / 100;

		  return result;
	}
	/*
	public static void main(String[] args) {
		System.out.println((int)getPercentagedValue(50.00, 37.00));
	}
	*/
}

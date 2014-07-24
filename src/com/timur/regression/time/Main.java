package com.timur.regression.time;

import flanagan.analysis.Regression;

public class Main {
	public static void main(String[] args) {
		ExtractSpreadSheet mens400m = new ExtractSpreadSheet(
				"winning-times-for-the-mens-400-m.xls");
		double[] years = mens400m.getYears();
		double[] values = mens400m.getValues();
		
		Regression r = new Regression(years, values);
		r.linearPlot();
		r.bestPolynomialPlot();
		r.gaussianPlot();

		System.out.println("Years\tTimes");
		for (int i = 0; i < years.length; i++) {
			System.out.println((int) years[i] + "\t" + values[i]);
		}
	}
}

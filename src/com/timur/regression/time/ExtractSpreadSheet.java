package com.timur.regression.time;
import java.io.File;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExtractSpreadSheet {

	private String filePath;
	private static ArrayList<Double> year;
	private static ArrayList<Double> value;

	public ExtractSpreadSheet(String fileName) {
		filePath = "./res/GoodDatasets/" + fileName;
		extract();
	}

	// These datasets only contain one sheet!
	private void extract() {
		try {
			Workbook workbook = Workbook.getWorkbook(new File(filePath));
			Sheet sheet = workbook.getSheet(0);
			String title = sheet.getCell(1, 0).getContents();
			System.out.println(title + "\n");
			year = new ArrayList<Double>();
			value = new ArrayList<Double>();
			for (int i = 1; i < sheet.getRows(); i++) {
				Cell cellYear = sheet.getCell(0, i);
				Cell cellValue = sheet.getCell(1, i);
				double thisYear = Double.parseDouble(cellYear.getContents());
				double thisValue = Double.parseDouble(cellValue.getContents());
				year.add(thisYear);
				value.add(thisValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public double[] getYears() {
		double[] y = new double[year.size()];
		for (int i = 0; i < year.size(); i++) {
			y[i] = year.get(i);
		}
		return y;
	}

	public double[] getValues() {
		double[] v = new double[value.size()];
		for (int i = 0; i < year.size(); i++) {
			v[i] = value.get(i);
		}
		return v;
	}

}

package com.assignmentfive;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadCode {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException {

		File src = new File("./ExcelFiles/SampleData.xlsx");

		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wbook = new XSSFWorkbook(fis);
		XSSFSheet sh1 = wbook.getSheetAt(1);

		int rowCount = sh1.getLastRowNum() - sh1.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it

		for (int i = 0; i < rowCount + 1; i++) {

			Row row = sh1.getRow(i);

			// Create a loop to print cell values in a row

			for (int j = 0; j < row.getLastCellNum(); j++) {

				// Print Excel data in console
				System.out.print(row.getCell(j).getStringCellValue().toString() + "|| ");

			}

			System.out.println();
		}

	}
}

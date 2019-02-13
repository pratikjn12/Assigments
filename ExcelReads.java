package com.Corpository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReads {

	public void excelread() throws IOException {
		Map<Integer, Map<String, String>> tabledata = new HashMap<Integer, Map<String, String>>();
		List<String> header = new ArrayList<String>();

		File src = new File("./ExcelFiles/SampleData.xlsx");

		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wbook = new XSSFWorkbook(fis);
		XSSFSheet sh1 = wbook.getSheetAt(1);

		int rowCount = sh1.getLastRowNum() - sh1.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it
		Map<String, String> tmp = new HashMap<String, String>();

		for (int i = 0; i < rowCount + 1; i++) {

			Row row = sh1.getRow(i);

			// Create a loop to print cell values in a row

			for (int j = 0; j < row.getLastCellNum(); j++) {
				tmp.clear();

				// Print Excel data in console
				// System.out.print(row.getCell(j).getStringCellValue().toString() + "|| ");

				if (i == 0) {
					header.add(row.getCell(j).getStringCellValue().toString());
				}

				else {
					tmp.put(header.get(i), row.getCell(j).getStringCellValue().toString());
				}

			}

			if (i != 0)
				tabledata.put(i, tmp);
		}

		System.out.println();
	}
}
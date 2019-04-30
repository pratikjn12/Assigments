package org.Corpository.factory;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static XSSFWorkbook wb;

	public ExcelReader() throws Exception {
		File excelfile = new File(System.getProperty("user.dir") + "/ExcelFileData/Propreitor Data.xlsx");
		FileInputStream excelfis = new FileInputStream(excelfile);
		wb = new XSSFWorkbook(excelfis);

	}

	public String getData(int sheetIndex, int row, int column) {

		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue().trim();

		return data;
	}

	public String getData(String sheetName, int row, int column) {

		String data = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue().trim();

		return data;
	}

	public double getnumericData(String sheetName, int row, int column) {

		double data = wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();

		return data;
	}

	public double getnumericData(int index, int row, int column) {

		double data = wb.getSheetAt(index).getRow(row).getCell(column).getNumericCellValue();

		return data;
	}

	public int getrowcount(int sheetId) {
		int rowcount = wb.getSheetAt(sheetId).getPhysicalNumberOfRows();
		return rowcount;
	}

	public int getcolcount(int sheetId, int rowno) {
		int colcount = wb.getSheetAt(sheetId).getRow(rowno).getPhysicalNumberOfCells();
		return colcount;
	}

}

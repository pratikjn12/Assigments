package org.Corpository.factory;

public class DataProviderFactory {

	public static ConfigReader getConfig() {

		ConfigReader config = new ConfigReader();

		return config;

	}

	public static ExcelReader getExcel() throws Exception {

		ExcelReader excel = new ExcelReader();

		return excel;

	}

	public static Browserconfig getbrowser() throws Exception {

		Browserconfig browser = new Browserconfig();

		return browser;

	}

}

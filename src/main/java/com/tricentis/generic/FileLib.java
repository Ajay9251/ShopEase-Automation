package com.tricentis.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {

	public String getProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/data/commondata.properties");
		Properties p = new Properties();
		p.load(fis);

		String data = p.getProperty(key);
		fis.close();
		return data;
	}

	public String getExcelData(String sheetName, int rowIndex, int cellIndex)
			throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/data/testcase.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();

		wb.close();
		fis.close();
		return data;
	}

	public void writeExcelData(String sheetName, int rowIndex, int cellIndex, String value)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/data/testcase.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowIndex).createCell(cellIndex).setCellValue(value);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/data/testcase.xlsx");
		fis.close();
		fos.close();
		wb.write(fos);
		wb.close();
	}
}

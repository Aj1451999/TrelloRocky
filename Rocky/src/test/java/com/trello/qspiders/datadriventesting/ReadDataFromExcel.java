package com.trello.qspiders.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//Create the Object of FileInputStream
	FileInputStream fis = new FileInputStream("./src/test/resource/dataofdropdownlist.xlsx");
	//Call the WorkBookFactory Class from POi and create() upon the same class
	Workbook workbook = WorkbookFactory.create(fis);
	Sheet sheet = workbook.getSheet("dropdownoption");
	Row row = sheet.getRow(2);
	Cell cell = row.getCell(0);
	//String value = cell.getStringCellValue();
	long value = (long)cell.getNumericCellValue();
	System.out.println(value);
	workbook.close();
}
}
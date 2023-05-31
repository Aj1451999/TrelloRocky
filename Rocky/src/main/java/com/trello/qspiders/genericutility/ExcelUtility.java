package com.trello.qspiders.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class help us to fetch the data from the workbook i.e excel,word,notepad etc.
 * @author AJAY BOSS
 *
 */

public class ExcelUtility
{
	/**
	 * To read data from the Excel Workbook.
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return StringCellData
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readStringData(String sheetName,int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".src/test/resource/trelloworkbookdata.xlsx");
		Workbook workbook= WorkbookFactory.create(fis);
		String CellData = workbook.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		workbook.close();
		return CellData;
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return NumericCellData
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public double readNumericData(String sheetName,int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".src/test/resource/trelloworkbookdata.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		double CellData = workbook.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getNumericCellValue();
		workbook.close();
		return CellData;
	}

}













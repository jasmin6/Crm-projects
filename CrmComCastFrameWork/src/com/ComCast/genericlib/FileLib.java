package com.ComCast.genericlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
* It provides libraries to get the data from .xlsx and .properties
* @author jasmin
* 
*/

public class FileLib {
	/**
	 * Get the key = value from the commondata.properties file like URL, USERNAME,PASSWORD,BROWSER
	 * @param key
	 * @return value of key
	 * @throws IOException 
	 * @throws Throwable
	 */ 
	public String getProprtykeyvalue(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./Data/commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
		
	
	/**
	 * get the data from Excel-Workbook,based on user arguments
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName,int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis = new FileInputStream("E:\\Advance Automation\\vtiger.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNum);
	Cell cel = row.getCell(colNum);
	String data = cel.getStringCellValue();
	wb.close();
			
	return data;

	}
}

package com.vtiger.genericlibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * This Generic class use to handle file
 * @author Manjunath
 *
 */
public class FileLib implements IAutoConsts {
	/**
	 * This generic method is used to read data from property file
	 * @param path
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String  getPropKeyValue(String path,String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(path);
		Properties prop=new Properties();
		prop.load(fis);
		String propValue=prop.getProperty(key, "Incrrect key");
		return propValue;
		
	}
	
	/**
	 * used to read the data from excel workbook based on testId & ColumnHeader
	 * @param sheetName
	 * @param expTestID
	 * @param expColHEader
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName , String expTestID , String expColHEader) throws Throwable {
		
				int expTestRow = 0;
				int expHeader = 0;
				FileInputStream fis = new FileInputStream(EXCEL_PATH);
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(sheetName);
				int rowCount = sh.getLastRowNum();
			    
		    for(int i=0; i<=rowCount ; i++) {		
				Row row = sh.getRow(i);
				String zeroColData= row.getCell(0).getStringCellValue();
		        if(expTestID.contentEquals(zeroColData)) {
		        	//System.out.println("test is available");
		        	expTestRow = i;
		        	break;
		        }
		    }
		    
		    int expColHeader = expTestRow-1;
		    
		        int colCount = sh.getRow(expColHeader).getLastCellNum();
		         for(int j=0 ; j <colCount ; j++) {
		        	   String actColHeader = sh.getRow(expColHeader).getCell(j).getStringCellValue();
		        	   if(actColHeader.equals(expColHEader)) {
		        		        //System.out.println("header is available ");
		        		        expHeader = j;
		        		        break;
		        	   }
		         }
		         
      return sh.getRow(expTestRow).getCell(expHeader).getStringCellValue();
				
	}
	
	
	
	
	/**
	 * This generic method is used to get the cell values from excel file
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String getCellData(String path,String sheet,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		String cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		
		return cellValue;
	}
	/**
	 * This generic method used to get the number of filled row count 
	 * @param path
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String path,String sheet) throws Throwable
	{
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		int rc=wb.getSheet(sheet).getLastRowNum();
		return rc;
		
	}
	
	/**
	 * This generic method used to get the number of filled column count 
	 * @param path
	 * @param sheet
	 * @param row
	 * @return
	 * @throws Throwable
	 */
	public int getCellCount(String path,String sheet,int row) throws Throwable
	{
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		int rc=wb.getSheet(sheet).getRow(row).getLastCellNum();
		return rc;
	}
	
	/**
	 * This generic method used to set new data to perticular cell
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	public void setCellData(String path,String sheet,int row,int cell,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(path);
		wb.write(fos);
		
		
		
	}
}

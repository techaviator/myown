package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook wb =null;
	public  ExcelReader(String path)
	{
		//String path = System.getProperty("user.dir") +"\\src\\test\\resources\\Age.xlsx";
		//System.out.println(path);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			wb=new XSSFWorkbook(fis);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(wb!=null)
		{
			System.out.println("Connection Success");
		}
		
	}
	
	public String readXLData(String sheetname, int rowindex, String ColName)
	{
		int xlColumnCount = getXLColumnCount(sheetname);
		int colindex=0;
		String celltext = null;
		for(int i=0;i<xlColumnCount;i++)
		{
			if(wb.getSheet(sheetname).getRow(0).getCell(i).getStringCellValue().equals(ColName))
			{
				colindex=i;
				celltext = readXLData(sheetname, rowindex, colindex);
				break;
			}
		}
		
		return celltext;
		
	}
	
	public String readXLData(String sheetname, int rowindex, int colindex )
	{
		//Read a cell from wb 
		//sheetname, rowindex, colindex
				XSSFCell cell = wb.getSheet(sheetname).getRow(rowindex).getCell(colindex);
				String celltext = null;
				//System.out.println(cell.getCellType()+"           "+cell.CELL_TYPE_STRING);
				if(cell.getCellType()==Cell.CELL_TYPE_STRING)
				{
					celltext = cell.getStringCellValue();
				}
				else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
				{
					double numericCellValue = cell.getNumericCellValue();
					celltext =  String.valueOf(numericCellValue);
				}
				else if(cell.getCellType()==Cell.CELL_TYPE_BOOLEAN)
				{
					boolean booleanCellValue = cell.getBooleanCellValue();
					celltext = String.valueOf(booleanCellValue);
				}
				else
				{
					celltext =  "";
				}
				//System.out.println("The text is "+celltext);
				return celltext;
	}
	
	public void writeXLData(String sheetname, int rowindex, int colindex , String value ) 
	{
		//write the values to excel
		//sheetname, rowindex,colindex, value, String path
				XSSFRow row = wb.getSheet(sheetname).getRow(rowindex);
				if(row==null)
				{
					row =wb.getSheet(sheetname).createRow(rowindex);
				}
				XSSFCell cell2 = row.getCell(colindex);
				if(cell2==null)
				{
					cell2 =row.createCell(colindex);
				}
				cell2.setCellValue(value);
				
				
	}
	
	public int getXLRowCount(String sheetname)
	{
		//Get the number of rows
		int lastRowNum = wb.getSheet(sheetname).getLastRowNum();
		//System.out.println("THe number of rows is "+lastRowNum);
		return lastRowNum;
		//return  wb.getSheet(sheetname).getLastRowNum();
	}
	
	public int getXLColumnCount(String sheetname)
	{
		//Get the number of column
		int lastCellNum = wb.getSheet(sheetname).getRow(0).getLastCellNum();
		//System.out.println("THe number of columns is "+lastCellNum);
		return lastCellNum;
	}
	
	public void saveXLFile(String path) 
	{
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb.write(fout);
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}

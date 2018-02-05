package Utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	public static String getCellValue(String xlpath,String sheet, int r, int c)
	{
		String value=" ";
		try
		{
			value=WorkbookFactory.create(new FileInputStream(xlpath)).getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			
		}
		return value;
	}
	
	public static int getRowCount(String xlpath, String sheet)
	{
		int count=0;
		try
		{
			count=WorkbookFactory.create(new FileInputStream(xlpath)).getSheet(sheet).getLastRowNum();
			
		}
		catch(Exception e)
		{
			
		}
		return count;
	}
}

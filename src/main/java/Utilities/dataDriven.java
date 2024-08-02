package Utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tika.metadata.Property;


public class dataDriven {
	
	
	
		 
	
	public static ArrayList<String> getDataAsList(String rowName) throws IOException
	{
	
		//String rowName="items";
		//FileInputStream fs= new FileInputStream(System.getProperty("user.dir") +"/src/main/java/Configurations/dataDriven1.xlsx");
		FileInputStream fs= new FileInputStream("C:/Users/SQE Labs/Desktop/dataDriven1.xlsx");

		XSSFWorkbook workbook= new XSSFWorkbook(fs);
		ArrayList<String> list = new ArrayList<>();
		
		int sheets= workbook.getNumberOfSheets();
		
		
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("items"))
			{
				XSSFSheet sheet= workbook.getSheetAt(i);
				//System.out.println(workbook.getSheetName(i));
				
				Iterator<Row> rows=sheet.iterator();
				while(rows.hasNext())
				{
					
				Row currentRow=rows.next();
				
				//Iterator<Cell> ce=currentRow.cellIterator();
				int column = 0;
				
				
				
				
					//System.out.println("hello00");
					if(currentRow.getCell(column).getStringCellValue().equalsIgnoreCase(rowName))
					{
						//System.out.println(currentRow.getCell(column).getStringCellValue());
						Iterator<Cell> cv=currentRow.cellIterator();
						while(cv.hasNext())
						{
							Cell c= cv.next();
							if(c.getCellType()==CellType.STRING)
								list.add(c.getStringCellValue());
							
							else
							{
								list.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								
							}
							
						}
						
						
						
					}
						
					
				}
			}
				
			}
		return list;
	}
}
		

		
		
		
		
		
	

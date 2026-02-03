package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	//Data Provider1
	
	@DataProvider(name="LoginData")
	public String[][] getLoginData() throws IOException{
		String path=".\\testData\\OpenCartLoginData.xlsx"; //excel file path
		ExcelUtility utility = new ExcelUtility(path);
		int totalRows=utility.getRowCount("Sheet1");
		int totalCols=utility.getCellCount("Sheet1", 1);
		String loginData[][]=new String [totalRows][totalCols]; //two dimension array which can store excel data
		
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				loginData[i-1][j]=utility.getCellData("Sheet1", i, j);
			}
		}
				
		return 	loginData;	
		
	}
	
	//Data Provider2
	//Data Provider3
	
}

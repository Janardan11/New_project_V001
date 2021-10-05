package com.TestUtility;

import java.util.ArrayList;

import com.excel.lib.util.Xls_Reader;

public class TestUtil {

	static Xls_Reader reader;
	
	public static  ArrayList<Object[]> getdatafromExcelfile()
	{
		
		ArrayList<Object[]> mydata=new ArrayList<Object[]>();
		
	  reader=new Xls_Reader("D:\\selenium\\excelsheet\\DataDrivenTest.xlsx");
	  
	  int rowcount=reader.getRowCount("OrangeHRMData");
	  
	  System.out.println("Total rowcount="+rowcount);
	  
	  
	  for(int rownum=2;rownum<=rowcount;rownum++)
		{

			String firstname = reader.getCellData("OrangeHRMData", "First Name", rownum);

			System.out.println(firstname);

			String LastName = reader.getCellData("OrangeHRMData", "Last Name", rownum);
			System.out.println(LastName);

		
			String username = reader.getCellData("OrangeHRMData", "UserName", rownum);
			System.out.println(username);

			String password = reader.getCellData("OrangeHRMData", "Password", rownum);
			System.out.println(password);
			
			Object ob[] = { firstname, LastName,username,password };

			mydata.add(ob);

		}
	  
	  return mydata;
	  
	}
	
	
	
}

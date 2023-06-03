package com.inetbanking.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datatest {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet();
		
		Row r0=sheet1.createRow(0);
		Cell c0 = r0.createCell(0);
		c0.setCellValue("Srinivas");
		
		File f = new File("/Users/srinivasulukolluri/java-2022-124/Eclipse.app/inetbankingV1/testdata1/testdata1.xlsx");
        FileOutputStream fos = new FileOutputStream(f);
        workbook.write(fos);
        fos.close();
        workbook.close();
        
        System.out.println("File is Written Successfully");
	}

}

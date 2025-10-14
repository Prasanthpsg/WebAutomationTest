package com.seersolutions.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Arrays;

public class ExcelUtils {

    public static String getCellData(String filePath, String sheetName, int row, int col) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            return sheet.getRow(row).getCell(col).getStringCellValue();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Object[][] readExcelData(String filePath, String sheetName) {
        Object[][] data = null;

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) { // Skip header
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = (cell != null) ? cell.toString().trim() : "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("Excel Data (Object[][]):");
//        for (Object[] row : data) {
//            for (Object value : row) {
//                System.out.print(value + " | ");
//            }
//            System.out.println();
//        }
        return data;
    }
}

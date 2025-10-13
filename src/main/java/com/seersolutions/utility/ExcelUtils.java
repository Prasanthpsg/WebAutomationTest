package com.seersolutions.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

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
}

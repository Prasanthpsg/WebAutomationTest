package com.seersolutions.utility;

import org.testng.Assert;

public class ReuseableMethods {

    public static String readExcelData(String filepath, String sheetname, int row, int column) {
        String  inputValue = ExcelUtils.getCellData(filepath, sheetname, row, column);
        if (inputValue == null || inputValue.trim().isEmpty()) {
            Assert.fail("Excel cell value is empty or null at Sheet: '" + sheetname +
                    "', Row: " + row + ", Column: " + column);
        }

        return inputValue.trim();
    }
}

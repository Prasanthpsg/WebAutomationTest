package com.seersolutions.utility;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        String excelPath = "testdata/credentials.xlsx";
        String sheetName = "Sheet1";
        return ExcelUtils.readExcelData(excelPath, sheetName);
    }
}

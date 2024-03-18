package com.qa.util;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {
    public static Object[][] getTestData(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Workbook creation failed. Check file path and dependencies.");
        } finally {
            if (file != null) {
                file.close();
            }
        }

        if (workbook == null) {
            throw new IOException("Workbook is null. Check file path and dependencies.");
        }

        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IOException("Sheet '" + sheetName + "' not found in the workbook.");
        }

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount + 1][colCount];
        for (int i = 0; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i][j] = cell != null ? cell.toString() : "";
                }
            } else {
                // Handle null row, you can skip or fill with empty strings
                for (int j = 0; j < colCount; j++) {
                    data[i][j] = ""; // Fill with empty string
                }
            }
        }
        return data;
    }
}


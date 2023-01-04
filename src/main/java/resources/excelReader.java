package resources;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class excelReader {

    private Workbook workbook;


    public excelReader() {
        File file = new File("src/test/resources/TestData.xlsx");
        try {
            try (FileInputStream fs = new FileInputStream(file)) {
                workbook = new XSSFWorkbook(fs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Row getRowBySheetAndIndex(String sheetName, int index) {
        return workbook.getSheet(sheetName).getRow(index);
    }

    public String getCellValue(Row row, int index) {

        if(row == null)
        {
            return "";
        }
        Cell cell = row.getCell(index);
        String value = null;
        if (cell == null) {
            value = "";
        } else {
            value =  cell.getStringCellValue();
        }
        return value;
    }
}
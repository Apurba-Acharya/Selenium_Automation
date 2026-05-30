package ex27_testNG.TNG12_integrationOfExcelFileWithDataProviderVVI;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;


public class TNG13A_excelDataSupllier {

    // Excel is a workBook which contains : Sheet -> Row -> Cell
    // WorkBook is 2 types: .xls->HSSF ; .xlsx->XSSF

    /*                   | Method                      | Purpose
            | --------------------------- | ----------------------------------- |
            |  getLastRowNum()            | Returns index of last row with data |
            |  getPhysicalNumberOfRows()  | Returns count of non-empty rows     | */

    @DataProvider
    public Object [][] getData() throws IOException {

        //WorkBook configuration:
        File excelFile = new File("C:\\Users\\apurb\\IdeaProjects\\Selenium_Automation\\src\\test\\resources\\excelDataTNG.xlsx");
        System.out.println(excelFile.exists()); // Boolean return: True / False
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workBook = new XSSFWorkbook(fis);

        //Sheet configuration:
        XSSFSheet sheet = workBook.getSheet("Sheet1");
        int noOfRowsExclHeader = sheet.getPhysicalNumberOfRows()-1;
        int noOfColumns = sheet.getRow(0).getLastCellNum(); // Get how many columns (cells) are present in the first row.

        Object [][] data = new Object [noOfRowsExclHeader][noOfColumns];
        for(int i=0; i<noOfRowsExclHeader; i++){
            for (int j=0; j<noOfColumns; j++){
                DataFormatter df = new DataFormatter(); //DataFormatter -> converts any cell value to a formatted String exactly as it appears in Excel.
                data[i][j] = (df.formatCellValue(sheet.getRow(i+1).getCell(j)));
            }
        }
        workBook.close();
        fis.close();

//        for(Object [] dataArr : data){
//            System.out.println(Arrays.toString(dataArr));
//        }
        return data;
    }
}

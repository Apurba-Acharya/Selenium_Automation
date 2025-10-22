package ex28_testNG.TNG13_integrationOfExcelFileWithDataProvider;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TNG13_excelDataSupllier {

    // Excel is a workBook which contains : Sheet -> Row -> Cell
    // WorkBook is 2 types: .xls->HSSF ; .xlsx->XSSF

    public static void main(String[] args) throws IOException {

        //WorkBook configuration:
        File excelFile = new File("C:\\Users\\apurb\\IdeaProjects\\Selenium_Automation\\src\\test\\resources\\excelDataTNG.xlsx");
        System.out.println(excelFile.exists());
        FileInputStream fls = new FileInputStream(excelFile);
        XSSFWorkbook workBook = new XSSFWorkbook(fls);

        //Sheet configuration:
        XSSFSheet sheet = workBook.getSheet("Sheet1");
        System.out.println(sheet.getPhysicalNumberOfRows());
        System.out.println(sheet.getLastRowNum()); // Excluding header row
        int noOfRows = sheet.getLastRowNum();
        int noOfColumns = sheet.getRow(0).getLastCellNum();

        for(int i=1; i<=noOfRows; i++){
            for (int j=0; j<noOfColumns; j++){
                sheet.getRow()
            }
        }

        workBook.close();
        fls.close();
    }
}

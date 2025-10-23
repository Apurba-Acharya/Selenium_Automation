package ex28_testNG.TNG13_integrationOfExcelFileWithDataProvider;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class TNG13A_excelDataSupllier {

    // Excel is a workBook which contains : Sheet -> Row -> Cell
    // WorkBook is 2 types: .xls->HSSF ; .xlsx->XSSF

    @DataProvider
    public String [][] getData() throws IOException {

        //WorkBook configuration:
        File excelFile = new File("C:\\Users\\apurb\\IdeaProjects\\Selenium_Automation\\src\\test\\resources\\excelDataTNG.xlsx");
        System.out.println(excelFile.exists());
        FileInputStream fls = new FileInputStream(excelFile);
        XSSFWorkbook workBook = new XSSFWorkbook(fls);

        //Sheet configuration:
        XSSFSheet sheet = workBook.getSheet("Sheet1");
        System.out.println(sheet.getPhysicalNumberOfRows());
        System.out.println(sheet.getLastRowNum()); // Excluding header row
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = sheet.getRow(0).getLastCellNum();

        String [][] data = new String [noOfRows-1][noOfColumns];
        for(int i=0; i<noOfRows-1; i++){
            for (int j=0; j<noOfColumns; j++){
                DataFormatter df = new DataFormatter();
                data[i][j] = (df.formatCellValue(sheet.getRow(i+1).getCell(j)));;
            }
        }
        workBook.close();
        fls.close();

//        for(String [] dataArr : data){
//            System.out.println(Arrays.toString(dataArr));
//        }
        return data;
    }
}

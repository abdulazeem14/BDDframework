package Manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestManager {
    public static ArrayList < HashMap < String, String >> tcdata(String sheetname){
        try {
        FileInputStream objFIS = new FileInputStream(new File("./TestData/testdata.xlsx"));
        ArrayList < HashMap < String, String >> arrLst = new ArrayList < > ();
        //  XSSFRow row;
        XSSFWorkbook objWorkbook = new XSSFWorkbook(objFIS);
        XSSFSheet objSpreadsheet = objWorkbook.getSheet(sheetname);
        int intLastRow = objSpreadsheet.getLastRowNum();
        Row firstRow = objSpreadsheet.getRow(0);


        for (int i = 1; i <= intLastRow; i++) {

            HashMap < String, String > hm = new HashMap < > ();
            Row rows = objSpreadsheet.getRow(i);
            //System.out.println(i+"::"+row);
            int intlastCell = firstRow.getLastCellNum();
            for (int j = 0; j < intlastCell; j++) {
                Cell objdataCell = rows.getCell(j);
                Cell objheaderCell = firstRow.getCell(j);
                String strHeader = getCellData(objheaderCell, objWorkbook);
                String strValue = getCellData(objdataCell, objWorkbook);
                hm.put(strHeader, strValue);

            }
            arrLst.add(hm);
        }
        return arrLst;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
        
   

    }
    public static String getCellData(Cell cell, Workbook workbook) {
        String strCellDataValue = "";
        if (cell == null)
            return strCellDataValue;
        switch (cell.getCellType()) {
            case BOOLEAN:
                strCellDataValue = Boolean.toString(cell.getBooleanCellValue());
                break;

            case _NONE:
            case BLANK:
            case ERROR:
                break;

            case NUMERIC:
                strCellDataValue = Double.toString(cell.getNumericCellValue());
                break;

            case STRING:
                strCellDataValue = cell.getStringCellValue();
                break;
            case FORMULA:
                break;
            default:
                break;
        }
        return strCellDataValue;
    }
    public HashMap<String, String> getTestcase(String sheetname,String testcaseId)
    {
        ArrayList<HashMap<String, String>> td;
        td = tcdata(sheetname);
        Iterator < HashMap < String, String >> itr = td.iterator();
   
        while (itr.hasNext()) {

            HashMap < String, String > a = itr.next();
           
           if(a.containsValue(testcaseId)) {
              
               return a;
           }
           
        }
        return null;
    }

}

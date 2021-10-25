package Utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;


public class XLSDataProvider {
    private String path;
    private XSSFWorkbook book;
    private XSSFSheet sheet = null;
    private FileInputStream fis = null;
    private FileOutputStream fos = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;

    public  XLSDataProvider(String path){
                this.path = path;
        try {
            fis = new FileInputStream(path);
            book = new XSSFWorkbook(fis);
            sheet = book.getSheetAt(0);
            fis.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }}

    public int getXLSRowCount (String SheetName){
int index = book.getSheetIndex(SheetName);
if (index ==-1){
    return 0;
}

else {
    sheet = book.getSheetAt(index);
    int number = sheet.getLastRowNum()+1;
    return number;

}
    }
    public String getCellData(String sheetName, int colNum, int rowNum) {
        try {
            if (rowNum <= 0)
                return "";

            int index = book.getSheetIndex(sheetName);

            if (index == -1)
                return "";

            sheet = book.getSheetAt(index);
            row = sheet.getRow(rowNum - 1);
            if (row == null)
                return "";
            cell = row.getCell(colNum);
            if (cell == null)
                return "";

            //
            if (cell.getCellType().name().equals("STRING"))
                return cell.getStringCellValue();


            else if ((cell.getCellType().name().equals("NUMERIC")) || (cell.getCellType().name().equals("FORMULA"))) {

                String cellText = String.valueOf(cell.getNumericCellValue());
                if (HSSFDateUtil.isCellDateFormatted(cell)) {

                    double d = cell.getNumericCellValue();

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(HSSFDateUtil.getJavaDate(d));
                    cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;

                }

                return cellText;
            } else if (cell.getCellType().BLANK != null)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        } catch (Exception e) {

            e.printStackTrace();
            return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
        }
    }


}



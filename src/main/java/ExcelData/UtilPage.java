package ExcelData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilPage {

	public static FileInputStream fis;

	public static XSSFWorkbook wb;

	public static HashMap<String, String> getDataExcel(String ExcelCases) throws IOException {

		fis = new FileInputStream("src\\test\\resources\\ExcelPage\\ExcelData\\MasterData.xlsx");

		wb = new XSSFWorkbook(fis);

		XSSFSheet Sheet = wb.getSheet("Sheet1");

		ArrayList<Row> DataRow = getExcelData(Sheet, ExcelCases);
		
		HashMap<String, String> hMap=	new HashMap<String, String>();
		
		for(int i=0; i<DataRow.size(); i++) {
			int noOFRows = DataRow.get(i).getLastCellNum();
			
			for(int j=1; j<noOFRows; j++) {
				hMap.put(DataRow.get(0).getCell(j).getStringCellValue(), 
						       DataRow.get(1).getCell(j).getStringCellValue());
			}
		}

		return hMap;

	}

	private static ArrayList<Row> getExcelData(XSSFSheet sheet, String ExcelCases) {

		ArrayList<Row> ExcelRow = new ArrayList<Row>();

		for (int i = 0; i <= sheet.getLastRowNum(); i++) {

			if (sheet.getRow(i) != null) {
				ExcelRow.add(sheet.getRow(i));
			}

		}

		ArrayList<Row> ExcelColumn = new ArrayList<Row>();

		for (int i = 0; i < ExcelRow.size(); i++) {

			if (ExcelRow.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(ExcelCases)) {

				ExcelColumn.add(ExcelRow.get(i));
			}

		}

		return ExcelColumn;
	}

}

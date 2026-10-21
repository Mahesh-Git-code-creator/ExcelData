package ChatGPTsolution;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ChatGPTValues {

	public static FileInputStream fis;
	public static XSSFWorkbook wb;

	public static HashMap<String, String> getDataRetriveExcel(String Testcases) throws IOException {

		String filePath = "src\\test\\resources\\ExcelPage\\ExcelData\\MasterData.xlsx";

		DataFormatter formatter = new DataFormatter();

		try (FileInputStream input = new FileInputStream(filePath); 
				
				XSSFWorkbook workbook = new XSSFWorkbook(input)) {

			XSSFSheet ws = workbook.getSheet("Sheet1");

			if (ws == null) {
				throw new IllegalArgumentException("Sheet1 was not found in the Excel file.");
			}

			ArrayList<Row> ExcelRow = getExcelElement(ws, Testcases, formatter);

			if (ExcelRow.size() < 2) {
				throw new IllegalArgumentException(
						"Expected two rows for testcase: " + Testcases + ", but found: " + ExcelRow.size());
			}

//			HashMap<String, String> hmap = new HashMap<>();
			
			HashMap<String, String> hmap = new HashMap<String,String>();

			Row headerRow = ExcelRow.get(0);
			Row dataRow = ExcelRow.get(1);

			int lastCellNum = Math.max(headerRow.getLastCellNum(), dataRow.getLastCellNum());

			for (int j = 1; j < lastCellNum; j++) {

				Cell headerCell = headerRow.getCell(j);
				Cell valueCell = dataRow.getCell(j);

			 
				if (headerCell == null || valueCell == null) {
					continue;
				}

				String key = formatter.formatCellValue(headerCell).trim();

				String value = formatter.formatCellValue(valueCell).trim();

				if (!key.isEmpty()) {
					hmap.put(key, value);
				}
			}

			return hmap;
		}
	}

	private static ArrayList<Row> getExcelElement(XSSFSheet ws, String testcases, DataFormatter formatter) {

		ArrayList<Row> ExcelDataColumn = new ArrayList<>();

		for (int i = 0; i <= ws.getLastRowNum(); i++) {

			 if(ws.getRow(i)!=null) {
				 ExcelDataColumn.add(ws.getRow(i));
			 }
		}

		ArrayList<Row> ExcelDataRow = new ArrayList<>();

		for (int i = 0; i < ExcelDataColumn.size(); i++) {

			Row row = ExcelDataColumn.get(i);

 			Cell firstCell = row.getCell(0);

			if (firstCell != null && formatter.formatCellValue(firstCell).trim().equalsIgnoreCase(testcases.trim())) {

				ExcelDataRow.add(row);
			}
			
			 
		}

		return ExcelDataRow;
	}
}
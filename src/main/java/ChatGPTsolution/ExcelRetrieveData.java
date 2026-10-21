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

public class ExcelRetrieveData {

	public static FileInputStream fis;

	public static XSSFWorkbook wb;

	public static HashMap<String, String> getDataExcel(String testcases) throws IOException {

		String path = "src\\test\\resources\\ExcelPage\\ExcelData\\MasterData.xlsx";

		DataFormatter formatter = new DataFormatter();

		fis = new FileInputStream(path);

		wb = new XSSFWorkbook(fis);

		XSSFSheet ws = wb.getSheet("Sheet1");

		if (ws == null) {

			throw new IllegalArgumentException("Sheet is not a approproiate");

		}

		ArrayList<Row> ExcelDataRow = getGPTExcelData(ws, formatter, testcases);

		if (ExcelDataRow.size() < 2) {

			throw new IllegalArgumentException("sheet is a " + testcases + "and important value" + ExcelDataRow.size());

		}

		HashMap<String, String> hmap = new HashMap<String, String>();

		Row ExcelValue = ExcelDataRow.get(0);

		Row ExcelKey = ExcelDataRow.get(1);

		int noOFRows = Math.max(ExcelValue.getLastCellNum(), ExcelKey.getLastCellNum());

		for (int i = 1; i < noOFRows; i++) {

			Cell headercell = ExcelValue.getCell(i);

			Cell valuecell = ExcelKey.getCell(i);

			if (headercell == null || valuecell == null) {
				continue;
			}

			String key = formatter.formatCellValue(headercell).trim();

			String format = formatter.formatCellValue(valuecell).trim();

			if (!key.isEmpty()) {
				hmap.put(key, format);
			}

		}

		return hmap;

	}

	private static ArrayList<Row> getGPTExcelData(XSSFSheet ws, DataFormatter formatter, String testcases) {

		ArrayList<Row> ExcelRow = new ArrayList<Row>();

		for (int i = 0; i <= ws.getLastRowNum(); i++) {
			if (ws.getRow(i) != null) {
				ExcelRow.add(ws.getRow(i));
			}
		}

		ArrayList<Row> ExcelColumn = new ArrayList<Row>();

		for (int i = 0; i < ExcelRow.size(); i++) {

			Row row = ExcelRow.get(i);
			Cell firstcell = row.getCell(0);

			if (firstcell != null && formatter.formatCellValue(firstcell).trim().equalsIgnoreCase(testcases.trim())) {
				ExcelColumn.add(row);
			}

		}

		return ExcelColumn;

	}

}

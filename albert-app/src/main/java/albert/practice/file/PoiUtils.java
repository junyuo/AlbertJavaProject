package albert.practice.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lombok.Cleanup;

public class PoiUtils {

	private NumberFormat fmt = NumberFormat.getInstance(Locale.US);

	public void writeXlsx(String expectedSheetName, String destName, List<List<String>> list) throws Exception {
		Workbook wb = new XSSFWorkbook();
		String safeName = WorkbookUtil.createSafeSheetName(expectedSheetName);
		Sheet sheet = wb.createSheet(safeName);
		try {
			
			CellStyle popStyle = createPopStyle(wb);
			
			int rowNum = 0;
			Row row = createHeader(sheet, rowNum);
			
			// create data row
			for (List<String> arr : list) {
				rowNum++;
				row = sheet.createRow(rowNum);
				row.createCell(0).setCellValue(Integer.parseInt(arr.get(0)));
				row.createCell(1).setCellValue(arr.get(1));
				row.createCell(2).setCellValue(fmt.parse(arr.get(2)).intValue());
				row.createCell(3).setCellValue(Double.parseDouble(arr.get(3)));
				row.createCell(4).setCellValue(arr.get(4));
				
				row.getCell(2).setCellStyle(popStyle);

				int start = sheet.getRow(rowNum).getFirstCellNum();
				int end = sheet.getRow(rowNum).getLastCellNum();
				for (int i = start; i < end; i++) {
					sheet.autoSizeColumn(i);
				}
			}

			@Cleanup
			OutputStream fileOut = new FileOutputStream(destName);
			wb.write(fileOut);
		} catch (IOException | ParseException e) {
			throw e;
		}
	}

	private CellStyle createPopStyle(Workbook wb) {
		CellStyle popStyle = wb.createCellStyle();
		short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
		popStyle.setDataFormat(format);
		return popStyle;
	}

	private Row createHeader(Sheet sheet, int rowNum) {
		// create header
		Row row = sheet.createRow(rowNum);
		row.createCell(0).setCellValue(new XSSFRichTextString("Rank"));
		row.createCell(1).setCellValue(new XSSFRichTextString("Country"));
		row.createCell(2).setCellValue(new XSSFRichTextString("Total \r\n (persons)"));
		row.createCell(3).setCellValue(new XSSFRichTextString("per sq.km"));
		row.createCell(4).setCellValue(new XSSFRichTextString("Date"));

		// set the cell style to allow wrapping.
		CellStyle style = sheet.getWorkbook().createCellStyle();
		style.setWrapText(true);
		row.getCell(2).setCellStyle(style);

		return row;
	}

}

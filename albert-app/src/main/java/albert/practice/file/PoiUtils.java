package albert.practice.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class PoiUtils {

	private NumberFormat fmt = NumberFormat.getInstance(Locale.US);
    private DateFormat datefmt = new SimpleDateFormat("yyyy-MM-dd");
    
	public void writeXlsx(String expectedSheetName, String destName, List<DataBean> list) throws Exception {
		Workbook wb = new XSSFWorkbook();
		String safeName = WorkbookUtil.createSafeSheetName(expectedSheetName);
		Sheet sheet = wb.createSheet(safeName);
		try {

			CellStyle popStyle = createPopStyle(wb);
			
			
			int rowNum = 0;
			Row row = createHeader(sheet, rowNum);

			// create data row
			for (DataBean data : list) {
				rowNum++;
				row = sheet.createRow(rowNum);
				row.createCell(0).setCellValue(data.getRank());
				row.createCell(1).setCellValue(data.getCountry());
				row.createCell(2).setCellValue(fmt.parse(Long.toString(data.getTotal())).longValue());
				row.createCell(3).setCellValue(data.getSqKm());
				row.createCell(4).setCellValue(datefmt.format(data.getDate()));

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
		short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
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

		// add filter headers
		int start = sheet.getRow(0).getFirstCellNum();
		int end = sheet.getRow(0).getLastCellNum();
		for (int i = start; i < end; i++) {
			CellRangeAddress ca = new CellRangeAddress(0, rowNum, start, end);
			sheet.setAutoFilter(ca);
		}
		
		// freeze the first row
		sheet.createFreezePane(0, 1);

		return row;
	}
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	@ToString
	public static class DataBean {
		private int rank;
		private String country;
		private long total;
		private double sqKm;
		private Date date;
	}

}

package albert.practice.file;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class PoiUtilsTest extends PoiUtils {

	private String expectedSheetName;
	private String destName;
	private List<DataBean> list;

	private List<ExpenseRecord> expenseRecords;
	private String expenseFileName;

	@Before
	public void setup() {
		expectedSheetName = "測試";
		destName = "D:/dropbox/test.xlsx";

		DataBean bean1 = new DataBean(1, "China", 1378020000, 147.75, addDays(new Date(), 30));
		DataBean bean2 = new DataBean(2, "India", 1266884000, 426.1, addDays(new Date(), -30));
		DataBean bean3 = new DataBean(3, "United States of America", 323128000, 35.32, addDays(new Date(), 50));
		DataBean bean4 = new DataBean(4, "Indonesia", 257453000, 142.12, addDays(new Date(), -50));
		DataBean bean5 = new DataBean(5, "Brazil", 2060810000, 24.66, addDays(new Date(), 80));

		list = Arrays.asList(bean1, bean2, bean3, bean4, bean5);

		ExpenseRecord record1_1 = new ExpenseRecord("JAN", "TRAFFIC", 70);
		ExpenseRecord record1_2 = new ExpenseRecord("JAN", "ENTERTAINMENT", 3000);
		ExpenseRecord record1_3 = new ExpenseRecord("JAN", "PHONE", 200);
		ExpenseRecord record1_4 = new ExpenseRecord("JAN", "DINNER", 1500);

		ExpenseRecord record2_1 = new ExpenseRecord("FEB", "TRAFFIC", 70);
		ExpenseRecord record2_2 = new ExpenseRecord("FEB", "ENTERTAINMENT", 2300);
		ExpenseRecord record2_3 = new ExpenseRecord("FEB", "PHONE", 200);
		ExpenseRecord record2_4 = new ExpenseRecord("FEB", "DINNER", 1800);

		ExpenseRecord record3_1 = new ExpenseRecord("MAR", "TRAFFIC", 70);
		ExpenseRecord record3_2 = new ExpenseRecord("MAR", "ENTERTAINMENT", 5000);
		ExpenseRecord record3_3 = new ExpenseRecord("MAR", "PHONE", 200);
		ExpenseRecord record3_4 = new ExpenseRecord("MAR", "DINNER", 2500);
		
		expenseRecords = Arrays.asList(record1_1, record1_2, record1_3, record1_4, record2_1, record2_2, record2_3,
				record2_4, record3_1, record3_2, record3_3, record3_4);
		
		expenseFileName = "D:/dropbox/expense.xlsx";
	}

	@Test
	public void testWriteXlsx() throws Exception {
		writeXlsx(expectedSheetName, destName, list);
	}

	private Date addDays(Date date, int days) {
		DateTime datetime = new DateTime(date);
		return datetime.plusDays(days).toDate();
	}
	
	@Test
	public void testCreatePivotTable() throws IOException{
		createPivotTable(expenseRecords, expenseFileName);
		
	}

}

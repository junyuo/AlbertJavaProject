package albert.practice.file;

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
	}

	@Test
	public void testWriteXlsx() throws Exception {
		writeXlsx(expectedSheetName, destName, list);
	}

	private Date addDays(Date date, int days) {
		DateTime datetime = new DateTime(date);
		return datetime.plusDays(days).toDate();
	}

}

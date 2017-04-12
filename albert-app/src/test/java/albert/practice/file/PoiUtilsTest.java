package albert.practice.file;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import albert.practice.file.PoiUtils;

public class PoiUtilsTest extends PoiUtils {

	private String expectedSheetName;
	private String destName;
	private List<List<String>> list;

	@Before
	public void setup() {
		expectedSheetName = "測試";
		destName = "D:/dropbox/test.xlsx";
		list = Arrays.asList(Arrays.asList("1", "China", "1,378,020,000", "147.75", "2016"),
				Arrays.asList("2", "India", "1,266,884,000", "426.10", "2016 WFB"),
				Arrays.asList("3", "United States of America", "323,128,000", "35.32", "2016"),
				Arrays.asList("4", "Indonesia", "257,453,000", "142.12", "2016"),
				Arrays.asList("5", "Brazil", "206,081,000", "24.66", "2016"));
	}

	@Test
	public void testWriteXlsx() throws Exception {
		writeXlsx(expectedSheetName, destName, list);
	}

}

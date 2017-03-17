package albert.practice.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;

import lombok.extern.slf4j.Slf4j;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

@Slf4j
public class CsvUtilsTest extends CsvUtils {

    private String csvFile;
    private String writeCsvFile;
    private List<CsvVo> testData = new ArrayList<>();
    
    @Before
    public void setup() {
        csvFile = "D:/work/AOCS/點位/opc_ACS_T1_nodes_20170316.csv";
        writeCsvFile = "D:/work/AOCS/點位/writeCsvFile.csv";
        
        CsvVo vo1 = new CsvVo(2, "channel.device.tag1");
        CsvVo vo2 = new CsvVo(2, "channel.device.tag2");
        CsvVo vo3 = new CsvVo(2, "channel.device.tag3");
        CsvVo vo4 = new CsvVo(2, "channel.device.tag4");
        CsvVo vo5 = new CsvVo(2, "channel.device.tag5");
        testData = Arrays.asList(vo1, vo2, vo3, vo4, vo5);
    }
    
    @Test
    public void testReadCsv() throws IOException {
        List<CsvVo> result = read(csvFile);
        result.forEach(row -> log.debug(row.toString()));
    }
    
    @Test
    public void testWriteCsv() throws IOException {
        write(testData, writeCsvFile);
    }
    
    @Test
    public void testCsvVoBean() {
        new BeanTester().testBean(CsvVo.class);
    }

    @Test
    public void testCsvVoBeanEqualsAndHashcode() {
        EqualsVerifier.forClass(CsvVo.class)
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
    }
}

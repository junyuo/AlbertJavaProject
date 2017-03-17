package albert.practice.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class CsvUtils {
    private static final String[] FILE_HEADER = {"ns", "identifier"};
    private static final String NS = "ns";
    private static final String ID = "identifier";

    public static List<CsvVo> read(String fileName) throws IOException {
        List<CsvVo> result = new ArrayList<>();

        // Returns a new CSVFormat with the header of the format set to the given values.
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER);

        @Cleanup
        FileReader fileReader = null;
        @Cleanup
        CSVParser csvFileParser = null;

        try {
            fileReader = new FileReader(fileName);
            csvFileParser = new CSVParser(fileReader, csvFileFormat);

            // Parses the CSV input according to the given format and returns the content as a list
            // of CSVRecords.
            List<CSVRecord> csvRecords = csvFileParser.getRecords();

            for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = csvRecords.get(i);
                String ns = record.get(NS);
                String identifier = record.get(ID);
                result.add(new CsvVo(Integer.valueOf(ns), identifier));
            }
        } catch (IOException e) {
            throw e;
        }

        return result;
    }

    public static void write(List<CsvVo> result, String writeCsvFile) throws IOException {
        @Cleanup
        FileWriter fileWriter = null;
        @Cleanup
        CSVPrinter csvFilePrinter = null;
        // Create the CSVFormat object with "\n" as a record delimiter
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");

        try {
            // initialize FileWriter object
            fileWriter = new FileWriter(writeCsvFile);

            // initialize CSVPrinter object
            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

            // Create CSV file header
            csvFilePrinter.printRecord(FILE_HEADER);

            // Write a new student object list to the CSV file
            for (CsvVo vo : result) {
                List record = new ArrayList();
                record.add(vo.getNs());
                record.add(vo.getIdentifier());

                csvFilePrinter.printRecord(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @ToString
    public static class CsvVo {
        private Integer ns;
        private String identifier;
    }

}

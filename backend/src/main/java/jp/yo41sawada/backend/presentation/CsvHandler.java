package jp.yo41sawada.backend.presentation;

import java.io.LineNumberReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.RFC4180Parser;
import com.opencsv.RFC4180ParserBuilder;
import com.opencsv.bean.CsvToBeanBuilder;

public class CsvHandler {
    private static final char CSV_SEPARATOR = ',';
    private static final char CSV_QUOTER = '"';
    private static final RFC4180Parser CSV_RFC4180_PARSER;

    static {
        CSV_RFC4180_PARSER = new RFC4180ParserBuilder()
                .withSeparator(CSV_SEPARATOR)
                .withQuoteChar(CSV_QUOTER)
                .build();
    }

    public CSVReader getCSVReader(LineNumberReader lineNumberReader) {
        return new CSVReaderBuilder(lineNumberReader)
                .withCSVParser(CSV_RFC4180_PARSER)
                .build();
    }

    public List<UserCsv> getCsvUsers(CSVReader csvReader) {
        return new CsvToBeanBuilder<UserCsv>(csvReader)
                .withType(UserCsv.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .parse();
    }
}

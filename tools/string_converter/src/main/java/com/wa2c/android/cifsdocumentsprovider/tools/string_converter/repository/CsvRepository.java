package com.wa2c.android.cifsdocumentsprovider.tools.string_converter.repository;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.wa2c.android.cifsdocumentsprovider.tools.string_converter.model.CsvRow;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * CSV file repository
 */
public class CsvRepository {

    private final CSVParser parser = new CSVParserBuilder()
            .withEscapeChar(CSVParser.DEFAULT_ESCAPE_CHARACTER)
            .build();

    public String downloadCsv(String url) throws IOException {
        return new String(new URL(url).openStream().readAllBytes(), Charset.forName("UTF-8"));
    }

    public List<CsvRow> readCsv(String csvFilePath) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(csvFilePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, CsvRepository.CSV_CHARSET);
             CSVReader csvReader = new CSVReaderBuilder(inputStreamReader)
                     .withCSVParser(parser)
                     .build()) {

            List<String[]> rawList = csvReader.readAll();
            Map<Integer, String> codeMap = Map.ofEntries(
                    new AbstractMap.SimpleEntry<>(2, rawList.get(0)[2]),
                    new AbstractMap.SimpleEntry<>(3, rawList.get(0)[3])
                    // ... Add more entries for each column as needed
            );

            return rawList.subList(2, rawList.size()).stream()
                    .map(row -> {
                        Map<String, String> langText = IntStream.range(2, row.length)
                                .boxed()
                                .collect(Collectors.toMap(
                                        index -> codeMap.get(index),
                                        index -> row[index]
                                ));

                        return new CsvRow(
                                row[0],
                                row[1],
                                langText
                        );
                    })
                    .collect(Collectors.toList());
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }


    private static final Charset CSV_CHARSET = Charset.forName("UTF-8");
}


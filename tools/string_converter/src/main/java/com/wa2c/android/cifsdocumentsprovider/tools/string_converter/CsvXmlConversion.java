package com.wa2c.android.cifsdocumentsprovider.tools.string_converter;

import com.wa2c.android.cifsdocumentsprovider.tools.string_converter.model.CsvRow;
import com.wa2c.android.cifsdocumentsprovider.tools.string_converter.repository.CsvRepository;
import com.wa2c.android.cifsdocumentsprovider.tools.string_converter.repository.ResourceRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * CSV-XML conversion
 */
public class CsvXmlConversion {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: CsvXmlConversion <inputFilePath> <resourceDirPath> <csvUrl>");
            System.exit(1);
        }

        String inputFilePath = args[0];
        String resourceDirPath = args[1];
        String csvUrl = args[2];

        CsvRepository csvRepository = new CsvRepository();
        ResourceRepository resourceRepository = new ResourceRepository();

        try {
            // CSV reading
            String csvText = csvRepository.downloadCsv(csvUrl);
            File inputFile = new File(inputFilePath);
            File resourceDir = new File(resourceDirPath);

            inputFile.getParentFile().mkdirs(); // Ensure parent directory exists
            inputFile.createNewFile();

            try (FileWriter fileWriter = new FileWriter(inputFile, Charset.forName("UTF-8"))) {
                fileWriter.write(csvText);
            }

            List<CsvRow> csvList = csvRepository.readCsv(inputFile.getAbsolutePath());

            // CSV writing
            resourceRepository.saveMultiLanguage(
                    csvList,
                    resourceDirPath
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


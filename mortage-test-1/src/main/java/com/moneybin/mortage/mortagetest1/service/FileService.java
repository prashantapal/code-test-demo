package com.moneybin.mortage.mortagetest1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class FileService {

    @Value("${prospect.file.absolutepath}")
    private String prospectFile;

    private static Logger logger = LoggerFactory.getLogger(FileService.class);

    public List<String> readProspectFile() {
        List<String> contents = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getInputSteam()))) {
            reader.readLine(); // skip the header
            String line;
            while ((line = reader.readLine()) != null) {
                //TODO Prashanta Kumar Pal 04.10.2021, Flush the reader if file size is big, currently not in scope.
                contents.add(line);
            }
            return contents;
        } catch (IOException ex) {
            logger.error("Could not read the prospect file", ex);
            throw new RuntimeException(ex);
        }

    }

    private InputStream getInputSteam() throws FileNotFoundException {
        if (isBlank(prospectFile)) {
            prospectFile = "prospects.txt";
            logger.info("Loading the prospect file " + prospectFile + " from local storage......");
            return Thread.currentThread().getContextClassLoader().getResourceAsStream(prospectFile);
        } else {
            logger.info("Loading the prospect file " + prospectFile);
            return new FileInputStream(prospectFile);
        }
    }
}

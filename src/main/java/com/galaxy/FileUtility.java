package com.galaxy;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtility {

    public List<String> loadLines(String fileName) throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        return Files.readAllLines(path, Charset.defaultCharset());
    }
}

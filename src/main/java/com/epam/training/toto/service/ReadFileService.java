package com.epam.training.toto.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileService {

    public List<String> readFile(final String dataFile) throws IOException, URISyntaxException {
        URL url = ReadFileService.class.getClassLoader().getResource(dataFile);
        if (url == null) {
            throw new FileNotFoundException();
        }
        Path path = Paths.get(url.toURI());
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}

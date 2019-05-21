package com.epam.training.toto;

import com.epam.training.toto.service.PrintService;
import com.epam.training.toto.service.ReadFileService;
import com.epam.training.toto.service.TotoService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class App {

    private static String dataFile = "materials/toto.csv";
    private static String dataFileT3 = "materials/toto1.csv";

    private static PrintService printService = new PrintService();
    private static TotoService totoService = new TotoService();
    private static ReadFileService readFileService = new ReadFileService();

    public static void main(String[] args) throws IOException, URISyntaxException {

        List<ResultDto> resultList = totoService.getResultDtosFromFile(readFileService.readFile(dataFile));
        List<ResultDto> resultListTask3 = totoService.getResultDtosFromFile(readFileService.readFile(dataFileT3));

        // 1
        printService.printLargestPrize(resultList);

        // 2
        printService.printEachRoundTeamResult(resultList);
        printService.printEachRoundTeamResultIncorrectStrings();

        // 3
        printService.printWonPrize(resultListTask3);
    }
}

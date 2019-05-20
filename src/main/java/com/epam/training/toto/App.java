package com.epam.training.toto;

import com.epam.training.toto.service.PrintService;
import com.epam.training.toto.service.TotoService;

import java.io.IOException;
import java.util.List;

public class App {

    private static String dataFile = "materials/toto.csv";
    private static String dataFileT3 = "materials/toto1.csv";

    private static PrintService printService = new PrintService();

    public static void main(String[] args) throws IOException {

        List<ResultDto> resultList = TotoService.readFile(dataFile);
        List<ResultDto> resultListTask3 = TotoService.readFile(dataFileT3);

        // 1
        printService.printLargestPrize(resultList);

        // 2
        printService.printEachRoundTeamResult(resultList);
        printService.printEachRoundTeamResultIncorrectStrings();

        // 3
        printService.printWonPrize(resultListTask3);
    }
}

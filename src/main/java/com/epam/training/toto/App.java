package com.epam.training.toto;

import com.epam.training.toto.service.PrintService;
import com.epam.training.toto.service.TotoService;

import java.util.List;

public class App {

    private static String dataFile = "materials/toto.csv";

    private static PrintService printService = new PrintService();

    public static void main(String[] args) {

        List<ResultDto> resultList = TotoService.readFile(dataFile);

        // 1
        printService.printLargestPrize(resultList);

        // 2
        printService.printEachRoundTeamResult(resultList);
        printService.printEachRoundTeamResultIncorrectStrings();

    }
}

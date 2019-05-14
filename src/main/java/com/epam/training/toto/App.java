package com.epam.training.toto;

import com.epam.training.toto.service.TotoService;

import java.util.List;

public class App {

    private static String dataFile = "materials/toto.csv";

    public static void main(String[] args) {

        List<ResultDto> resultList = TotoService.readFile(dataFile);

        // 1
        TotoService.printLargestPrize(resultList);

        // 2
        TotoService.printEachRoundTeamResult(resultList);


    }
}

// files. read all files


// 1st line example

// 2015;44;1;2015.10.29.;
// 23;76 500 UAH; 14 hits
// 46;9 640 UAH; 13 hits
// 1410;355 UAH; 12 hits
// 7800;185 UAH; 11 hits
// 18990;0 UAH; 10 hits
// 2;1;1;1;2;2;2;1;2;1;1;1;1;+2
package com.epam.training.toto.service;

import com.epam.training.toto.ResultDto;
import com.epam.training.toto.domain.Round;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class PrintService {

    private static final DecimalFormat decimalFormat = new DecimalFormat("##.##");

    public void printEachRoundTeamResult(List<ResultDto> resultList) {
        double[][] teamResults = Round.getAllRoundsResults(resultList);
        for (double[] teamResult : teamResults) {
            System.out.println(String.format("team #1 won: %s %%, team #2 won: %s %%, draw: %s %%",
                    decimalFormat.format(teamResult[0]),
                    decimalFormat.format(teamResult[1]),
                    decimalFormat.format(teamResult[2])));
        }
    }

    public void printEachRoundTeamResultIncorrectStrings() {
        Map<Integer, List<String>> incorrectDataStrings = Round.incorrectDataStrings;
        if (!incorrectDataStrings.isEmpty()) {
            System.out.println("\nResults with incorrect data: \n\n String #        Outcomes");
            for (Map.Entry entry : incorrectDataStrings.entrySet()) {
                System.out.println(entry.getKey().toString() + "            " + entry.getValue());
            }
        }
    }

    public void printLargestPrize(List<ResultDto> resultList) {
        System.out.println("Largest prize ever recorded is: " + TotoService.getLargestPrize(resultList) + " !\n");
    }
}

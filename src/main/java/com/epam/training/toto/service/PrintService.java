package com.epam.training.toto.service;

import com.epam.training.toto.ResultDto;
import com.epam.training.toto.domain.Round;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class PrintService {

    private static final DecimalFormat decimalFormat = new DecimalFormat("##.##");
    private int maxEnterAttempts = 3;

    public void printEachRoundTeamResult(List<ResultDto> resultList) {
        double[][] teamResults = Round.getAllGamesEachTeamResults(resultList);
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

    public void calcHitsAndPrizeForWager(List<ResultDto> resultDtoList) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String enteredDate = "";
        System.out.println("Enter date: \n");
        for(int i = 0; i <= maxEnterAttempts; i++) {
            enteredDate = br.readLine();
            if (!FormatCheckService.validateDateFormat(enteredDate)) {
                if (Round.checkResultWithDateExist(resultDtoList, enteredDate)) {
                    break;
                } else {
                    System.out.println("There is no result by this date.\nTry another date: ");
                }
            }
            System.out.println("Date format should be: " + FormatCheckService.DATE_FORMAT +
                    "\n Reenter date please: \n");
        }


        System.out.println("Enter outcomes (1/2/X): \n");
        String enteredOutcome = br.readLine();

        Round.getOutcomesListByDateValue(resultDtoList, enteredDate);
    }
}

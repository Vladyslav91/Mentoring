package com.epam.training.toto.domain;

import com.epam.training.toto.ResultDto;
import com.epam.training.toto.service.FormatCheckService;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class Hit {

    private int maxEnterAttempts = 3;

    public int compareOutcomes(String enteredOutcome, String[] actualOutcome) {
        String[] expectedOutcome = enteredOutcome.split(";");
        assertThat("Entered q-ty of elements does not match!", expectedOutcome.length == actualOutcome.length);

        int equalPairs = 0;
        for (int i = 0; i < expectedOutcome.length; i++) {
            if (expectedOutcome[i].equals(actualOutcome[i])) {
                equalPairs++;
            }
        }
        return equalPairs;
    }

    public String getPrizeByHits(int equalPairs, Integer stringIndex, List<ResultDto> resultDtoList) throws IOException {
        ResultDto resultDto = resultDtoList.get(stringIndex);
        String prize = "";
        if (equalPairs < 10) {
            System.out.println("You loose all...try again.");
            getHitsAndPrizeForWager(resultDtoList);
        }
        switch (equalPairs) {
            case 14:
                prize = resultDto.getPrizeFor14Hits();
                break;
            case 13:
                prize = resultDto.getPrizeFor13Hits();
                break;
            case 12:
                prize = resultDto.getPrizeFor12Hits();
                break;
            case 11:
                prize = resultDto.getPrizeFor11Hits();
                break;
            case 10:
                prize = resultDto.getPrizeFor10Hits();
                break;
        }
        return prize;
    }

    public Pair<Integer, String> getHitsAndPrizeForWager(List<ResultDto> resultDtoList) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read from console
        String enteredDate = "";
        System.out.println("Enter date: \n");
        for (int i = 0; i <= maxEnterAttempts; i++) {
            enteredDate = "2015.10.29";
//            enteredDate = br.readLine();
            if (FormatCheckService.validateDateFormat(enteredDate)) {
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
        String enteredOutcome = "2;1;1;1;2;2;2;1;2;1;1;1;1;+2";
//        String enteredOutcome = br.readLine();

        // Compare outcomes
        Pair<Integer, String[]> pairIndexOutcomes = Round.getResultIndexAndOutcomesListByDateValue(resultDtoList, enteredDate);

        int hits = compareOutcomes(enteredOutcome, pairIndexOutcomes.getValue());
        String prizeValue = getPrizeByHits(hits, pairIndexOutcomes.getKey(), resultDtoList);
        return new Pair<>(hits, prizeValue);
    }
}

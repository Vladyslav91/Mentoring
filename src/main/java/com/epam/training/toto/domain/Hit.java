package com.epam.training.toto.domain;

import com.epam.training.toto.ResultDto;
import com.epam.training.toto.service.ConsoleReadService;
import javafx.util.Pair;

import java.io.IOException;
import java.util.List;

public class Hit {

    private Round round = new Round();
    private ConsoleReadService consoleReadService = new ConsoleReadService();

    private int maxEnterAttempts = 3;

    private int compareOutcomes(String[] expectedOutcome, String[] actualOutcome) {
        int equalPairs = 0;
        for (int i = 0; i < expectedOutcome.length; i++) {
            if (expectedOutcome[i].equals(actualOutcome[i])) {
                equalPairs++;
            }
        }
        return equalPairs;
    }

    private String getPrizeByHits(int equalPairs, Integer stringIndex, List<ResultDto> resultDtoList) throws IOException {
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
        String enteredDate = consoleReadService.getDateFromConsole(resultDtoList);
        String[] enteredOutcome = consoleReadService.getOutcomeFromConsole();
        // Compare outcomes
        Pair<Integer, String[]> pairIndexOutcomes = round.getResultIndexAndOutcomesListByDateValue(resultDtoList, enteredDate);

        int hits = compareOutcomes(enteredOutcome, pairIndexOutcomes.getValue());
        String prizeValue = getPrizeByHits(hits, pairIndexOutcomes.getKey(), resultDtoList);
        return new Pair<>(hits, prizeValue);
    }
}

package com.epam.training.toto.service;

import com.epam.training.toto.ResultDto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TotoService {

    public static List<ResultDto> readFile(final String dataFile) {
        String cvsSplitBy = ";";
        BufferedReader bufferedReader;
        String line;
        List<ResultDto> resultList = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(dataFile));

            while ((line = bufferedReader.readLine()) != null) {
                String[] betResults = line.split(cvsSplitBy);
                ResultDto roundResult = buildResultDto(betResults);
                resultList.add(roundResult);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    private static ResultDto buildResultDto(String[] betResults) {
        return new ResultDto.Builder()
                .setYear(betResults[0])
                .setWeek(betResults[1])
                .setDate(betResults[2])
                .setRound(betResults[3])
                .setNumberOfGamesWith14Hits(betResults[4])
                .setPrizeFor14Hits(betResults[5])
                .setNumberOfGamesWith13Hits(betResults[6])
                .setPrizeFor13Hits(betResults[7])
                .setNumberOfGamesWith12Hits(betResults[8])
                .setPrizeFor12Hits(betResults[9])
                .setNumberOfGamesWith11Hits(betResults[10])
                .setPrizeFor11Hits(betResults[11])
                .setNumberOfGamesWith10Hits(betResults[12])
                .setPrizeFor10Hits(betResults[13])
                .setOutcomes(Arrays.copyOfRange(betResults, 14, betResults.length))
                .build();
    }

    static int getLargestPrize(List<ResultDto> resultList) {
        int[] resultArray = getAllPrizeValues(resultList);
        Arrays.sort(resultArray);
        return resultArray[resultArray.length - 1];
    }

    private static int[] getAllPrizeValues(List<ResultDto> resultList) {
        int[] prizesValues = new int[resultList.size() * 5];
        int index = 0;
        for (ResultDto aResultList : resultList) {
            prizesValues[index] = FormatCheckService.formatPriceValue(aResultList.getPrizeFor14Hits());
            index++;
            prizesValues[index] = FormatCheckService.formatPriceValue(aResultList.getPrizeFor13Hits());
            index++;
            prizesValues[index] = FormatCheckService.formatPriceValue(aResultList.getPrizeFor12Hits());
            index++;
            prizesValues[index] = FormatCheckService.formatPriceValue(aResultList.getPrizeFor11Hits());
            index++;
            prizesValues[index] = FormatCheckService.formatPriceValue(aResultList.getPrizeFor10Hits());
            index++;
        }
        return prizesValues;
    }

}

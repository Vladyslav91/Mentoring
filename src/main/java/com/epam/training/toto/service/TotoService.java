package com.epam.training.toto.service;

import com.epam.training.toto.ResultDto;
import com.epam.training.toto.domain.Round;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TotoService {

    private static final DecimalFormat decimalFormat = new DecimalFormat("##.##");

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

    public static int getLargestPrize(List<ResultDto> resultList) {
        int[] resultArray = getAllPrizeValues(resultList);
        Arrays.sort(resultArray);
        return resultArray[resultArray.length - 1];
    }

    public static int[] getAllPrizeValues(List<ResultDto> resultList) {
        int[] prizesValues = new int[resultList.size()*5];
        int index = 0;
        for(int i = 0; i < resultList.size(); i++) {
            prizesValues[index] = formatPriceValue(resultList.get(i).getPrizeFor14Hits());
            index++;
            prizesValues[index] = formatPriceValue(resultList.get(i).getPrizeFor13Hits());
            index++;
            prizesValues[index] = formatPriceValue(resultList.get(i).getPrizeFor12Hits());
            index++;
            prizesValues[index] = formatPriceValue(resultList.get(i).getPrizeFor11Hits());
            index++;
            prizesValues[index] = formatPriceValue(resultList.get(i).getPrizeFor10Hits());
            index++;
        }
        return prizesValues;
    }

    public static int formatPriceValue(String priceValue) {
        return Integer.parseInt(priceValue.replaceAll("\\D", ""));
    }


    public static void printEachRoundTeamResult(List<ResultDto> resultList) {
        double[][] teamResults = Round.getAllRoundsResults(resultList);
        for (double[] teamResult : teamResults) {
            System.out.println(String.format("team #1 won: %s %%, team #2 won: %s %%, draw: %s %%",
                    decimalFormat.format(teamResult[0]),
                    decimalFormat.format(teamResult[1]),
                    decimalFormat.format(teamResult[2])));
        }
    }

    public static void printLargestPrize(List<ResultDto> resultList) {
        System.out.println("Largest prize ever recorded is: " + TotoService.getLargestPrize(resultList) + " !");
    }
}

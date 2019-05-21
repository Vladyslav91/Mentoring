package com.epam.training.toto.service;

import com.epam.training.toto.ResultDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TotoService {

    public List<ResultDto> getResultDtosFromFile(List<String> fileLines) {
        List<ResultDto> resultDtos = new ArrayList<>();
        for (String line : fileLines) {
            resultDtos.add(buildResultDto(line.split(";")));
        }
        return resultDtos;
    }

    private ResultDto buildResultDto(String[] betResults) {
        return ResultDto.builder()
                .year(betResults[0])
                .week(betResults[1])
                .round(betResults[2])
                .date(betResults[3])
                .numberOfGamesWith14Hits(betResults[4])
                .prizeFor14Hits(betResults[5])
                .numberOfGamesWith13Hits(betResults[6])
                .prizeFor13Hits(betResults[7])
                .numberOfGamesWith12Hits(betResults[8])
                .prizeFor12Hits(betResults[9])
                .numberOfGamesWith11Hits(betResults[10])
                .prizeFor11Hits(betResults[11])
                .numberOfGamesWith10Hits(betResults[12])
                .prizeFor10Hits(betResults[13])
                .outcomes(Arrays.copyOfRange(betResults, 14, betResults.length))
                .build();
    }

    int getLargestPrize(List<ResultDto> resultList) {
        int[] resultArray = getAllPrizeValues(resultList);
        Arrays.sort(resultArray);
        return resultArray[resultArray.length - 1];
    }

    private int[] getAllPrizeValues(List<ResultDto> resultList) {
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

package com.epam.training.toto.domain;

import com.epam.training.toto.ResultDto;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class Hit {

    public static int compareOutcomes(String enteredOutcome, String[] actualOutcome) {
        String[] expectedOutcome = enteredOutcome.split(";");
        assertThat("Entered q-ty of elements does not match!", expectedOutcome.length == actualOutcome.length);

        int equalPairs = 0;
        for (int i = 0; i < expectedOutcome.length; i++) {
            if(expectedOutcome[i].equals(actualOutcome[i])) {
                equalPairs++;
            }
        }
        return equalPairs;
    }

    public static String getPrizeByHits(int equalPairs, Integer stringIndex, List<ResultDto> resultDtoList) {
        ResultDto resultDto = resultDtoList.get(stringIndex);
        String prize = "";
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
}

package com.epam.training.toto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public final class ResultDto {

    private final String year;
    private final String week;
    private final String round;
    private final String date;
    private final String numberOfGamesWith14Hits;
    private final String prizeFor14Hits;
    private final String numberOfGamesWith13Hits;
    private final String prizeFor13Hits;
    private final String numberOfGamesWith12Hits;
    private final String prizeFor12Hits;
    private final String numberOfGamesWith11Hits;
    private final String prizeFor11Hits;
    private final String numberOfGamesWith10Hits;
    private final String prizeFor10Hits;
    private final String[] outcomes;
}


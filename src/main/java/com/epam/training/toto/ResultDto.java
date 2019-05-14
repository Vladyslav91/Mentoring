package com.epam.training.toto;

import lombok.Getter;

@Getter
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

    private ResultDto(Builder builder) {
        this.year = builder.year;
        this.week = builder.week;
        this.round = builder.round;
        this.date = builder.date;
        this.numberOfGamesWith14Hits = builder.numberOfGamesWith14Hits;
        this.prizeFor14Hits = builder.prizeFor14Hits;
        this.numberOfGamesWith13Hits = builder.numberOfGamesWith13Hits;
        this.prizeFor13Hits = builder.prizeFor13Hits;
        this.numberOfGamesWith12Hits = builder.numberOfGamesWith12Hits;
        this.prizeFor12Hits = builder.prizeFor12Hits;
        this.numberOfGamesWith11Hits = builder.numberOfGamesWith11Hits;
        this.prizeFor11Hits = builder.prizeFor11Hits;
        this.numberOfGamesWith10Hits = builder.numberOfGamesWith10Hits;
        this.prizeFor10Hits = builder.prizeFor10Hits;
        this.outcomes = builder.outcomes;
    }

    public static class Builder {

        String year;
        String week;
        String round;
        String date;
        String numberOfGamesWith14Hits;
        String prizeFor14Hits;
        String numberOfGamesWith13Hits;
        String prizeFor13Hits;
        String numberOfGamesWith12Hits;
        String prizeFor12Hits;
        String numberOfGamesWith11Hits;
        String prizeFor11Hits;
        String numberOfGamesWith10Hits;
        String prizeFor10Hits;
        String[] outcomes;

        public Builder() {
        }

        public Builder setYear(String year) {
            this.year = year;
            return this;
        }

        public Builder setWeek(String week) {
            this.week = week;
            return this;
        }

        public Builder setRound(String round) {
            this.round = round;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setNumberOfGamesWith14Hits(String numberOfGamesWith14Hits) {
            this.numberOfGamesWith14Hits = numberOfGamesWith14Hits;
            return this;
        }

        public Builder setPrizeFor14Hits(String prizeFor14Hits) {
            this.prizeFor14Hits = prizeFor14Hits;
            return this;
        }

        public Builder setNumberOfGamesWith13Hits(String numberOfGamesWith13Hits) {
            this.numberOfGamesWith13Hits = numberOfGamesWith13Hits;
            return this;
        }

        public Builder setPrizeFor13Hits(String prizeFor13Hits) {
            this.prizeFor13Hits = prizeFor13Hits;
            return this;
        }

        public Builder setNumberOfGamesWith12Hits(String numberOfGamesWith12Hits) {
            this.numberOfGamesWith12Hits = numberOfGamesWith12Hits;
            return this;
        }

        public Builder setPrizeFor12Hits(String prizeFor12Hits) {
            this.prizeFor12Hits = prizeFor12Hits;
            return this;
        }

        public Builder setNumberOfGamesWith11Hits(String numberOfGamesWith11Hits) {
            this.numberOfGamesWith11Hits = numberOfGamesWith11Hits;
            return this;
        }

        public Builder setPrizeFor11Hits(String prizeFor11Hits) {
            this.prizeFor11Hits = prizeFor11Hits;
            return this;
        }

        public Builder setNumberOfGamesWith10Hits(String numberOfGamesWith10Hits) {
            this.numberOfGamesWith10Hits = numberOfGamesWith10Hits;
            return this;
        }

        public Builder setPrizeFor10Hits(String prizeFor10Hits) {
            this.prizeFor10Hits = prizeFor10Hits;
            return this;
        }

        public Builder setOutcomes(String[] outcomes) {
            this.outcomes = outcomes;
            return this;
        }

        public ResultDto build() {
            return new ResultDto(this);
        }
    }
}

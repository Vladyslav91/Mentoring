package com.epam.training.toto.domain;

import com.epam.training.toto.ResultDto;

import java.util.List;

public class Round {

    public static double[][] getAllRoundsResults(List<ResultDto> resultList) {
        double[][] outcomesList = new double[resultList.size()][3];

        for (int i = 0; i < outcomesList.length; i++) {
            outcomesList[i] = getRoundResult(resultList.get(i).getOutcomes());
        }
        return outcomesList;
    }

    private static double[] getRoundResult(String[] outcomes) {
        int team1 = 0;
        int team2 = 0;
        int draw = 0;
        double[] result = new double[3];
        for (String element : outcomes) {
            if (Outcome.ONE.getValue().equals(element)) {
                team1++;
            } else if (Outcome.TWO.getValue().equals(element)) {
                team2++;
            } else if (Outcome.X.getValue().equals(element)) {
                draw++;
            } else {
                System.out.println("==DATA ERROR==");
            }
        }
        int outcomeSum = team1 + team2 + draw;
        result[0] = calcPercent(outcomeSum, team1);
        result[1] = calcPercent(outcomeSum, team2);
        result[2] = calcPercent(outcomeSum, draw);
        return result;
    }

    private static double calcPercent(int games, int wins) {
        if (games == 0) {
            throw new ArithmeticException("Q-ty of games is 0");
        }
        if (games < 0) {
            throw new ArithmeticException("Number of games is negative");
        }
        return wins * (100.0 / games);
    }
}

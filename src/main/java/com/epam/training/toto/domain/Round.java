package com.epam.training.toto.domain;

import com.epam.training.toto.Enums.OutcomeEnum;
import com.epam.training.toto.ResultDto;
import com.epam.training.toto.service.CalculationService;
import com.epam.training.toto.service.FormatCheckService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Round {

    public static Map<Integer, List<String>> incorrectDataStrings = new TreeMap<>();
    private static int winVariants = OutcomeEnum.values().length;

    public static double[][] getAllGamesEachTeamResults(List<ResultDto> resultList) {
        double[][] outcomesList = new double[resultList.size()][winVariants];

        for (int i = 0; i < outcomesList.length; i++) {
            outcomesList[i] = getGameEachTeamResults(resultList.get(i).getOutcomes(), ++i);
        }
        return outcomesList;
    }

    private static double[] getGameEachTeamResults(String[] outcomes, int stringNumber) {
        int team1, team2, draw;
        team1 = team2 = draw = 0;
        double[] result = new double[winVariants];
        List<String> listIncorrectStrings = new ArrayList<>();
        int lastArrayElement = outcomes.length - 1;

        for (int i = 0; i < outcomes.length; i++) {
            if (i != lastArrayElement) {
                if (!FormatCheckService.isDataCorrect(outcomes[i])) {
                    listIncorrectStrings.add(outcomes[i]);
                    outcomes[i] = FormatCheckService.formatValue(outcomes[i]);
                }
            } else {
                if (!FormatCheckService.isLastGameDataCorrect(outcomes[i])) {
                    listIncorrectStrings.add(outcomes[i]);
                    outcomes[i] = FormatCheckService.formatLastRoundValue(outcomes[i]);
                }
            }
            if (OutcomeEnum.ONE.getValue().equals(outcomes[i])) {
                team1++;
            } else if (OutcomeEnum.TWO.getValue().equals(outcomes[i])) {
                team2++;
            } else if (OutcomeEnum.X.getValue().equals(outcomes[i])) {
                draw++;
            }
        }
        if (!listIncorrectStrings.isEmpty()) {
            incorrectDataStrings.put(stringNumber, listIncorrectStrings);
        }

        int outcomeSum = team1 + team2 + draw;
        result[0] = CalculationService.calcTeamWinPercentage(outcomeSum, team1);
        result[1] = CalculationService.calcTeamWinPercentage(outcomeSum, team2);
        result[2] = CalculationService.calcTeamWinPercentage(outcomeSum, draw);
        return result;
    }

    public static String[] getOutcomesListByDateValue(List<ResultDto> resultDtoList, String dateValue) {
        String[] actualOutcomes;
        int actualStringIndex;

        for (int i = 0; i < resultDtoList.size(); i++) {
            if (dateValue.equals(resultDtoList.get(i).getDate())) {
                 actualOutcomes = resultDtoList.get(i).getOutcomes();
                 actualStringIndex = i;
            }
        }

//        compareOutcomes()

        return new String[0];
    }

    public static boolean checkResultWithDateExist(List<ResultDto> resultDtoList, String enteredDate) {
        for(ResultDto resultDto : resultDtoList) {
            if (enteredDate.equals(resultDto.getDate())) {
                return true;
            }
        }
        return false;
    }
}

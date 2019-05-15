package com.epam.training.toto.service;

public class CalculationService {

    public static double calcTeamWinPercentage(int games, int wins) {
        if (games == 0) {
            throw new ArithmeticException("Q-ty of games is 0");
        }
        if (games < 0) {
            throw new ArithmeticException("Number of games is negative");
        }
        return wins * (100.0 / games);
    }
}

package com.epam.training.toto.service;

import com.epam.training.toto.ResultDto;
import com.epam.training.toto.domain.Round;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleReadService {

    private FormatCheckService formatCheckService = new FormatCheckService();
    private Round round = new Round();

    private int maxEnterAttempts = 3;

    public String getDateFromConsole(List<ResultDto> resultDtoList) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String enteredDate = "";
        System.out.println("Enter date: \n");
        for (int i = 0; i <= maxEnterAttempts; i++) {
            enteredDate = br.readLine(); // "2015.10.29"
            if (formatCheckService.validateDateFormat(enteredDate)) {
                if (round.checkResultWithDateExist(resultDtoList, enteredDate)) {
                    break;
                } else {
                    System.out.println("There is no result by this date.\nTry another date: ");
                }
            }
            System.out.println("Date format should be: " + formatCheckService.DATE_FORMAT +
                    "\n Reenter date please: \n");
        }
        return enteredDate;
    }

    public String[] getOutcomeFromConsole() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter outcomes (1/2/X): \n");
        String enteredData = br.readLine();// "2;1;1;1;2;2;2;1;2;1;1;1;1;+2"
        String[] enteredOutcome = enteredData.split(";");
        if(enteredOutcome.length != 14) {
            System.out.println("Enter 14 numbers to place a bet:");
            getOutcomeFromConsole();
        }
        return enteredOutcome;
    }
}

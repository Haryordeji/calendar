package com.ayo;

import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

public class DayOfWeek {
    /**
     * Calculates the day of the week for any given date using Zeller's Congruence Theorem
     *
     * @author Ayo Ogunsanya
     * @since 03/31/2022
     */

// implementing Zeller's Congruence Theorem
    public static int ZCT(String @NotNull [] dateInput) {
        int dayOfWeek;

        int month = Integer.parseInt(dateInput[0]);
        int day = Integer.parseInt(dateInput[1]);
        int year = Integer.parseInt(dateInput[2]);

        if (month == 1 || month == 2) {
            year--;
            month += 12;
        }

        int century = Integer.parseInt(dateInput[2].substring(0, 2));
        int lastTwoDigitsOfYear = year % 100;


    dayOfWeek = (day + 13 * (month + 1) / 5 + lastTwoDigitsOfYear + (lastTwoDigitsOfYear / 4)+ 5 - century) % 7;

    return dayOfWeek;
}


public static void main(String[] args) {

    Scanner date = new Scanner(System.in);
    String input;
    String[] week = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};


    System.out.print("Enter date in format MM/DD/YYYY: ");
    input = date.nextLine();

    String[] dateInfo = input.split("/", 4);

    int weekDay = ZCT(dateInfo);
    System.out.println(week[weekDay]);

}
}

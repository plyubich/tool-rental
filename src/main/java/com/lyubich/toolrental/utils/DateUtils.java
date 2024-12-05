package com.lyubich.toolrental.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtils {
  public static int countWeekends(LocalDate checkoutTime, int days) {
    int weekendsCount = 0;
    LocalDate endDate = checkoutTime.plusDays(days);

    LocalDate currentDate = checkoutTime;
    while (!currentDate.isAfter(endDate)) {
      DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
      if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
        weekendsCount++;
      }
      currentDate = currentDate.plusDays(1);
    }

    return weekendsCount;
  }
}

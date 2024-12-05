package com.lyubich.toolrental.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

@Service
public class HolidayService {

  public boolean isHoliday(LocalDate date) {
    return isIndependenceDay(date) || isLaborDay(date);
  }

  private boolean isIndependenceDay(LocalDate date) {
    LocalDate independenceDay = LocalDate.of(date.getYear(), Month.JULY, 4);

    if (independenceDay.getDayOfWeek() == DayOfWeek.SATURDAY) {
      independenceDay = independenceDay.minusDays(1);
    } else if (independenceDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
      independenceDay = independenceDay.plusDays(1);
    }

    return date.equals(independenceDay);
  }

  private boolean isLaborDay(LocalDate date) {
    LocalDate laborDay = LocalDate.of(date.getYear(), Month.SEPTEMBER, 1)
        .with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
    return date.equals(laborDay);
  }
}

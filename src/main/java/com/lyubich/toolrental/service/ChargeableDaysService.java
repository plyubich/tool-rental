package com.lyubich.toolrental.service;

import com.lyubich.toolrental.dto.ToolType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ChargeableDaysService {

  private final HolidayService holidayService;

  public int calculateChargeDays(ToolType toolType, LocalDate checkoutDate, int rentalDays) {
    // Charge days - Count of chargeable days, from day after checkout through and including due
    // date, excluding “no charge” days as specified by the tool type.
    LocalDate endDate = checkoutDate.plusDays(rentalDays - 1);
    int chargeDays = 0;

    for (LocalDate date = checkoutDate; !date.isAfter(endDate); date = date.plusDays(1)) {
      if (isChargeableOnWeekday(date, toolType.isWeekdayCharge()) || isChargeableOnWeekend(date, toolType.isWeekendCharge()) || isChargeableOnHoliday(date, toolType.isHolidayCharge())) {
        chargeDays++;
      }
    }

    return chargeDays;
  }

  private boolean isChargeableOnWeekday(LocalDate date, Boolean isChargeable) {
    DayOfWeek day = date.getDayOfWeek();
    return isChargeable && (day == DayOfWeek.MONDAY || day == DayOfWeek.TUESDAY || day == DayOfWeek.WEDNESDAY || day == DayOfWeek.THURSDAY || day == DayOfWeek.FRIDAY);
  }

  private boolean isChargeableOnWeekend(LocalDate date, Boolean isChargeable) {
    DayOfWeek day = date.getDayOfWeek();
    return isChargeable && (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY);
  }

  private boolean isChargeableOnHoliday(LocalDate date, Boolean isChargeable) {
    return isChargeable && this.holidayService.isHoliday(date);
  }
}

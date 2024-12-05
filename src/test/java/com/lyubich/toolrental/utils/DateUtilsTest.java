package com.lyubich.toolrental.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtilsTest {

  @Test
  void DateUtilsTest() {
    LocalDate checkoutTime = LocalDate.of(2024, 12, 4);
    int days = 10;
    int weekends = DateUtils.countWeekends(checkoutTime, days);

    // Test that the countWeekends method returns the correct number of weekends
    assertEquals(3, weekends);
  }
}

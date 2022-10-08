import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:month_calculator/month_calculator.dart';
import 'package:get/get.dart';

class AgeCalculatorController extends GetxController {
  final dateTime = DateFormat("dd-MM-yyyy");
  final startDate = DateTime.now().obs;
  final endDate = DateTime.now().obs;

  final sty = DateTime(1).obs;
  final endy = DateTime(365).obs;

  final s = DateTime(1).obs;
  final e = DateTime(365).obs;

  final age = 0.0.obs; //YEAR
  final age1 = 0.0.obs; //DAY
  final age2 = 0.0.obs; //MONTH

  void calculateAge() {
    var dateRange = DateTimeRange(start: startDate.value, end: endDate.value);
    var months = MonthCalculator.monthsInRange(dateRange).months;
    var dayrange = DateTimeRange(start: sty.value, end: endy.value);
    var days = MonthCalculator.monthsInRange(dayrange).days;

    /*YEAR*/ age.value = (months / 12).floorToDouble();

    /*DAY*/ age1.value = ((days / 1) + 1).floorToDouble();

    /*MONTH*/ age2.value = ((months % 12)).floorToDouble();
  }

  void setStartDate(date) {
    startDate.value = date;
    sty.value = date;
    s.value = date;
  }

  void setEndDate(date) {
    endDate.value = date;
    endy.value = date;
    e.value = date;
  }

  String getStartDate() {
    int year = startDate.value.year;
    int month = startDate.value.month;
    int day = startDate.value.day;
    return ("$day-$month-$year");
  }

  String getEndDate() {
    int year = endDate.value.year;
    int month = endDate.value.month;
    int day = endDate.value.day;
    return ("$day-$month-$year");
  }
}

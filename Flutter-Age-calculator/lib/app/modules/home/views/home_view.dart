import 'package:flutter/material.dart';

import 'package:get/get.dart';
import 'package:month_calculator/month_calculator.dart';

import '../controllers/home_controller.dart';

class HomeView extends GetView<HomeController> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Age Calculator'),
        centerTitle: true,
      ),
      body: Center(
        child: DatePickerButtons(),
      ),
    );
  }
}

class DatePickerButtons extends StatelessWidget {
  const DatePickerButtons({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
      children: [
        ElevatedButton(
          onPressed: () {
            showDatePicker(
              context: context,
              initialDate: DateTime.now().add(const Duration(days: 0)),
              firstDate: DateTime.now().add(const Duration(days: -30000)),
              lastDate: DateTime.now().add(const Duration(days: 3000)),
            ).then(
              (firstDate) {
                if (firstDate == null) return;
                showDatePicker(
                  context: context,
                  initialDate: firstDate.add(const Duration(days: 1)),
                  firstDate: firstDate,
                  lastDate: DateTime.now().add(const Duration(days: 365)),
                  selectableDayPredicate: (date) {
                    if (date.isBefore(firstDate)) return false;
                    return true;
                  },
                ); //.then(
                //   (lastDate) {
                //     if (lastDate == null) return;
                //     final dateRange =
                //         DateTimeRange(start: firstDate, end: lastDate);
                //     showDialog<void>(
                //       context: context,
                //       builder: (context) {
                //         return AlertDialog(
                //           title: const Text("Your Age is :"),
                //           content: Text(
                //             "${MonthCalculator.monthsInRange(dateRange).months} months and ${MonthCalculator.monthsInRange(dateRange).days} days",
                //             style: Theme.of(context).textTheme.headline6,
                //           ),
                //           // actions: <Widget>[
                //           //   ElevatedButton(
                //           //     child: const Text("OK"),
                //           //     onPressed: () {
                //           //       Navigator.of(context).pop();
                //           //     },
                //           //   ),
                //           // ],
                //         );
                //       },
                //     );
                //   },
                // );
              },
            );
          },
          child: Text(
            "Date Picker",
          ),
        ),
        Text("1.At first choose your birth date,\n 2.Then,choose today's date.")
      ],
    );
  }
}

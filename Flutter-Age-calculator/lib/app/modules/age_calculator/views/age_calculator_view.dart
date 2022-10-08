import 'package:age_calculator/app/utils/text_styles.dart';
import 'package:flutter/material.dart';

import 'package:get/get.dart';

import '../controllers/age_calculator_controller.dart';

class AgeCalculatorView extends GetView<AgeCalculatorController> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xff000814),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: [
              Obx(
                () => RichText(
                  text: TextSpan(
                    text: '',
                    style: TextStyle(
                      fontWeight: FontWeight.bold,
                      color: Colors.white,
                    ),
                    children: [
                      TextSpan(
                        text: '${controller.age.value}',
                        style: TextStyleManager.LARGE_TEXT,
                      ),
                      TextSpan(
                        text: ' YEARS ',
                        style: TextStyleManager.SMALL_TEXT,
                      ),
                      TextSpan(
                        text: '${controller.age2.value}',
                        style: TextStyleManager.LARGE_TEXT,
                      ),
                      TextSpan(
                        text: ' MONTHS ',
                        style: TextStyleManager.SMALL_TEXT,
                      ),
                      TextSpan(
                        text: '${controller.age1.value}',
                        style: TextStyleManager.LARGE_TEXT,
                      ),
                      TextSpan(
                        text: ' DAYS ',
                        style: TextStyleManager.SMALL_TEXT,
                      ),
                    ],
                  ),
                ),
              ),
              Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Padding(
                        padding: const EdgeInsets.all(25.0),
                        child: ElevatedButton(
                          style: ElevatedButton.styleFrom(
                            padding: EdgeInsets.all(70),
                            primary: Color(0xff3d348b),
                            onPrimary: Colors.black,
                            shape: CircleBorder(),
                          ),
                          child: Text(
                            'FROM',
                            style: TextStyleManager.SMALL_TEXT,
                          ),
                          onPressed: () async {
                            DateTime? date = await showDatePicker(
                              context: context,
                              initialDate: DateTime.now().add(
                                const Duration(days: 0),
                              ),
                              firstDate: DateTime.now().add(
                                const Duration(days: -30000),
                              ),
                              lastDate: DateTime.now().add(
                                const Duration(days: 3000),
                              ),
                            );

                            actions:
                            [
                              ElevatedButton(
                                child: const Text("OK"),
                                onPressed: () {
                                  Navigator.of(context).pop();
                                },
                              ),
                            ];

                            controller.setStartDate(date);
                          },
                        ),
                      ),
                      Obx(
                        () => Text(
                          controller.getStartDate(),
                          style: TextStyleManager.MEDIUM_TEXT,
                        ),
                      ),
                    ],
                  ),
                  SizedBox(
                    height: 10,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Padding(
                        padding: const EdgeInsets.all(25.0),
                        child: ElevatedButton(
                          style: ElevatedButton.styleFrom(
                            padding: EdgeInsets.all(70),
                            primary: Color(0xff3d348b),
                            onPrimary: Colors.black,
                            shape: CircleBorder(),
                          ),
                          child: Text(
                            ' TO ',
                            style: TextStyleManager.SMALL_TEXT,
                          ),
                          onPressed: () async {
                            DateTime? date = await showDatePicker(
                              context: context,
                              initialDate: DateTime.now().add(
                                const Duration(days: 0),
                              ),
                              firstDate: DateTime.now().add(
                                const Duration(days: -30000),
                              ),
                              lastDate: DateTime.now().add(
                                const Duration(days: 3000),
                              ),
                            );
                            actions:
                            <Widget>[
                              ElevatedButton(
                                child: const Text("OK"),
                                onPressed: () {
                                  Navigator.of(context).pop();
                                },
                              ),
                            ];
                            controller.setEndDate(date);
                          },
                        ),
                      ),
                      Obx(
                        () => Text(
                          controller.getEndDate(),
                          style: TextStyleManager.MEDIUM_TEXT,
                        ),
                      ),
                    ],
                  ),
                  SizedBox(
                    height: 55,
                  ),
                ],
              ),
              ElevatedButton(
                style: ElevatedButton.styleFrom(
                  padding: EdgeInsets.symmetric(
                    horizontal: 100,
                    vertical: 20,
                  ),
                  primary: Color(0xffd100d1),
                  onPrimary: Colors.black,
                ),
                onPressed: () {
                  controller.calculateAge();
                },
                child: Text(
                  "Calculate",
                  style: TextStyleManager.SMALL_TEXT,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

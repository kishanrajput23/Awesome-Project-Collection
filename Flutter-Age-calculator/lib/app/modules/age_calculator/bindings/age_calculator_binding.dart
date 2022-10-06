import 'package:get/get.dart';

import '../controllers/age_calculator_controller.dart';

class AgeCalculatorBinding extends Bindings {
  @override
  void dependencies() {
    Get.lazyPut<AgeCalculatorController>(
      () => AgeCalculatorController(),
    );
  }
}

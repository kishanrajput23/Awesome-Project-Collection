import 'package:get/get.dart';

import '../modules/age_calculator/bindings/age_calculator_binding.dart';
import '../modules/age_calculator/views/age_calculator_view.dart';
import '../modules/home/bindings/home_binding.dart';
import '../modules/home/views/home_view.dart';

part 'app_routes.dart';

class AppPages {
  AppPages._();

  static const INITIAL = Routes.AGE_CALCULATOR;

  static final routes = [
    GetPage(
      name: _Paths.HOME,
      page: () => HomeView(),
      binding: HomeBinding(),
    ),
    GetPage(
      name: _Paths.AGE_CALCULATOR,
      page: () => AgeCalculatorView(),
      binding: AgeCalculatorBinding(),
    ),
  ];
}

import 'package:flutter/material.dart';
// import 'package:hive_flutter/hive_flutter.dart';
import 'my_home_page.dart';

void main() async {
  // init hive
  // await Hive.initFlutter();

  // open a box
  // await Hive.openBox('my box');

  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(primarySwatch: Colors.deepPurple),
      home: const MyHomePage(),
    );
  }
}

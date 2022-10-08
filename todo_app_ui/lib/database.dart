import 'package:hive_flutter/hive_flutter.dart';

class todoDatabase {
  List todoList = [];

  // referencing the box
  final mybox = Hive.box('mybox');

  //run this method if it is the firsrt time to open the app
  void createInitialData() {
    todoList = [
      ["add your first task", false],
      ["add your second task", false],
    ];
  }

  // load data from the database
  void LoadData() {
    todoList = mybox.get("TodoList");
  }

  //update the database
  void UpdateDatabase() {
    mybox.put("TodoList", todoList);
  }
}

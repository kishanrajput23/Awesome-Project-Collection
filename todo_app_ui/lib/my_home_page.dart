import 'package:flutter/material.dart';
// import 'package:hive_flutter/hive_flutter.dart';
// import 'package:today/database.dart';
import 'package:today/dialog_box.dart';
import 'package:today/todo_list.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  //referencing hive box
  // final mybox = Hive.box('mybox');
  // database
  // todoDatabase db = todoDatabase();

  // @override
  // void initState() {
  //   // first time opening app
  //   if (mybox.get("Todolist") == null) {
  //     db.createInitialData();
  //   } else {
  //     // load the data
  //     db.LoadData();
  //   }
  //   super.initState();
  // }

  // list todolist
  List todoList = [
    ["Make an todo app", false],
    ["write a blog", false]
  ];

  //text editing controller
  final controller = TextEditingController();

  // check box changed
  void CheckBoxChanged(bool? value, int index) {
    setState(() {
      todoList[index][1] = !todoList[index][1];
    });
    //db.UpdateDatabase();
  }

  // save new task
  void SaveNewTask() {
    setState(() {
      todoList.add([controller.text, false]);
      controller.clear();
    });
    Navigator.of(context).pop();
    //db.UpdateDatabase();
  }

  // create new task
  void CreateNewTask() {
    showDialog(
      context: context,
      builder: (context) {
        return DialogBox(
          controller: controller,
          onSave: SaveNewTask,
          onCancel: () => Navigator.of(context).pop(),
        );
      },
    );
  }

  // create delete task
  void deleteTask(int index) {
    setState(() {
      todoList.removeAt(index);
    });
    //db.UpdateDatabase();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.deepPurple[200],
      appBar: AppBar(
        centerTitle: true,
        title: const Text("TODAY"),
        backgroundColor: Colors.deepPurple,
        elevation: 0,
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: CreateNewTask,
        child: const Icon(Icons.add),
      ),
      body: ListView.builder(
        itemCount: todoList.length,
        itemBuilder: (context, index) {
          return TodoList(
            taskName: todoList[index][0],
            taskcompleted: todoList[index][1],
            onChanged: (value) => CheckBoxChanged(value, index),
            deleteFunction: (context) => deleteTask(index),
          );
        },
      ),
    );
  }
}

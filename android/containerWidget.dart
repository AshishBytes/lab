import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(),
        body: Container(
          color: Colors.pink,
          margin: EdgeInsets.all(25),
          child: Text(
            "Hello! I am in the container widget",
            style: TextStyle(fontSize: 25),
          ),
        ),
      ),
    );
  }
}

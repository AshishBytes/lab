import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('THIS IS APP BAR'),
        ),
        body: Center(
          child: Text('THIS IS THE BODY'),
        ),
      ),
    );
  }
}

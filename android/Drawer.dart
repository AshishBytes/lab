import 'package:flutter/material.dart';

void main() => runApp(MaterialApp(
      home: MyApp(),
    ));

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("menu Example"),
      ),
      drawer: Drawer(
        child: ListView(
            children: ['item 1', "item 2", "item 3"]
                .map((item) => ListTile(title: Text("item")))
                .toList()),
      ),
      body: Center(
        child: Text("Select the item from menu"),
      ),
    );
  }
}

import 'package:flutter/material.dart';

void main() => runApp(MaterialApp(home: ButtonApp()));

class ButtonApp extends StatelessWidget {
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Button Example')),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            ElevatedButton(onPressed: () {}, child: Text('Elevetaed Button 1')),
            TextButton(onPressed: () {}, child: Text('text button Button 2')),
            OutlinedButton(onPressed: () {}, child: Text('outlined Button 3')),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        child: Icon(Icons.add),
      ),
    );
  }
}

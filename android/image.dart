import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Image')),
        body: Center(
          child: Column(
            children: <Widget>[
              Image.network(
                'https://blog.logrocket.com/wp-content/uploads/2021/04/Building-Flutter-desktop-app-tutorial-examples.png',
                height: 400,
                width: 250,
              ),
            ],
          ),
        ),
      ),
    );
  }
}

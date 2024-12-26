import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: true,
      theme: ThemeData(brightness: Brightness.dark),
      home: Scaffold(
        appBar: AppBar(
          title: Text('This text is displayed in App Bar'),
          backgroundColor: Colors.amber,
          titleTextStyle: TextStyle(fontSize: 20, color: Colors.black),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Container(
                child: Text(
                  "Hello! I am in the container widget",
                  style: TextStyle(
                    fontSize: 45,
                    color: Colors.black,
                  ),
                ),
                margin: EdgeInsets.all(25),
                color: Colors.pinkAccent,
              ),
              Container(
                child: Image.asset(
                  "image/dice1.png",
                  width: 50,
                  height: 50,
                  fit: BoxFit.fill,
                ),
                margin: EdgeInsets.all(25),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

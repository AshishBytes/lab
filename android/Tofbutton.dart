import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Flutter Buttons'),
        ),
        body: Center(
          child: Column(
            children: <Widget>[
              Container(
                margin: EdgeInsets.all(25),
                child: ElevatedButton(
                  child: Text(
                    'Flat Button',
                    style: TextStyle(fontSize: 20.0),
                  ),
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.cyan, // Background color
                    foregroundColor: Colors.black, // Text color
                  ),
                  onPressed: () {},
                ),
              ),
              Divider(),
              Container(
                child: ElevatedButton(
                  child: Text(
                    'Raised Button',
                    style: TextStyle(fontSize: 20),
                  ),
                  onPressed: () {},
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.pink, // Background color
                    foregroundColor: Colors.black, // Text color
                    padding: EdgeInsets.all(8.0),
                  ),
                ),
              ),
              Divider(),
              Container(
                margin: EdgeInsets.all(10),
                child: FloatingActionButton.extended(
                  onPressed: () {},
                  icon: Icon(Icons.add),
                  label: Text('(FAB)'),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

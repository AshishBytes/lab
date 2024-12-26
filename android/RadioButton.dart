import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Radio button",
      home: home(),
    );
  }
}

class home extends StatefulWidget {
  @override
  State<home> createState() => _homeState();
}

class _homeState extends State<home> {
  String? Gender;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Container(
        padding: EdgeInsets.all(25),
        child: Column(
          children: [
            Text(
              "what is your gender",
              style: TextStyle(fontSize: 25),
            ),
            Divider(),
            RadioListTile(
                title: Text("male"),
                value: "male",
                groupValue: Gender,
                onChanged: (value) {
                  setState(() {
                    Gender = value.toString();
                  });
                }),
            RadioListTile(
                title: Text("female"),
                value: "female",
                groupValue: Gender,
                onChanged: (value) {
                  setState(() {
                    Gender = value.toString();
                  });
                }),
            RadioListTile(
                title: Text("other"),
                value: "other",
                groupValue: Gender,
                onChanged: (value) {
                  setState(() {
                    Gender = value.toString();
                  });
                }),
          ],
        ),
      ),
    );
  }
}

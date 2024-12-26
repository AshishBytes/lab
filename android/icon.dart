import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    title: "Icons",
    home: IconPage(),
  ));
}

class IconPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(),
        body: Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            Icon(Icons.favorite),
            Icon(
              Icons.star,
              size: 100,
              color: Colors.amber,
            ),
            Icon(Icons.audiotrack),
          ],
        ));
  }
}

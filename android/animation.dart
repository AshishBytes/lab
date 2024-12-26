import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
// This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Animation',
      home: ButtonFade(),
    );
  }
}

class ButtonFade extends StatefulWidget {
  @override
  createState() => ButtonFadeState();
}

class ButtonFadeState extends State<ButtonFade> {
  double opacityLevel = 1.0;
  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        AnimatedOpacity(
          opacity: opacityLevel,
          duration: Duration(seconds: 10),
          child: ElevatedButton(
            child: Text('fade me'),
            onPressed: () {
              setState(() => opacityLevel = opacityLevel == 0 ? 1.0 : 0.0);
            },
          ),
        ),
      ],
    );
  }
}

import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "flutter demo",
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: FisrtRoute(),
    );
  }
}

class FisrtRoute extends StatefulWidget {
  @override
  State<FisrtRoute> createState() => _FisrtRouteState();
}

class _FisrtRouteState extends State<FisrtRoute> {
  Widget cont(Color color) {
    return Container(
      height: 200,
      width: 200,
      color: color,
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Scroll view"),
      ),
      body: Center(
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              cont(Colors.blue),
              cont(Colors.brown),
              cont(Colors.red),
              cont(Colors.pink),
              cont(Colors.yellow),
              cont(Colors.orange),
              cont(Colors.green),
            ],
          ),
        ),
      ),
    );
  }
}

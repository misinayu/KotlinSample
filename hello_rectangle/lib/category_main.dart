import 'package:flutter/material.dart';
import 'package:hello_rectangle/category.dart';

// TODO:: Pass this information into your custom [Category] widget
const _categoryName = 'Cake';
const _categoryIcon = Icons.cake;
const _categoryColor = Colors.green;

void main() {
  runApp(UnitConverterApp());
}

class UnitConverterApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Unit Converter',
      home: Scaffold(
        backgroundColor: Colors.green[100],
        body: Center(
          // TODO:: Determine what properties you'll need to pass into the widget
          child: Category(
              name: _categoryName,
              color: _categoryColor,
              iconLocation: _categoryIcon
          ),
        ),
      ),
    );
  }
}

import 'package:flutter/material.dart';
import '../models/character.dart';
import '../services/characters_api.dart';
import '../services/firebase/auth/firebase_auth_service.dart';
import '../widgets/characters_list.dart';
import 'login_screen.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final FirebaseAuthService _auth = FirebaseAuthService();
  String _filter = "";

  setFilter(String changeFilter) {
    setState(() {
      _filter = changeFilter;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Home"),
        backgroundColor: Colors.green,
        actions: [
          IconButton(
              onPressed: () {
                _auth.signOut();
                Navigator.pushReplacement(context,
                    MaterialPageRoute(builder: (context) => LoginPage()));
              },
              icon: Icon(Icons.logout))
        ],
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(20),
            child: TextField(
              onChanged: (value) {
                setFilter(value);
              },
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                labelText: "Filtro",
              ),
            ),
          ),
          CharactersList(
            filter: _filter,
          )
        ],
      ),
    );
  }
}
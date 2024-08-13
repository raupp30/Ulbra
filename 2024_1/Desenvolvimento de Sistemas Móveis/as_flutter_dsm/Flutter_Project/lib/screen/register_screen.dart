import 'package:flutter/material.dart';
import '../services/firebase/auth/firebase_auth_service.dart';

class RegisterScreen extends StatefulWidget {
  @override
  _RegisterScreenState createState() => _RegisterScreenState();
}

class _RegisterScreenState extends State<RegisterScreen> {
  final FirebaseAuthService _auth = FirebaseAuthService();
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  bool enableVisibility = false;

  changeVisibility() {
    setState(() {
      enableVisibility = !enableVisibility;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Registro'),
        backgroundColor: Colors.green, // Definindo a cor da AppBar como verde
        titleTextStyle: const TextStyle(color: Colors.white, fontSize: 26), // Define o estilo do texto da AppBar
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            TextField(
              controller: _emailController,
              decoration: const InputDecoration(labelText: 'Email'),
            ),
            TextField(
              controller: _passwordController,
              obscureText: !enableVisibility,
              decoration: InputDecoration(
                labelText: 'Senha',
                suffixIcon: IconButton(
                  onPressed: () {
                    changeVisibility();
                  },
                  icon: enableVisibility
                      ? Icon(Icons.visibility_off)
                      : Icon(Icons.visibility),
                ),
              ),
            ),
            Container(
              margin: EdgeInsets.only(top: 16), // Adiciona margem apenas na parte superior
              child: ElevatedButton(
                onPressed: () {
                  final String email = _emailController.text;
                  final String password = _passwordController.text;
                  _auth.register(email, password); // Exemplo de registro usando o serviço de autenticação
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.black, // Cor de fundo
                  foregroundColor: Colors.white, // Cor do texto
                  padding: EdgeInsets.symmetric(horizontal: 16, vertical: 8), // Padding interno
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(8), // Bordas arredondadas
                  ),
                  textStyle: TextStyle(fontSize: 18, fontWeight: FontWeight.bold), // Estilo do texto
                ),
                child: const Text("Registrar-se"),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

import 'package:exercicioflutterapi/screen/register_screen.dart';
import 'package:flutter/material.dart';
import '../services/firebase/auth/firebase_auth_service.dart';
import '../utils/results.dart';
import 'home_screen.dart';

class LoginPage extends StatefulWidget {
  LoginPage({super.key});

  @override
  State<LoginPage> createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
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
        title: const Text('Login'),
        backgroundColor: Colors.green,
        titleTextStyle: const TextStyle(color: Colors.white, fontSize: 26), // Define o estilo do texto da AppBar
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: StreamBuilder<Results>(
          stream: _auth.resultsLogin,
          builder: (context, snapshot) {
            ErrorResult result = ErrorResult(code: "");

            if (snapshot.data is ErrorResult) {
              result = snapshot.data as ErrorResult;
            }

            if (snapshot.data is LoadingResult) {
              return const Center(child: CircularProgressIndicator());
            }

            if (snapshot.data is SuccessResult) {
              WidgetsBinding.instance.addPostFrameCallback((_) {
                Navigator.pushReplacement(
                  context,
                  MaterialPageRoute(
                    builder: (context) => HomeScreen(),
                  ),
                );
              });
            }

            return Column(
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
                SizedBox(height: 18), // Adiciona espaço entre o campo de senha e o botão
                ElevatedButton(
                  onPressed: () {
                    final String email = _emailController.text;
                    final String password = _passwordController.text;
                    _auth.signIn(email, password);
                  },
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.green, // Cor de fundo
                    foregroundColor: Colors.white, // Cor do texto
                    padding: EdgeInsets.symmetric(horizontal: 16, vertical: 8), // Padding interno
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(8), // Bordas arredondadas
                    ),
                    textStyle: TextStyle(fontSize: 18, fontWeight: FontWeight.bold), // Estilo do texto
                  ),
                  child: const Text("Entrar na sua conta"),
                ),

                SizedBox(height: 18), // Espaçamento entre os botões
                ElevatedButton(
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => RegisterScreen(),
                      ),
                    );
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

                if (result.code.isNotEmpty)
                  Column(
                    children: [
                      if (result.code == "invalid-email")
                        Text("Autenticacao Invalida"),
                      if (result.code == "wrong-password")
                        Text("Autenticacao Invalida"),
                      if (result.code != "invalid-email" && result.code != "senha incorreta...")
                        Text(
                          "Dados incorretos...",
                          style: TextStyle(color: Colors.red), // Cor do texto de erro
                        ),

                    ],
                  ),
              ],
            );
          },
        ),
      ),
    );
  }
}

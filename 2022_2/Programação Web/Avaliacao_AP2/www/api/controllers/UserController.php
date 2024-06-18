<?php
  class UserController{
    public function validateLogin(){
      $userData = json_decode(file_get_contents("php://input"));
      $userName = $userData -> user;
      $password = $userData -> password;
      
      require_once('models/UserModel.php');
      $UserModel = new UserModel();

      $result = $UserModel -> consultUser($userName);

      if($user = $result -> fetch_assoc()){
        if($password == $user['password']){
        $this -> createJWT($user); 
        } else {
          echo 'senha inválida';
        }
      } else {
        echo 'user não existe';
      }
    }
    public function createJWT($user){
      
$header = [
   'alg' => 'HS256',
   'typ' => 'JWT'
];
$header = json_encode($header);
$header = base64_encode($header);
$header = str_replace(['+', '/', '='], ['-', '_', ''], $header); //base64url

$payload = [
   'iss' => 'localhost',
   'name' => $user['name'],
   'user' => $user['user'],
   'adm' => $user['admin']
];
$payload = json_encode($payload);
$payload = base64_encode($payload);
$payload = str_replace(['+', '/', '='], ['-', '_', ''], $payload); //base64url

$signature = hash_hmac('sha256',"$header.$payload",'minha-senha',true);
$signature = base64_encode($signature);
$signature = str_replace(['+', '/', '='], ['-', '_', ''], $signature); //base64url


$token = $header . "." . $payload . "." . $signature;

header('Content-Type: application/json');	
echo ('{"acess":"true","token":"'.$token.'"}');


    }
    public function isAdmin(){
      $header = apache_request_headers();
$token = $header['Authorization'];

$token = str_replace("Bearer ", "", $token); //se tiver o prefixo "Bearer" remover



$part = explode(".",$token);
$header = $part[0];
$payload = $part[1];
$signature = $part[2];

$valid = hash_hmac('sha256',"$header.$payload",'minha-senha',true);
$valid = base64_encode($valid);
$valid = str_replace(['+', '/', '='], ['-', '_', ''], $valid); //base64url
    
     if($signature == $valid){
      $payload = str_replace(['-', '_', ''], ['+', '/', '='],  $payload); //base64urldecode
      $payload = base64_decode($payload);
      $payload = json_decode($payload);
      if($payload -> adm){
        return true;
      }else{
      echo 'Você não é ADM cara, você não pode consultar...';
      return false;
     }
    }
  }
}
?>
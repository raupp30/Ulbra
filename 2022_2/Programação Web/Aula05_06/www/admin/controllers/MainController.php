<?php
  class MainController{
    public function index(){
      
      if (isset($_SESSION['user'])){
        require_once('views/templates/Header.php');
        require_once('views/templates/home.php');
        require_once('views/templates/Footer.php');
      } else {
        header('Location: ?controller=main&action=login');
      }
    }
    public function login(){
      require_once('views/user/login.php');
    }

    public function logout(){
      session_destroy();
      header('Location: ?controller=main&action=login');
    }
  }
?>
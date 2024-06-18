<?php

  class siteController {
    public function home() { 
      include('views/templates/header.php');
      include('views/site/home.php');
      include('views/templates/footer.php');  
    }

    public function about() {
      include('views/templates/header.php');
      include('views/site/about.php');
      include('views/templates/footer.php');  
    }

    public function contact() {
      include('views/templates/header.php');
      include('views/site/contato.php');
      include('views/templates/footer.php');  
    }
  }

?>
<?php
  class siteController {
    public function home() { 
      include('views/templates/header.php');
      include('views/templates/home.php');
      include('views/templates/footer.php');  
    }
  }

?>
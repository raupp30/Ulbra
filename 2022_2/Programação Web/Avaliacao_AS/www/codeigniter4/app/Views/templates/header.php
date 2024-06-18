<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>

    <!-- jquery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!-- bootstrap -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <script src="assets/js/script.js"></script>
     <link rel="stylesheet" href="<?=base_url('assets/css/style.cs(OFF)')?>">

  </head>
  <body>
  <header class="p-1 text-black" >
      <p class="text-center text-black">Frete grátis para todo Brasil</p>
      <p><a href="<?=base_url('/admin')?>">Área Administrativa</a></p>
    </header>
    <header class="p-5 bg-black" >
      <h2 class="text-center text-white">Raupp Sports</h2>
      <p class="text-center text-white">Seu time, seu estilo</p>
    </header>

  <nav class="navbar navbar-expand-sm bg-dark color-white justify-content-center">
    
  <ul class="nav justify-content-center p-1 navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="<?=base_url('home')?>">ìnicio</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<?=base_url('pronta_entrega')?>">Pronta Entrega</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<?=base_url('selecoes')?>">Seleções</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<?=base_url('brasileirao')?>">Brasileirão</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<?=base_url('europa')?>">Europa</a>
      </li>
    </ul>
  </nav>
        <section class="col-md-12 p-5 text-center">
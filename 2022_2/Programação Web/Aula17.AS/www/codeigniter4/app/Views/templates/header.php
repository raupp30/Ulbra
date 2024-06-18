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
    <link rel="stylesheet" href="<?=base_url('assets/css/style.css')?>">

  </head>
  <body>
    <header class="p-5 text-center">
      <h2>Avaliação Semestral PW</h2>
    </header>

    <div class="container-fluid">
      <div class="row">
        <nav class="p-3 col-md-2">
          <h3>Menu</h3>
          <ul class="nav flex-column">
            <li class="nav-item">
              <a class="nav-link" href="<?=base_url('home')?>">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<?=base_url('about')?>">Sobre</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<?=base_url('products')?>">Produtos e Serviços</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<?=base_url('contact')?>">Contato</a>
            </li>
          </ul>
          <h3>Clientes</h3>
          <ul class="nav flex-column">
            <!-- <li class="nav-item">
              <a class="nav-link" href="?controller=client&action=register">Cadastro</a>
            </li> -->
            <li class="nav-item">
              <a class="nav-link" href="<?=base_url('listClients')?>">Listagem de Clientes</a>
            </li>
          </ul>
        </nav>
        <section class="p-3 col-md-10">
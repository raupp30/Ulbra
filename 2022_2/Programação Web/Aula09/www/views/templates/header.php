<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PHP</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- css -->
    <link rel="stylesheet" href="assets/css/style.css">

</head>

<body>
    <header class="p-5 bg-primary text-white text-center">
        <h1>Minha Página de programação Web</h1>
    </header>

    <div class="container-fluid">
        <div class="row">
            <nav class="col-md-3 p-3">
                <h2>Menu</h2>
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a id="home" class="nav-link" href="?controller=site&action=home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a id="sobre" class="nav-link" href="?controller=site&action=about">Sobre</a>
                    </li>
                    <li class="nav-item">
                        <a id="contato" class="nav-link" href="?controller=site&action=contact">Contato</a>
                    </li>
                </ul>
                <h2>Clientes</h2>
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a id="home" class="nav-link" href="?controller=client&action=register">Cadastro</a>
                    </li>
                    <li class="nav-item">
                        <a id="home" class="nav-link" href="?controller=client&action=listClients">Listagem de clientes</a>
                    </li>
                </ul>
            </nav>
            
            <section class="col-md-9 p-3">
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
    <header class="p-5 bg-danger text-white text-center">
        <h1 >Avaliação Semestral PW</h1>
    </header>

    <div class="container-fluid">
        <div class="row">
            <nav class="bg-white col-md-3 p-3">
                <h2 class="text-black" >Menu</h2>
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a id="home" class="nav-link text-black" href="<?=base_url('home')?>">Home</a>
                    </li>
                    <li class="nav-item">
                        <a id="sobre" class="nav-link text-black" href="<?=base_url('about')?>">Sobre</a>
                    </li>
                    <li class="nav-item">
                        <a id="contato" class="nav-link text-black" href="<?=base_url('contact')?>">Contato</a>
                    </li>
                </ul>
                <h2 class="text-black">Clientes</h2>
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a id="home" class="nav-link text-black" href="<?=base_url('insertClient')?>">Cadastro</a>
                    </li>
                    <li class="nav-item">
                        <a id="home" class="nav-link text-black" href="<?=base_url('listClients')?>">Listagem de clientes</a>
                    </li>
                </ul>

                <h2 class="text-black">Nossos serviços</h2>
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link text-black" href="<?=base_url('manutencao')?>">Manutenção</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-black" href="<?=base_url('insertDisp')?>">Inserção de dispositivos</a>
                    </li>
                </ul>
            </nav>
            
            <section class="col-md-9 p-3 bg-black text-white">
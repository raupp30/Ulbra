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
    <link rel="stylesheet" href="<?=base_url('assets/css/style.css')?>">

</head>

<body>
    <header class="p-4 text-center bg-black text-white">
        <h1>Área administrativa</h1>
        <a href="<?=base_url('admin/logout')?>" class="text-white" > Sair</a>
    </header>

    <div class="container-fluid">
        <div class="row">
            <nav class="col-md-3 p-3 bg-white">
                <h2 class="text-black" >Menu</h2>
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a id="home" class="nav-link text-black" href="<?=base_url('admin')?>">Home</a>
                    </li>
                    <li class="nav-item">
                        <a id="home" class="nav-link text-black" href="<?=base_url('admin/listClients')?>">Listar Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a id="home" class="nav-link text-black" href="<?=base_url('admin/insertClient')?>">Cadastrar Cliente</a>
                    </li>
                </ul>
            </nav>
            
            <section class="col-md-9 p-3">
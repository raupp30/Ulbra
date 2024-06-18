<h1>Listagem de Clientes</h1>

<form class="form-inline my-2 my-lg-0" action="<?=base_url('admin/searchClient')?>" method="search">
      <input name="search" class="form-control mr-sm-2" type="search" placeholder="Pesquisar" aria-label="Pesquisar">
      <br>
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit" >Pesquisar</button>
</form>


<table class="table">
  <tr>
    <th>ID do Cliente</th>
    <th>Nome</th>
    <th>Email</th>
    <th>Telefone</th>
    <th>Endereço</th>
    <th colspan="">Ações</th>
  </tr>

  <?php
    foreach($arrayClients as $client) {
  ?>
    <tr>
      <td>
        <?= $client['idClient']?>
      </td>

      <td>
        <?= $client['name']?>
      </td>

      <td>
        <?= $client['email']?>
      </td>

      <td>
        <?= $client['phone']?>
      </td>
      
      <td>
        <?= $client['address']?>
      </td>
      <td>
        <a class="btn btn-warning" href="<?=base_url("admin/updateClient/{$client['idClient']}")?>">
        Alterar
        </a>
        <a class="btn btn-danger" href="<?=base_url("admin/deleteClient/{$client['idClient']}")?>">
        Deletar
        </a>
      </td>
    </tr>
  <?php
    }
  ?>
</table>
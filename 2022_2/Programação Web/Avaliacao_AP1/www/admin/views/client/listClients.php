<h1>Listagem de Clientes</h1>

<table class="table">
  <tr>
    <th>ID do Cliente</th>
    <th>Nome</th>
    <th>Email</th>
    <th>Telefone</th>
    <th>Endereço</th>
    <th>Ações</th>
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
        <a href="?controller=client&action=detailsClient&id=<?= $client['idClient']?>">
        Detalhes
        </a>
      </td>
    </tr>
  <?php
    }
  ?>
</table>
<?php
class ClientController
{
	var $ClientModel;

	public function __construct(){
		require_once('models/ClientModel.php');
		$this -> ClientModel =  new ClientModel();
	}

	public function listClients()
	{
		$result = $this -> ClientModel->listClients();
		$arrayClients = array();
		while ($line = $result->fetch_assoc()) {
			array_push($arrayClients, $line);
		}
		header('Content-Type: application/json');
		echo json_encode($arrayClients);
	}

	public function consultClient($idClient)
	{
		$result = $this -> ClientModel -> consultClient('idClient');
		if ($arrayClient = $result->fetch_assoc()) {
		header('Content-Type: application/json');
		echo json_encode($arrayClient);
		}else{
			header('Content-Type: application/json');
			echo('
			"sucess" : "i",
			 "message"  "cliente consultado"
			');
		}
	}	

	public function insertClient()
	{
		$Client = json_decode(file_get_contents("php://input"));
		$arrayClient = (array) $Client;
		$this -> ClientModel -> insertClient($arrayClient);
		header('Content-Type: applicate/json');
		echo('
			"sucess" : "i",
			 "message"  "cliente inserido"
			');
	}

	
	public function updateClient($idClient)
	{
		$Client = json_decode(file_get_contents("php://input"));
		$arrayClient = (array) $Client;
		$this -> ClientModel -> updateClient($idClient, $arrayClient);
		header('Content-Type: applicate/json');
		echo('
			"sucess" : "i",
			 "message"  "cliente alterado"
			');
	}

	public function deleteClient($idClient)
	{
		$this -> ClientModel -> deleteClient($idClient);
		header('Content-Type: applicate/json');
		echo('
			"sucess" : "i",
			 "message"  "cliente deletado"
			');
	}
}	
	
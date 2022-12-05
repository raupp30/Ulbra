<?php
namespace App\Controllers;

use CodeIgniter\RESTful\ResourceController;

class clients extends ResourceController{
    private $ClientModel;

    public function __construct()
    {
        $this->ClientModel = new \App\Models\ClientModel();
    }

    public function list(){
        $data = $this->ClientModel->findAll();

        return $this->response->setJSON($data);
    }
}
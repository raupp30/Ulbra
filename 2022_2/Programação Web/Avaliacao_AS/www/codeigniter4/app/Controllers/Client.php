<?php

namespace App\Controllers;
use CodeIgniter\RESTful\ResourceController;
use CodeIgniter\API\ResponseTrait;
use App\Models\ClientModel;


class Client extends BaseController{

    public function listClients(){

        $ClientModel = new ClientModel();
        $data = [
            'arrayClients' => $ClientModel -> findAll()
        ];

        echo view ('templates/header');
        echo view ('client/listClients', $data);
        echo view ('templates/footer');
    }

    //api
    
    use ResponseTrait;
    
    // lista todos clients

    public function index()
    {
        $model = new ClientModel();
        $data = $model->findAll();
        return $this->respond($data);
    }

}
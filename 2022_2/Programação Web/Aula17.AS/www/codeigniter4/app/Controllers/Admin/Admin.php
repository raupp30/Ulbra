<?php

namespace App\Controllers\Admin;

use App\Controllers\BaseController;

class Admin extends BaseController{

    public function index(){
        
        //testar o login
        $session = \Config\Services::session();

        if($session -> has('user')){
           echo view('Admin/templates/header');
           echo view('Admin/main/home');
           echo view('Admin/templates/footer');
        }else{
            return redirect()->to(base_url('admin/login'));
        }

    }

    public function login(){
        echo view('Admin/main/login');
    }

    public function logout(){
        $session = \Config\Services::session();
        $session -> destroy();
        return redirect()->to(base_url('admin/login'));
    }

}   
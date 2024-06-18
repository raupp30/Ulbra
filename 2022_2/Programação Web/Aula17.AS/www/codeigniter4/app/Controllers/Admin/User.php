<?php

namespace App\Controllers\Admin;

use App\Controllers\BaseController;
use App\Models\UserModel;

class User extends BaseController{

    public function validateLogin(){
        $userName = $this -> request -> getVar('login');
        $userPassword = $this -> request -> getVar('password');

        $UserModel = new UserModel();
        $session = \Config\Services::session();

       if($user = $UserModel -> getUser($userName)){

            if($user['password'] == $userPassword){
                $session = \Config\Services::session();
                $session -> set('user', $user);
                return redirect()->to(base_url('/admin'));
            }else{
                $session -> set('erro', 'Senha inválida');
                return redirect()->to(base_url('/admin/login'));
            }
       }else{
            $session -> set('erro', 'Usuário não existe');
            return redirect()->to(base_url('/admin/login'));
       }  
    }
}
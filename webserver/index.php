<?php
require 'vendor/autoload.php';
include_once 'database.php';

$app = new SlimSlim();

$app->get('/:email/:password', function($email, $password){
    
    $password = md5($password);
    
    $databaseObject = new DatabaseLayer();
    $isRegistered = $databaseObject->isUserExist($email, $password);
    
    $app = SlimSlim::getInstance();
    
    if($isRegistered){
        $app->response->setStatus('200');	
        $app->response->headers->set('Content_Type', 'application/json');	
        echo json_encode(Array('isLogin' => '1'));
        
    }else{
        echo json_encode(Array('isLogin' => '0'));
    }
    
});

$app->post('/:email/:password', function($email, $password){
    $password = md5($password);
    
    $app = SlimSlim::getInstance();
    
    $databaseObject = new DatabaseLayer();
    $isInserted = $databaseObject->addNewUser($email, $password);
    
    if($isInserted){
        $app->response->setStatus('200');	
        $app->response->headers->set('Content_Type', 'application/json');	
        echo json_encode(Array('isLogin' => '1'));
    }else{
        echo json_encode(Array('isLogin' => '0'));
    }
 
});

$app->run();

?>
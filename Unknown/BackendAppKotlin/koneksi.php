<?php

$hostname = "localhost";
$username = "root";
$password = "";
$database = "mentoring_kotlin";

$connect = mysqli_connect($hostname,$username,$password,$database);

if(mysqli_connect_errno()){
    echo "Failed connect to MSQL". mysqli_connect_error();
    die();
}
<?php

    include_once("koneksi.php");
    if(!empty($_GET["id"])){

        $id = $_GET["id"];

        $query = "SELECT * FROM anggota where id = '$id'";

    }
    else{
        $query = "SELECT * FROM anggota";
    }

    $get = mysqli_query($connect,$query);

    $data = array();

    if(mysqli_num_rows($get) > 0){

        while($row = mysqli_fecth_assoc($get)) {
            $data = $row;
        }

        set_response(true,"Data Ditemukan",$data);
    }

    else {
        set_response(false,"Data tidak ditemukan",$data);
    }

    function set_response($isSuccess,$message,$data)
    {
        $result = array(
                        "isSucess" => $isSuccess,
                        "message" => $message,
                        "data" => $data
                    );

        echo json_encode($result);

    }

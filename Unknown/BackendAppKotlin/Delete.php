<?php

    include_once("koneksi.php")

    if (!empty($_POST["id"])) {

        $id = $_POST["id"];
        $query = "DELETE FROM anggota WHERE id = '$id'";

        $delete = mysqli_query($connect,$query);

        if($delete) {
            set_response(true, "Success Delete Data");

        }
    }

    else {
            set_response(false,"id Harus diisi");

    }
    function set_response($isSuccess,$message) {

        $result = array(
                        "isSuccess" => $isSuccess,
                        "message" => $message
        );
    
        echo json_encode($result);
    }


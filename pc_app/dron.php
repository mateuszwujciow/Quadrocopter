<!DOCTYPE html>
<!--suppress ALL -->
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Dron</title>
</head>
<body>
    <?php
    // automatyczne wpisywanie konfiguracji z drona przy ładowaniu strony
    $url = "http://212.109.146.180:16969/configuration-list/sensors/current"; // Link do pobrania aktualnej konfiguracji z drona
    $json = file_get_contents($url); // pobieranie JSONa
    $json_data = json_decode($json, true); // dekodowanie
    $dane[0] = $json_data[0]['values']['Kp']; // wpisywanie danych w odpowiednie pola
    $dane[1] = $json_data[0]['values']['Ki'];
    $dane[2] = $json_data[0]['values']['Kd'];
    $dane[3] = $json_data[0]['values']['Tf'];
    $dane[4] = $json_data[1]['values']['Kp'];
    $dane[5] = $json_data[1]['values']['Ki'];
    $dane[6] = $json_data[1]['values']['Kd'];
    $dane[7] = $json_data[1]['values']['Tf'];
    $dane[8] = $json_data[2]['values']['Kp'];
    $dane[9] = $json_data[2]['values']['Ki'];
    $dane[10] = $json_data[2]['values']['Kd'];
    $dane[11] = $json_data[2]['values']['Tf'];
    $dane[12] = $json_data[3]['values']['Kp'];
    $dane[13] = $json_data[3]['values']['Ki'];
    $dane[14] = $json_data[3]['values']['Kd'];
    $dane[15] = $json_data[3]['values']['Tf'];


    //wczytywanie danych z wybranego pliku
    if(isset($_GET['file'])){
        $selectedFile = $_POST['myDropdown']; // pobieranie ścieżki do wybranego pliku
        $jsonSelected = file_get_contents($selectedFile); //pobieranie
        $json_data_Selected = json_decode($jsonSelected, true); //dekodowanie
        $dane[0] = $json_data_Selected[0]['values']['Kp']; // wpisywanie danych
        $dane[1] = $json_data_Selected[0]['values']['Ki'];
        $dane[2] = $json_data_Selected[0]['values']['Kd'];
        $dane[3] = $json_data_Selected[0]['values']['Tf'];
        $dane[4] = $json_data_Selected[1]['values']['Kp'];
        $dane[5] = $json_data_Selected[1]['values']['Ki'];
        $dane[6] = $json_data_Selected[1]['values']['Kd'];
        $dane[7] = $json_data_Selected[1]['values']['Tf'];
        $dane[8] = $json_data_Selected[2]['values']['Kp'];
        $dane[9] = $json_data_Selected[2]['values']['Ki'];
        $dane[10] = $json_data_Selected[2]['values']['Kd'];
        $dane[11] = $json_data_Selected[2]['values']['Tf'];
        $dane[12] = $json_data_Selected[3]['values']['Kp'];
        $dane[13] = $json_data_Selected[3]['values']['Ki'];
        $dane[14] = $json_data_Selected[3]['values']['Kd'];
        $dane[15] = $json_data_Selected[3]['values']['Tf'];
    }

    ?>

<div class="container" style="display: inline-block;vertical-align: top;margin-top: 15px;width:75%">
    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#Configuration-1">Configuration-1</a></li>
    </ul>

    <div class="tab-content">
        <div id="Configuration-1" class="tab-pane fade in active">
            <div style="display: inline-block;vertical-align: top;margin-right: 20px;">
                <form action="?action=save" method="post" role="form" id="conf_1"> <!--Formularz z konfiguracją-->
                    <h3>Pitch</h3>
                    <div class="form-group">
                        <p style="margin-top: 10px;">Kp:</p>
                        <input type="text" class="form-control" name="p_kp" id="p_kp" value=<?php echo $dane[0]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                        <p style="margin-top: 10px;">Ki:</p>
                        <input type="text" class="form-control" name="p_ki" id="p_ki" value=<?php echo $dane[1]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                        <p style="margin-top: 10px;">Kd:</p>
                        <input type="text" class="form-control" name="p_kd" id="p_kd" value=<?php echo $dane[2]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                        <p style="margin-top: 10px;">Tf:</p>
                        <input type="text" class="form-control" name="p_tf" id="p_tf" value=<?php echo $dane[3]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                    </div>

            </div>
            <div style="display: inline-block;vertical-align: top;margin-right: 20px;">
                    <h3>Roll</h3>
                    <div class="form-group">
                        <p style="margin-top: 10px;">Kp:</p>
                        <input type="text" class="form-control" name="r_kp" id="r_kp" value=<?php echo $dane[4]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                        <p style="margin-top: 10px;">Ki:</p>
                        <input type="text" class="form-control" name="r_ki" id="r_ki" value=<?php echo $dane[5]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                        <p style="margin-top: 10px;">Kd:</p>
                        <input type="text" class="form-control" name="r_kd" id="r_kd" value=<?php echo $dane[6]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                        <p style="margin-top: 10px;">Tf:</p>
                        <input type="text" class="form-control" name="r_tf" id="r_tf" value=<?php echo $dane[7]?>  placeholder="Input..."><!-- wpisywanie danych z jsona -->
                    </div>
            </div>
            <div style="display: inline-block;vertical-align: top;margin-right: 20px;">
                    <h3>Yaw</h3>
                    <div class="form-group">
                        <p style="margin-top: 10px;">Kp:</p>
                        <input type="text" class="form-control" name="y_kp" id="y_kp" value=<?php echo $dane[8]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                        <p style="margin-top: 10px;">Ki:</p>
                        <input type="text" class="form-control" name="y_ki" id="y_ki" value=<?php echo $dane[9]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                        <p style="margin-top: 10px;">Kd:</p>
                        <input type="text" class="form-control" name="y_kd" id="y_kd" value=<?php echo $dane[10]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                        <p style="margin-top: 10px;">Tf:</p>
                        <input type="text" class="form-control" name="y_tf" id="y_tf" value=<?php echo $dane[11]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                    </div>
            </div>
            <div style="display: inline-block;vertical-align: top;">
                    <h3>Thrust</h3>
                    <div class="form-group">
                        <p style="margin-top: 10px;">Kp:</p>
                        <input type="text" class="form-control" style="width: 196px;" name="t_kp" id="t_kp" value=<?php echo $dane[12]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                        <p style="margin-top: 10px;">Ki:</p>
                        <input type="text" class="form-control"style="width: 196px;" name="t_ki" id="t_ki" value=<?php echo $dane[13]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                        <p style="margin-top: 10px;">Kd:</p>
                        <input type="text" class="form-control"style="width: 196px;" name="t_kd" id="t_kd" value=<?php echo $dane[14]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                        <p style="margin-top: 10px;">Tf:</p>
                        <input type="text" class="form-control"style="width: 196px;" name="t_tf" id="t_tf" value=<?php echo $dane[15]?> placeholder="Input..."><!-- wpisywanie danych z jsona -->
                    </div>
                <input type="text" class="form-control" name="f_name" id="f_name" placeholder="File name"style="width: 196px;">
                <input type="submit" name="zapisz" value="Write to file"class="btn btn-default" style="margin-bottom: 5px;width: 230px;">
                </form>
            </div>
        </div>
        <a href="http://localhost:63342/Dron/dron.php"><button type="button" class="btn btn-default" style="margin-bottom: 5px;width: 230px;">Read configuration from drone</button></a> <!-- przycisk odświeżający stronę, aby wczytać konfigurację z drona-->
        <button type="button" class="btn btn-default" style="margin-bottom: 5px;">Write configuration to drone</button><!-- nie działa -->

        <?php
        // tworzenie formularza z wyborem pliku
        echo '<div style="margin-top: 20px;margin-left: 20px;color: #000;font-size: 20px;"><p>Select a file</p></div>';
        echo '<form method="post" action="?file=true">';
        echo "<select name='myDropdown' style = 'margin-top: 20px;width:230px;'>";
        // odczytywanie wszystkich plików z podanej ścieżki z rozszerzeniem .txt
        $files_glob = glob("C:/dron/Dron/*.txt");
        var_dump($files_glob);
        $files = scandir('C:/dron/Dron');
        $ignore = array(".", "..");
        foreach ($files_glob as $doc) {
            // Tworzenie opcji wyboru pliku w formularzu typu select
            if (!in_array($doc, $ignore)) {
                $docname = basename($doc);

                echo "<option value=$doc>$docname</option>";

            }
        }
        echo "</select>";
        echo "</br>";
        echo "</br>";
        echo '<input type="submit" name="read_from_file" class="btn btn-default" id="read_from_file"style="margin-bottom: 5px; "value="Read configuration from file">';
        echo "</form>";


        if(isset($_GET['action'])){
            //tworzenie pliku JSON lokalnie na dysku
            $pitch = array("Kp"=>$_POST['p_kp'],"Ki"=>$_POST['p_ki'],"Kd"=>$_POST['p_kd'],"Tf"=>$_POST['p_tf']); // lista zmiennych dla sensora pitch
            $roll = array("Kp"=>$_POST['r_kp'],"Ki"=>$_POST['r_ki'],"Kd"=>$_POST['r_kd'],"Tf"=>$_POST['r_tf']);// lista zmiennych dla sensora roll
            $yaw = array("Kp"=>$_POST['y_kp'],"Ki"=>$_POST['y_ki'],"Kd"=>$_POST['y_kd'],"Tf"=>$_POST['y_tf']);// lista zmiennych dla sensora yaw
            $thrust = array("Kp"=>$_POST['t_kp'],"Ki"=>$_POST['t_ki'],"Kd"=>$_POST['t_kd'],"Tf"=>$_POST['t_tf']);// lista zmiennych dla sensora Thrust

            $array_pitch= array("configuration_id"=>"1",'name'=>"Pitch","values"=>$pitch);  // dodawanie odpowiednich danych do JSONa wynikających ze struktury JSONa odbieranego z drona
            $array_roll= array("configuration_id"=>"1",'name'=>'Roll',"values"=>$roll);
            $array_yaw= array("configuration_id"=>"1",'name'=>'Yaw',"values"=>$yaw);
            $array_thrust= array("configuration_id"=>"1",'name'=>'Thrust',"values"=>$thrust);

            $arrayka = array($array_pitch,$array_roll,$array_yaw,$array_thrust); // Tworzenie listy z danymi ze wszystkich sensorów
            $file_name=$_POST['f_name']; // pobieranie podanej przez użytkownika nazwy pliku
            file_put_contents($file_name.'.txt',json_encode($arrayka)); // tworzenie JSONa na dysku lokalnym w folderze w którym znajduje się plik ze stroną
            echo '<div style="margin-top: 20px;margin-left: 20px;color: #4274f4;font-size: 20px;"><p>Saved to file</p></div>'; // komunikat o zapisaniu pliku

        }?>
    </div>
</div>
</body>
</html>

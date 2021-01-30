<?php

echo " \n -1- \n";

$arr = array(1, "ugur", true, false); 
$arr["a"] = "a";
$arr[true] = "5";
$arr[false] = 2;
$arr[-1] = 3;
$ind_arr = array(1,2);
# $arr[ $ind_arr ] = "array"; -> Illegal

foreach ($arr as $key => $value) {
    echo "{$key} => {$value} \n ";
 }

echo "\n -2- \n";

echo $arr[99];

echo "\n -3- \n";

echo " \n -4-  \n";

$first = array(1,2,3,4);
$second = $first;
$second[0] = 2;
print_r($first); # [1,2,3,4]
print_r($second); # [2,2,3,4]

echo "\n -5- \n";

echo "\n rectangular \n";

$rect_arr = array( array(1,2,3), array(4,5,6), array(7,8,9));
foreach ($rect_arr as $row) {
    foreach($row as $value){ 
      echo "{$value} ";
    }
    echo " \n";
 }

echo "\n ragged \n";

$ragged_row1 = array(1,2);
$ragged_row2 = array(4,5,6);

$ragged_arr = array( $ragged_row1, $ragged_row2);

foreach ($ragged_arr as $row) {
    foreach($row as $value){ 
      echo "{$value} ";
    }
    echo " \n";
 }


echo "\n -6- \n";

$subs_arr = array(array(array(array(0))));
echo $subs_arr[0][0][0][0];

echo "\n -7- \n";

 $init_arr = array("deneme", 123, 5 => 3, 1, true, true, array(1,2));

echo "¨\n -8- \n";

$slice_arr = array(1,2,3,4,5);
$sliced = array_slice($slice_arr, 1, 3);
print_r($sliced); 

echo "\n -9- \n";

$arr_1 = array(1,2);
$arr_2 = array(1,5, 4);

$sum = $arr_1 + $arr_2;
print_r( $sum);  # 0 => 1, 1 => 2, 2 => 4

# $subs = $arr_1 - $arr_2; -> error
# print_r( $arr_1 * $arr_2); -> error

echo "\n -10- \n";

$associative = array( "erdem" => 2, "ugur" => 1, "seyfi" => 3);
foreach($associative as $key => $value){
  echo "{$key} => {$value} \n";
}

?>
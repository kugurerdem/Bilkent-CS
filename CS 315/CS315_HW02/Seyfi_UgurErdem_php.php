<?php

// 1. What are the types of loop control variables?
for($i = 0, $a = "a"; $i < 10; $i = $i + 1){
	echo $a . "\n";
	$a = $a . "a";
}

$n = 7; 
for($i = $n + 1, $isDivisibleBy5 = false; ! $isDivisibleBy5; $i = $i + 1){
	if( $i % 5 == 0){
		echo "First number after " . $n . " that is divisible by 5 is " . $i;
		$isDivisibleBy5 = true;
	}
}

// 2. What are the scopes of loop control variables?
// $x = 10; -this part does not change anything actually-
for($x = 0; $x < 7; $x += 1){
	// nothing
}

echo "\n" . $x; // 7

// 3. Is it legal for the loop control variable or loop parameters to be changed in the loop, and if so, does the change affect loop control?
echo "\n -3- \n";
$n = 10;
for($i = 0; $i < $n; $i += 1){
  $n = $n + 0.5;
  // echo "i is : " . $i . " \n";
  // echo "n is : " . $n . " \n ";
}

echo $i; // 20


?>
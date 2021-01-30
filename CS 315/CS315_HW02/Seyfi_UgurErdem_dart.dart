void main() {
	print('Hello World!');


  print("-1-");
  // 1. What are the types of loop control variables?
  for(var i = 9, isDivisibleBy7 = false; !isDivisibleBy7; i++){
    print( i);
    if( i % 7 == 0){
      isDivisibleBy7 = true;
      print("${i} is divisible by 7");
    }
  }

  print("-2-");
  // 2. What are the scopes of loop control variables?
  for(var i = 9; i < 10; i++){
    // do nothing
  }

  // print( i); -> Error: Getter not found: 'i'.

  print("-3-");
  // 3. Is it legal for the loop control variable or loop parameters to be changed in the loop, and if so, does the change affect loop control?
  var n = 10.0;
  for(var i = 0; i < n; i++){
    n = n + 0.5;
    i = i + 1;
    print( i); // prints 0 2 4 ... 14
  }

  print( n);

}
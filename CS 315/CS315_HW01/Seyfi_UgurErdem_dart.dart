void main() {
  // 1. What types are legal for subscripts? 
  print("-1-");
  var arr = [1,2,3,4];
  print( arr);

  /* 
   arr[10] = 5;
   arr[ true] = 10;
   arr["deneme"] = 3;

   Error: The argument type 'String' can't be assigned to the parameter type 'int'.
  */


  // 2. Are subscripting expressions in element references range checked?
  print("-2-");
  
  /* 
    print( arr[5] );

    Unhandled exception:
    RangeError (index): Invalid value: Not in range 0..3, inclusive: 5
  */



  // 3. When are subscript ranges bound?
  print("-3-");
  
  
  // 4. When does allocation take place?
  print("-4-");

  // 5. Are ragged or rectangular multidimensional arrays allowed, or both?
  print("-5-");

  var jagged_arr = [ [1], [1,2], [1,2,3] ];
  var square_arr = [ [1,2,3], [4,5,6], [7,8,9] ];

  print( jagged_arr);
  print( square_arr);
  
  // 6. What is the maximum number of subscripts?

  print("-6-");
  var subs_arr = [[[[[0]]]]];
  print( subs_arr[0][0][0][0][0] );
  
  // 7. Can array objects be initialized?
  
  print("-7-");
  var initialized = [1.5, "mahmut", 'A'];
  print( initialized);

  // 8. Are any kind of slices supported?
  print("-8-");
  
  var slice_arr = [0,1,2,3,4];
  print( slice_arr.sublist(1,3) );

  // 9. Which operators are provided?
  print("-9-");
  var arr_1 = [1,2];
  var arr_2 = [1,2];

  print(arr_1 + arr_2);
  // print(arr_1 * arr_2); -> Error
  // print(arr_1 * 2); -> Error

  // 10. Are associative arrays available?
  print("-10-");
	var map = {
            'isim': 'a',
            'yas': 20
            };

  print( map['yas'] );

}
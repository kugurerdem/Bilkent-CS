// 1. What types are legal for subscripts?

var arr = []; // empty array
console.log( "1) What types are legal for subscripts? \n");

arr[3] = 5;
arr["h"] = "string";
arr[1.3] = "float number";
arr[true] = "boolean true";
arr[[2, 3]] = "array ";
arr[{ x: 5, y: 3 }] = "object ";
arr[{ x: 10, y: 15 }] = "object 2";
arr[TryClass] = "function ";
arr[new TryClass()] = "try class";

for (object in arr) {
  console.log(object + " : " + arr[object]);
}

// Try Class to initialize an object
function TryClass() {
  this.x = "x";
}

// 2. Are subscripting expressions in element references range checked?

console.log( "\n2. Are subscripting expressions in element references range checked? \n");

console.log( "Element at index 10: " + arr[10]); // Element at index 10: undefined

// 3. When are subscript ranges bound?

console.log("\n3. When are subscript ranges bound? \n")
arr[-1] = 10;
arr[100] = 50;
console.log( arr[-1]); // 10
console.log( arr[100]); // 50
console.log( arr[500]); // undefined

// 4. When does allocation take place?


console.log("\n4. When does allocation take place? \n")
first = [1,2,3,4,5,6]; // memory is allocated for the array
second = first; // second functions in a way that is similar to a pointer
second[2] = 1;
console.log( first); // [1,2,1, 4, 5, 6]


// 5
console.log( "\n5. Are ragged or rectangular multidimensional arrays allowed, or both? \n");
var row0 = [0,1];
var row1 = [1,2,3];

var ragged_arr = [ row0, row1];
for(var i = 0; i < ragged_arr.length; i++){
  console.log( ragged_arr[i]);
}
console.log("---");

multidim_array = [[0,1,2],[3,4,5],[6,7,8]];
for(var i = 0; i < multidim_array.length; i++){
  console.log( multidim_array[i]);
}


// 6. What is the maximum number of subscripts?
console.log( "\n6. What is the maximum number of subscripts? \n");

var inception = [[[[[["As many of you want!"]]]]]];
console.log( inception[0][0][0][0][0][0]); // As many of you want!

// 7. Can array objects be initialized?

init_arr = [1,2, "ugur"];

// 8. Are any kind of slices supported?
console.log("\n 8. Are any kind of slices supported? \n")
var slice_arr = [0,1,2,3,4];
var sliced = slice_arr.slice(1, 3);
console.log( sliced);

// 9. Which operators are provided?
console.log("\n9. Operators \n");

arr_1 = [3,2,1];
arr_2 = [1,2,3]
console.log( arr_1 * 5); // prints NaN
console.log( arr_1 * arr_1); // prints NaN
console.log( arr_1 + arr_2); // prints 3,2,11,2,3

sum_arr = arr_1 + arr_2;
console.log( sum_arr + "typeof" + (typeof sum_arr) ); // prints 3,2,11,2,3typeofstring

arr_2 = arr_1; // obvious assign operator.

console.log( arr_1.sort() ); // prints "[1,2,3]". Note that arr_2 is also sorted.
console.log( arr_2); // [1,2,3]

// 10. Associative arrays
console.log("\n10. Associative arrays \n");

var associative = [];
associative["one"] = 1;
associative["two"] = 2;
associative["three"] = 3;

for(key in associative){
  console.log( key + " : " + associative[ key]);
}

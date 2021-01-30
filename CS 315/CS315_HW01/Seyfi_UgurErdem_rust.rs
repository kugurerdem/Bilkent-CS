fn main() {
  println!("-1-");
  let arr = [1,2,3,4,5];

  println!("{:?}", arr);
  println!("{}", arr[1]);
  /* 
  arr["str"] = 3; 
  slice indices are of type `usize` or ranges of `usize
  */

  println!("-2-");

  /*
  arr[8] = 10; // index out of bounds: the len is 5 but the index is 8
  arr[-1] = 3; // the trait bound `usize: std::ops::Neg` is not satisfied
  */
  
  println!("-3-");

  println!("-4-");

  println!("-5-");

  let mut rectangular_arr: [[ i32; 5]; 6] = [[0; 5]; 6];
  for i in 0..rectangular_arr.len(){
    for j in 0..rectangular_arr[i].len(){
      rectangular_arr[i][j] = (i * rectangular_arr[i].len() + j) as i32;
    }
  }
  
  /*
  let ragged_arr = [ [1], [1,2], [1,2,3] ];
  ^^^^^ expected an array with a fixed size of 1 elements, found one with 2 elements
  */
  
  println!("{:?}", rectangular_arr);

  
  println!("-6-");

  let subs_arr = [[[[[0]]]]];
  println!("{:?}", subs_arr[0][0][0][0][0]);

  println!("-7-");

  let arr: [[i32;2]; 2] = [[1,2],[2,3]];
  /* 
    let arr_diff = [ "hi", 123];
    = note: expected type `&str`
      found type `{integer}`
  */
  println!( "{:?}", arr);

  println!("-8-");

  let slice_arr = [0,1,2,3,4,5,6];
  println!("{:?}", &slice_arr[2..5]);
  
  println!("-9-");

  let arr_1 = [0,1,2];
  let arr_2 = [0,1,2];

  /*
  println!("{:?}", arr_1 + arr_2);  
  println!("{:?}", arr_1 * arr_2);
  */

  if arr_1 == arr_2{
    println!( "arr_1 is equal to arr_2"); // this call is executed
  }
  
  println!("-10-");
}
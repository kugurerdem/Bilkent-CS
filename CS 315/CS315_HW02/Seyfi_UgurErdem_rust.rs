fn main() {

  println!("-1-");
  // here our counter variable i is just a number
  for i in 1..10{
    println!( "{}", i );
  }

  // here our counter variables are of types string and number
  let strings = ["hi", "ugur", "TA"];
  for (index, string) in strings.iter().enumerate(){
    println!("At index : {} string :  {} is found! ", index, string);
  }

  println!("-2-");
  // 2. What are the scopes of loop control variables?
  for i in 1..10{
    // do nothing
  }
  // println!("{}", i); -> not found in this scope

  println!("-3-");
  for i in 1..10{
    // i = i + 2; we get an array here
    println!( "{}", i );
  }
  
  println!("-4-");
  

}
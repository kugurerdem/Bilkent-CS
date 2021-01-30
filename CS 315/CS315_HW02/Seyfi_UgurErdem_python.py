# 1. What are the types of loop control variables?
print("-1-")
for i in range(1, 10):
  print( i)

for element in ["asd", "a", 1]:
  print(element)

# 2. What are the scopes of loop control variables?
print("-2-")
i = 1
j = 2
for i in range(10): 
  for j in range(10):
    print( str(i) + " , " + str(j) )

print("i's final state is " + str(i) ) # gives 9
print("j's final state is " + str(j) ) # gives 9



# 3. Is it legal for the loop control variable or loop parameters to be changed in the loop, and if so, does the change affect loop control?
print("-3-")
i = 2
for i in range(1, 10):
  i = i + 2
  print( i) # prints 1 to 11


# 4. Are the loop parameters evaluated only once, or once for every iteration?
print("-4-")
end = 5
for i in range( end):
  end = end + 1
  print( i)

print("i is iterated " + str(i+1) + " times although end's final value is : " + str(end))

test_arr = [1,1,1]
for i in range( len(test_arr)):
  test_arr.append( i)

print( test_arr) # [1, 1, 1, 0, 1, 2]
  
# 1
'''
arr = []
arr["deneme"] = 1
arr[true] = 2
'''
# this code results with TypeError 

# 2 

print("-2-")
arr = [1,2,3]
arr[-3] = 5;
arr[2] = 1;

print( arr) # [5,2,1]

# 4. When does allocation take place?
print("-4-")

# referencing
arr = [1, 2, 3, [5,5]] # allocates memory space
arr_2 = arr # does not allocate memory space
arr_2[1] = 77
print( arr) # [1,77,3, [5,5]] 

# cloning
arr_3 = []
for i in range(0, len(arr)):
  arr_3.append( arr[i]) # arr_3 might allocate a new memory place as it is appended like ArrayLists in Java

print("before change\n arr is: " + str(arr) )
print(" arr_3 is: " + str(arr_3) )

arr[2] = 11
arr[3][1] = 1
print("after change\n arr is: " + str(arr) + "\n arr_3 is: " + str(arr_3)) 

# 5. Are ragged or rectangular multidimensional arrays allowed, or both?
print( "-5-")

print("ragged")
ragged_arr = [ [1,2,3], [1,2], [1]]
for i in range(0, len(ragged_arr)):
  print( ragged_arr[i])

print("rectangular")
rectangular_arr = [ [1,2,3], [4,5,6] ]
for i in range(0, len(rectangular_arr) ):
  print( rectangular_arr[i] )

# 6. What is the maximum number of subscripts?

print("-6-")
arr = [[[[[0]]]]]
print( arr[0][0][0][0][0])

# 7. Can array objects be initialized?

print("-7-")
arr = ["mehmet", 132, 7.3]
print(arr)

# 8. Are any kind of slices supported?
print("-8-")
arr = [0,1,2,3,4,5,6,7]
print( arr[1:4] ) # [1, 2, 3]
print( arr[::-1]) # [7, 6, 5, 4, 3, 2, 1, 0]
print( arr[::-2]) # [7, 5, 3, 1]

# 9. Which operators are provided
print("-9-")
arr_1 = [0,1,2,3,4]
arr_2 = [0,1,3]

# print( arr_1 * arr_2) -> error
print( arr_1 + arr_2) # [0, 1, 2, 3, 4, 0, 1, 3]
print( arr_1 * 2)
# print( arr_1 + "asd") -> error
# print( arr_1 + 5) -> error
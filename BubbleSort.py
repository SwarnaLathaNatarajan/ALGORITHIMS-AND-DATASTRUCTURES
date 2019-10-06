arr=[7,6,5,4,3,2,1]
for i in range(len(arr)):
    for j in range(len(arr)-i-1):
        if arr[j]>arr[j+1]:
            arr[j],arr[j+1]=arr[j+1],arr[j]
print(arr)
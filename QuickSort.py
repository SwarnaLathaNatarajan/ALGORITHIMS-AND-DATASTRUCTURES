def quicksort(arr,low,high):
    if low<high:
        p=partition(arr,low,high)
        quicksort(arr,low,p-1)
        quicksort(arr,p+1,high)
def partition(arr,low,high):
    i=low-1 #smaller element
    pivot=arr[high]
    for j in range(low,high):
        if arr[j]<=pivot:
            i=i+1
            arr[i],arr[j]=arr[j],arr[i]
    arr[i+1],arr[high]=arr[high],arr[i+1]
    return i+1
arr = [10, 7, 8, 9, 1, 5]
n = len(arr)
quicksort(arr,0,n-1)
print ("Sorted array is:")
for i in range(n):
    print ("%d" %arr[i]),
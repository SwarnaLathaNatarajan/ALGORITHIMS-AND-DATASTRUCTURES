def mergesort(a):
    if len(a)>1:
        low=0
        high=len(a)
        mid=(low+high)//2
        L=a[low:mid]
        R=a[mid:high]
        mergesort(L)
        mergesort(R)
        i=j=k=0
        while i<len(L) and j<len(R):
            if L[i]<R[j]:
                a[k] = L[i]
                i = i+1
                k = k+1
            else:
                a[k] = R[j]
                j = j + 1
                k = k + 1
        #if any leftover elements R and L
        while i<len(L):
            a[k]=L[i]
            i=i+1
            k=k+1
        while j<len(R):
            a[k]=R[j]
            j=j+1
            k=k+1

a = [7, 6, 5, 4, 3, 2, 1]
mergesort(a)
print a

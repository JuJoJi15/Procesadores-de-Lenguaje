int i;
int j;
int k;
int x;
for (i=1; i<10; ) {
    k=2;
    i=i+1;
    for( ;j<=k; ) {
        k = k*i;
        x = x+i;
        j = j+1;
    }    
}    
print(x);

int i;
int j;
int k;
int x;
for ( ; i<10; i=i+1) {
    k=2;
    for( ; j<k; j=j+i) {
        k = k*i;
        x = x+i;
		print(x);
    }    
}    
print(x);

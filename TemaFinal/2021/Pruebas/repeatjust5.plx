int n;
n=5;
int i;
int z;
repeat just (n) {
   print(n);
   i = i+1;
   repeat just (n-i) {
       repeat (i) z = z+i; 
       n=n-1;
   }
}
print(z);


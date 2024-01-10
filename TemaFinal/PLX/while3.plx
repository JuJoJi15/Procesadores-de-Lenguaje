int a;
int b;
int c;
int suma;
while ( a < 10 ) {
  a = a+1;
  while ( b < 10) {
     b = b+2;
     suma = suma+a+b+c;
  }
  c = 15;
  while (c<10) c=c+1;
}
print(suma);        

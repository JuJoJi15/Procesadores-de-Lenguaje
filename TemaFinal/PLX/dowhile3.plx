int a;
int b;
int c;
int suma;
do {
  a = a+1;
  do {
     b = b+2;
     suma = suma+a+b+c;
  } while ( b < 10);
  c = 15;
  do c=c+1; while (c<10);
} while ( a < 10 );
print(suma);        

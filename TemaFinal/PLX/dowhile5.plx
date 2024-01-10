int a;
int b;
int c;
int suma;
do
    a = a+1;
while (a < 10 );
b = b+2;
do {
     b = b+1;
     do {
         a = a+1;
         c = c+3;
         suma = suma+a+b+c;
     } while (c < 10);
} while (b < 10); 
print(suma);        

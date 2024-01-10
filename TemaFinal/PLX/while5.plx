int a;
int b;
int c;
int suma;
while (a < 10 )
    a = a+1;
    b = b+2;
    while (b < 10) {
        b = b+1;
        while (c < 10) {
            a = a+1;
            c = c+3;
            suma = suma+a+b+c;
        }
    }
print(suma);        

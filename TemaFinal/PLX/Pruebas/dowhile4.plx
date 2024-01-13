int a;
int b;
int c;
int suma;
do {
    do
        do {
            suma = suma+a;
    		a = a+1;
     		print(a+b);
    	} while (a < 10); 
    while (a < 10) ;
    b = b+2;
    suma = suma+b;
    c = a;
} while (b < 10 );
print(suma);        

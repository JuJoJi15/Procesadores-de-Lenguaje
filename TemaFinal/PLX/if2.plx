int a;
int b;
int c;
a=1;
b=2;
c=3;
if ( a == 0 ) {
    a = -1;
    if (a <= b) {
        if (c >= a*b) 
            print (c);
    	b = -1;
    }
    c = -1;
}
print(a*b*c);

int a,b,c;
a = 6;
b = 12;
c = 18;
if ( 1<=a && a<=5 || (b=a) > 10 || ! b == a ) {
a=b;
}
if ( a==b || b==c ) print(1);
if ( !a==b || b==c ) print(2);
if ( a==b || !b==c ) print(3);
if ( !a==b || !b==c ) print(4);
if ( a==b && b==c ) print(5);
if ( !a==b && b==c ) print(6);
if ( a==b && !b==c ) print(7);
if ( !a==b && !b==c ) print(8);
print(a*b);
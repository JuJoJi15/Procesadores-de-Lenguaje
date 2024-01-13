int a;
int b;
int c;
a = 1;
b = 2;
c = 3;
if (a < b) print(1);
if (a <= b) print(2);
if (b > a) print(3);
if (b >= b) print(4);
if (b == b) print(5);
if (a != b) print(6);
if ( a <= c ) {
     if ( a == b ) 
         print (a*b*c);
     if (b == c) {
          print(b*c);
          if (b != c) a=2;
          c=7;    
          if (a<=b) if (b<c) if(c != b) b=5;
     }
     a=6;
}
print(a+b+c+a*b*c); 

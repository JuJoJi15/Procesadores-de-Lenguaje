int a;
int b;
int c;
int d;
int x;
x=1;
if ( a != b ) {
     x = x+2;
     if ( b == c ) 
         x = x+3;
     if  ( a != b) 
         x = x-3;
     else
         x = x+8;          
} else if ( a == c ) {
     if ( c != d )
           x = x+4;
     else {  
           x = x+4;
           if ( a == c )
              x = x+5;
           else
              if (b == c)
                   x = x+6; 
              else
                   x = x+7;       
     }
}
print (x);
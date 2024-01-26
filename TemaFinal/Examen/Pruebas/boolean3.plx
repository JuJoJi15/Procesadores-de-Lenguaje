boolean p;
boolean q;
int x; 
int y;

x=12;
y=15;

p = x<15 && y<20; 
q = x<15 && y<15;

if (p && q)  
   print(1);
if (p || q)  
   print(2);
if (p && !q)  
   print(3);
if (!p || q)  
   print(4);
 
print(5); 

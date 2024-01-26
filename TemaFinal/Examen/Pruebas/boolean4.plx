boolean p;
boolean q;
int x; 
int y;
int z;

x=12;
y=15;
z=20;

p = x<15 && y<20 || z<20; 
q = x<15 && y<15 || z<25;

if (p && q)  
   print(1);
if (p || q)  
   print(2);
if (p && !q)  
   print(3);
if (!p || q)  
   print(4);
 
print(5); 

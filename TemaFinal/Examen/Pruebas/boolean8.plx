int x;
x=1; 
boolean bx,by;
bx = by = x == 0; 
if(!bx) {
   print(1); 
   if(bx = by = x == 1) { 
      print(2);
   }
   if (by) {
     print(3);
   }
}
print(x);

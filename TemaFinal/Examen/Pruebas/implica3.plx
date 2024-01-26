boolean p,q;
if (p --> q --> q) {
   print(1);
   p = true;
   if (p --> q --> q) {
      print(2);
   }
}
print(0);

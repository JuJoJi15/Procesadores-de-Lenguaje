boolean p;
int i;
while (i<10 && forall p, (p || i/5 < 1) ) {
   print(i);
   i = i+1;
}
while (forall p, !p --> !p  && i>0) {
   print(i);
   i = i-1;
}
print(0); 

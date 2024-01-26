boolean p,q;
if (forall p , forall q, p --> q --> p) 
   print(1);
if (forall p , forall q, p --> p --> q) 
   print(2);
if (forall q , forall p, !(p --> p) --> q) 
   print(3);
print(4);


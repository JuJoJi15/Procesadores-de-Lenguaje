boolean p,q;
if (forall p, forall q, p && q --> p || q ) 
   print(1);
if (forall p, forall q, p && q --> p || q && forall p, p||!p )
   print(2);
if (forall p, forall q, p || q --> p && q )
   print(3);
print(0);


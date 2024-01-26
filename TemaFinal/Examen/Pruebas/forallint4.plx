int x,y;
x=0; y=10;
if (x<y && forall x from 1 to 10, x <= y) {
   print(1);
}
print(x); print(y);
if (x<y && forall x from 1 to 9, x <= y) {
   print(2);
}
print(0);


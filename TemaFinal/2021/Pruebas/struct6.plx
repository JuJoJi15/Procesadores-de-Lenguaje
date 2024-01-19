struct {
   struct { int a,b; int c,d,e,f; int g; } p;
   int x,y,z;
} alfa,beta;
alfa.x = 5;
alfa.y = 4;
alfa.z = 3;
beta.x = 2;
beta.p.e = 1;
beta.z = 6;
print(alfa.x+2*beta.p.e+3*alfa.z);


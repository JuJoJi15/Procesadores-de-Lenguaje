struct {
   int a;
   int b;
   int c;
} p;
struct {
   int a;
   int b;
   int z;
} q;
p.a = 7;
p.b = 2;
p.c = 9;
q = p;
print(q.a - 2*q.b + 3*q.z);

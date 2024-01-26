struct {
   int a;
   int b;
} p;
struct {
   int a;
   int b;
} q;
p.a = 7;
p.b = 2;
q = p;
print(q.a-2*q.b);

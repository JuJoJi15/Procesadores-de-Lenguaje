struct {
   int a;
   struct {
      int b;
      int c;
   } q;
} p;
p.a = 1;
p.q.b = 2;
p.q.c = 3;
print(p.a);
print(p.q.b);
print(p.q.c);


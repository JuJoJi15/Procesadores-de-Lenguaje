struct {
   struct {
     int a;
     int b;
   } y;
   struct {
     int c;
     int d;
   } z;
} p;
struct {
   int a;
   int b;
} x;
x.a = 2;
x.b = 3;
p.y = x;
p.z = x;
p.y.a = p.y.a+2;
p.y.b = p.y.b+2;
x = p.y;
print(p.z.c);
print(p.z.d);
print(x.a);
print(x.b);


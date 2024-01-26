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
print(p.y.a);
print(p.y.b);
print(p.z.c);
print(p.z.d);

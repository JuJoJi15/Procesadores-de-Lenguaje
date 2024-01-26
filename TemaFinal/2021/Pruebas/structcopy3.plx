struct {
   int a;
   struct {
     struct { int b; } x;
   } y;
   struct {
     int c;
     int d;
   } z;
} p;
struct {
   int a;
   struct {
     struct { int bb; } xx;
   } yy ;
   struct {
     int c;
     int d;
   } zz;
} q;
p.a =2;
p.y.x.b = 3;
p.z.c = 4;
p.z.d = 5;
q=p;
print(q.a);
print(q.yy.xx.bb);
print(q.zz.c);
print(q.zz.d);

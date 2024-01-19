struct {
   struct {int x;} a;
   struct {int y;} b;
   int a;
} alfa;
alfa.a.x = 3;
alfa.b.y = 4;
print(alfa.a.x+2*alfa.b.y);


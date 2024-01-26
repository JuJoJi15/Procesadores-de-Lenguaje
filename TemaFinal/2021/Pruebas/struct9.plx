struct {
   struct {int x;} a;
   struct {int y;} b;
   int c;
} alfa;
alfa.a.x = 3;
alfa.a.y = 4;
print(alfa.a.x+2*alfa.b.y);


struct {
   struct {int x;} x;
   struct {int y;} y;
   int z;
} alfa;
alfa.x.x = 3;
alfa.y.y = 4;
print(alfa.x.x+2*alfa.y.y);


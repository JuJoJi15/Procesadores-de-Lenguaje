struct {
   struct {
      int n2;
      struct {
        int n1;
        int n2;
      } omega;
   } q;
   char ch;
   int n1;
} p;
p.n1 = 3;
p.q.omega.n1 = p.n1;
p.q.omega.n2 = 
      p.q.omega.n1 / p.n1;
p.ch = 'R';
print(p.ch);
print(2*p.q.omega.n2);
p.ch = 'D';
print(p.ch);
print(2*p.n1-4);


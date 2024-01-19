int i;
int z;
i=10;
repeat just (i) {
  for(i=10; i>0; i--) z++;
}
print(z);
for(i=10; i>0; i--) {
  repeat just (i) z++;
}
print(z);


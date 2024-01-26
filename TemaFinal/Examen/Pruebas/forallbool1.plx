boolean p,q;
if (forall p, p || (!q && !p) ) {
    print(1);
}
if (forall p, p || (!q && p) ) {
    print(2);
}
print(0);

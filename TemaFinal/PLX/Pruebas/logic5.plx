int a = 2;
int b = 3;
int c = 4;
if ( a<(b=a) || !b<(c=b=a) ) {
a = 3;
print(1);
}
if (a<b || !b<c && c<a || a>c && c<b && a>b) {
a = 4;
print(2);
}
print(a*b*c);
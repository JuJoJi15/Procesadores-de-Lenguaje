boolean si;
boolean no;
si = no = true;
if (si && no) {
    print(1);
    if (si || no) {
      print(2);
    }
}
print(3);

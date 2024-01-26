int i;
int j;
int z;
i=1;
j=1;
for(i=1; i<10; i++) 
  repeat (i) 
     while(j<10) 
        repeat ((i+j)/j) 
            z = z + i + j++;
print(z);

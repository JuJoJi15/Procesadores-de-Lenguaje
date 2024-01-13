char st[6];
float mat[6];
int i;
float prod = 1.0;
for(i=0; i<st.length; i=i+1) {
    st[i] = (char)(i+63);  
    mat[i] = (int) st[i];
    prod = prod * mat[i];
}
print(prod);

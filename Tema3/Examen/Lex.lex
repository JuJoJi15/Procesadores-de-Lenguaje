
%%

%{
	public final static int EOF=-1;
	public final static int NUMERO =1;         
	public final static int COMA=2;
	public final static int AC=3; // Abre corchete
	public final static int CC=4; // Cierra corchete
	public final static int AP=5; // Abre parentesis
	public final static int CP=6; // Cierra parentesis
	public final static int NELEM = 100;         
	public final static int MAXDEPTH = 101;         
	public final static int MAXLENGTH = 102;         
%}

%int

%%
nElem                     { return NELEM; }
maxDepth				  { return MAXDEPTH; }
maxLength			      { return MAXLENGTH; }
0|[1-9][0-9]*		      { return NUMERO; }
\[                        { return AC; }
\]                        { return CC; }
\(                        { return AP; }
\)                        { return CP; }
\,                        { return COMA; }
\/\/.*                    {}
[^]                       {}


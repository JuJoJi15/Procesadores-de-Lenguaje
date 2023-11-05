
%%

%int

%%
0|[1-9][0-9]*		      		{ return Token.NUM; }
\(                        { return Token.AP; }
\)                        { return Token.CP; }
\+                        { return Token.MAS; }
[^]                       {}


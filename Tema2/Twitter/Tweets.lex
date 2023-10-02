

%%

%int



hashtags = \#[a-zA-Z0-9]+

mencion = @[a-zA-Z0-9_]*[a-zA-Z][a-zA-Z0-9_]*

enlace = (http:\/\/|https:\/\/)(www.)?[a-zA-Z0-9]+[a-zA-Z0-9_ .\/]*


%%


{hashtags}      {Tweets.hashtags++;Tweets.longitud += yytext().length();TablaHashtags.put(yytext());}

{mencion}       {Tweets.citas++;Tweets.longitud += yytext().length();}

{enlace}       {Tweets.enlaces++;Tweets.longitud += yytext().length();}

[^]         {Tweets.longitud += yytext().length();}


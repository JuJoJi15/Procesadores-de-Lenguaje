

%%

%int

imagen = .jpg|.jpeg|.png|.svg|.gif|.JPG|.JPEG|.PNG|.SVG|.GIF

audio = .ogg|.OGG 

video = .ogv|.OGV



%%


.+{imagen}      {WikiCrawler.nImg++;WikiCrawler.enlacesImagenes.add(yytext());}

autoplay       {WikiCrawler.nAudio++;}

.+{video}       {WikiCrawler.nVideo++;WikiCrawler.enlacesImagenes.add(yytext());}

[^]     {}



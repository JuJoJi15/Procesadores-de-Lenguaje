import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

class Parser {

public final static int EOF = Yylex.EOF;
public final static int NUMERO = Yylex.NUMERO ;         
public final static int COMA = Yylex.COMA;
public final static int AC = Yylex.AC; // Abre corchete
public final static int CC = Yylex.CC; // Cierra corchete
public final static int AP = Yylex.AP; // Abre parentesis
public final static int CP = Yylex.CP; // Cierra parentesis
public final static int NELEM = Yylex.NELEM;         
public final static int MAXDEPTH = Yylex.MAXDEPTH;         
public final static int MAXLENGTH = Yylex.MAXLENGTH;         
	
private static int token;
private static Yylex lex;
private static int nElem;
private static int depth;
private static int maxDepth;
private static List<Integer> antiguo;
private static int length;
private static int maxLength;
private static int yylex() {
	int token = 0;
	try {
		token = lex.yylex();
	} catch (IOException e) {
		System.out.println("ERROR");
		System.exit(0);
	}
	return token;
}

    private static void aumentarDepth(){
        depth++;
        if(depth>maxDepth){
            maxDepth = depth;
        }
    }
    private static void aumentarLength(){
        length++;
        if(length>maxLength){
            maxLength = length;
        }
    }
    private static void avanzar(int t) throws IOException  {
        if (token == t) {
            token = lex.yylex();
            if(token == AC){
                aumentarDepth();
                antiguo.add(length);
                length = 0;
            }else if(token == CC){
                depth--;
                if(!antiguo.isEmpty()){
                    length = antiguo.remove(antiguo.size()-1);
                }
            }else if(token == COMA){
                if(length == 0){
                    aumentarLength();
                }
                aumentarLength();
                
            }
        } else {
            System.out.println("ERROR ");
            System.exit(0);
        }
    }


public static void main(String[] arg)  throws IOException {
    if (arg.length>0) {
        try {
            lex = new Yylex(new FileReader(arg[0]));
            token = yylex();
            antiguo = new ArrayList<>();
            if(token == NELEM){
                S2();
                System.out.println("NELEM="+nElem);
            }else if(token == MAXDEPTH){   
                S3();
                System.out.println("MAXDEPTH="+maxDepth);

            }else if(token == MAXLENGTH){
                S4();
                System.out.println("MAXLENGTH="+maxLength);
            }else{
                S();
                System.out.println("CORRECTO");
            }
        } catch (IOException e) {
        } 
    }
}

private static void S2() throws IOException{
    switch(token){
        case NELEM:
            avanzar(NELEM);
            avanzar(AP);
            avanzar(AC);
            A();
            avanzar(CC);
            avanzar(CP);
            avanzar(EOF);   
            break;
        default:
            System.out.println("ERROR");
            System.exit(0);
    }
}

private static void S3() throws IOException{
    switch (token) {
        case MAXDEPTH:
            avanzar(MAXDEPTH);
            avanzar(AP);
            avanzar(AC);
            A();
            avanzar(CC);
            avanzar(CP);
            avanzar(EOF);   
            break;
        default:
            System.out.println("ERROR");
            System.exit(0);
    }
}

private static void S4() throws IOException{
    switch (token) {
        case MAXLENGTH:
            avanzar(MAXLENGTH);
            avanzar(AP);
            avanzar(AC);
            A();
            avanzar(CC);
            avanzar(CP);
            avanzar(EOF);   
            break;
        default:
            System.out.println("ERROR");
            System.exit(0);
    }
}

private static void S()  throws IOException{
    switch(token){
        case AC:
            avanzar(AC);
            A();
            avanzar(CC);
            avanzar(EOF);
            
            break;
        default:
            System.out.println("ERROR");
            System.exit(0);
    }
}

private static void A()  throws IOException {
    if(length == 0 && token != CC){
        aumentarLength();
    }
    switch(token){
        case AC:
            avanzar(AC);
            A();
            avanzar(CC);
            B();
            break;
        case CC:
            break;
        case NUMERO:
            nElem++;
            avanzar(NUMERO);
            B();
            break;
        default:
            System.out.println("ERROR");
            System.exit(0);
    }
}

private static void B()  throws IOException {
    switch(token){
        case CC:
            break;
        case COMA:
            avanzar(COMA);
            A();
            break;
        default:
            System.out.println("ERROR");
            System.exit(0);
    }
}

}
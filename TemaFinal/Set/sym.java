
//----------------------------------------------------
// The following code was generated by CUP v0.11b beta 20140226
//----------------------------------------------------

/** CUP generated class containing symbol constants. */
public class sym {
  /* terminals */
  public static final int AC = 18;
  public static final int MULT = 4;
  public static final int CHAR = 39;
  public static final int TIPO = 35;
  public static final int ENTERO = 37;
  public static final int FOR = 33;
  public static final int CP = 15;
  public static final int NOT = 9;
  public static final int AND = 27;
  public static final int IGUAL = 7;
  public static final int IN = 13;
  public static final int OR = 28;
  public static final int ASIGNA = 8;
  public static final int CC = 19;
  public static final int IF = 29;
  public static final int EOF = 0;
  public static final int SIZE = 12;
  public static final int error = 1;
  public static final int COMA = 20;
  public static final int DIF = 10;
  public static final int MENOS = 3;
  public static final int MENOR = 24;
  public static final int IDENT = 36;
  public static final int MENOSUNARIO = 6;
  public static final int CLL = 17;
  public static final int MENIG = 26;
  public static final int MAYOR = 23;
  public static final int ELSE = 30;
  public static final int PUNTO = 21;
  public static final int MAYIG = 25;
  public static final int WHILE = 31;
  public static final int FLOAT = 38;
  public static final int STRING = 40;
  public static final int DIVID = 5;
  public static final int ALL = 16;
  public static final int AP = 14;
  public static final int PRINT = 34;
  public static final int LENGTH = 11;
  public static final int DO = 32;
  public static final int SET = 41;
  public static final int PYC = 22;
  public static final int MAS = 2;
  public static final String[] terminalNames = new String[] {
  "EOF",
  "error",
  "MAS",
  "MENOS",
  "MULT",
  "DIVID",
  "MENOSUNARIO",
  "IGUAL",
  "ASIGNA",
  "NOT",
  "DIF",
  "LENGTH",
  "SIZE",
  "IN",
  "AP",
  "CP",
  "ALL",
  "CLL",
  "AC",
  "CC",
  "COMA",
  "PUNTO",
  "PYC",
  "MAYOR",
  "MENOR",
  "MAYIG",
  "MENIG",
  "AND",
  "OR",
  "IF",
  "ELSE",
  "WHILE",
  "DO",
  "FOR",
  "PRINT",
  "TIPO",
  "IDENT",
  "ENTERO",
  "FLOAT",
  "CHAR",
  "STRING",
  "SET"
  };
public String[] TT;
	public sym(){
		TT = new String[100];
		TT[18]=new String("AC");
		TT[4]=new String("MULT");
		TT[39]=new String("CHAR");
		TT[35]=new String("TIPO");
		TT[37]=new String("ENTERO");
		TT[33]=new String("FOR");
		TT[15]=new String("CP");
		TT[9]=new String("NOT");
		TT[27]=new String("AND");
		TT[7]=new String("IGUAL");
		TT[13]=new String("IN");
		TT[28]=new String("OR");
		TT[8]=new String("ASIGNA");
		TT[19]=new String("CC");
		TT[29]=new String("IF");
		TT[0]=new String("EOF");
		TT[12]=new String("SIZE");
		TT[1]=new String("error");
		TT[20]=new String("COMA");
		TT[10]=new String("DIF");
		TT[3]=new String("MENOS");
		TT[24]=new String("MENOR");
		TT[36]=new String("IDENT");
		TT[6]=new String("MENOSUNARIO");
		TT[17]=new String("CLL");
		TT[26]=new String("MENIG");
		TT[23]=new String("MAYOR");
		TT[30]=new String("ELSE");
		TT[21]=new String("PUNTO");
		TT[25]=new String("MAYIG");
		TT[31]=new String("WHILE");
		TT[38]=new String("FLOAT");
		TT[40]=new String("STRING");
		TT[5]=new String("DIVID");
		TT[16]=new String("ALL");
		TT[14]=new String("AP");
		TT[34]=new String("PRINT");
		TT[11]=new String("LENGTH");
		TT[32]=new String("DO");
		TT[41]=new String("SET");
		TT[22]=new String("PYC");
		TT[2]=new String("MAS");
	}
public String getTT(int i){return TT[i];}
}


package es.uniovi.asw.trivial.parser;
<<<<<<< HEAD
%%
//%debug
//%class Lexico
=======

%%
>>>>>>> master
%byaccj
%unicode
%line
%column
%public

%{
<<<<<<< HEAD
	public String lexeme() {
		return yytext();
	}
	
	private Parser parser;

	public void setParser(Parser parser) {
		this.parser=parser;
	}

	public int line() {
		return yyline + 1;
 	}

	public int column() {
		return yycolumn + 1;
	}
%}

//alfanumerico	= [a-zA-Z0-9]
//puntuacion		= "!"|"?"|"."|","|"'" 
//operado			= "+"|"-"|"*"|"/"|"%"|"("|")"|"_"
//caracter		= {operado}|{puntuacion}|{alfanumerico}
//blancos			= [ \t]
//bancoYSimbolo	= {simbolo}|{blancos}

%%


//Símbolos

::		{ return Parser.DOBLEPUNTO; }

[=#\~,{}]		{ return yytext().charAt(0); }


[a-zA-Z0-9_?!'\*\+\-\%\/,.]+[a-zA-Z0-9_?!'\*\+\-\%\/,. ]*[a-zA-Z0-9_?!'\*\+\-\%\/,.]*					{ return Parser.TEXTO; }

"/*"~"*/"										{/*ignorar comentario*/ }
"//".*\n										{/*ignorar comentario*/ }
[\n\r\t]     									{/*ignorar blanco*/ 	}

.												{ System.err.println("Cadena '" + yytext() +"' no reconocida en "+line()+":"+column()+"."); }
=======
  public String lexeme() {
   return yytext();
  }
  
  private Parser parser;
public void setParser(Parser parser) {
	this.parser=parser;
}

  public int line() {
    return yyline + 1;
  }

  public int column() {
    return yycolumn + 1;
  }
%}

%%

"/*"~"*/"		{ }
"//".*\n		{ }

[\n\r\t]     	{ }

::				{ return Parser.DOBLEPUNTO; }

\{" "*		    { return '{';}
[=#\~,{}]		{ return yytext().charAt(0); }

[a-zA-ZñÑáéíóúÁÉÍÓÚ0-9_¿?¡!\*\+\-\%\/ ,.]+	{ return Parser.TEXTO; }

.				{ System.out.println("Error lexico con "+ yytext()); }
>>>>>>> master




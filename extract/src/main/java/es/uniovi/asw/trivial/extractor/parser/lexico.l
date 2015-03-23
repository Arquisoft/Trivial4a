package es.uniovi.asw.trivial.parser;
%%
//%debug
//%class Lexico
%byaccj
%unicode
%line
%column
%public

%{
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




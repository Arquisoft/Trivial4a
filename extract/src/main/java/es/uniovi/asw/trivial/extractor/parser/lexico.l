package es.uniovi.asw.trivial.extractor.parser;
  @SuppressWarnings("all")
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

%%
//Símbolos
::				{ return Parser.DOBLEPUNTO; }

"$CATEGORY:"[áéíóúÁÉÍÓÚñÑa-zA-Z0-9_?¿¡!'\*\+\-\%\/,.]+					{ return Parser.CATEGORY; }

[=#\~,{}]		{ return yytext().charAt(0); }

[áéíóúÁÉÍÓÚñÑa-zA-Z0-9_?¿¡!'\*\+\-\%\/,.]+[áéíóúÁÉÍÓÚñÑa-zA-Z0-9_?¿¡!'\*\+\-\%\/,. ]*[áéíóúÁÉÍÓÚñÑa-zA-Z0-9_?¿¡!'\*\+\-\%\/,.]*					{ return Parser.TEXTO; }

"/*"~"*/"										{/*ignorar comentario*/ }
"//".*\n										{/*ignorar comentario*/ }
[\n\r\t]     									{/*ignorar blanco*/ 	}

.												{ System.err.println("Cadena '" + yytext() +"' no reconocida en "+line()+":"+column()+"."); }




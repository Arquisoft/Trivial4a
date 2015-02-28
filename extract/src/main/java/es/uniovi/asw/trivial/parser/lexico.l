package es.uniovi.asw.trivial.parser;

%%
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

"/*"~"*/"		{ }
"//".*\n		{ }

[ \n\r\t]     	{ }

::				{ return Parser.DOBLEPUNTO; }

[=#\~{}]		{ return yytext().charAt(0); }

.*				{ return Parser.TEXTO; }


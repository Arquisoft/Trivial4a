package sintactico;

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

  public int line() {
    return yyline + 1;
  }

  public int column() {
    return yycolumn + 1;
  }
%}

%%

"/*"~"*/"	{ }
"//".*\n	{ }

[ \n\r\t]     { }


::			{ return Parser.DOBLEPUNTO; }
[=#\~{}]	{ return yytext().charAt(0); }

.*			{ return Parser.TEXTO; }



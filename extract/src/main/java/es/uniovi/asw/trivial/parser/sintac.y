%{
package es.uniovi.asw.trivial.parser;
import es.uniovi.asw.trivial.pregunta.*;
import java.util.*;

 @SuppressWarnings("all")
%}

%TOKEN TEXTO
%TOKEN DOBLEPUNTO

%%

s
<<<<<<< HEAD
	:	preguntas	{ preguntas = (ArrayList<Pregunta>)$1; }
=======
	:	preguntas	{ preguntas = (ArrayList<JSonable>)$1; }
>>>>>>> master
	;

preguntas
	:	preguntas pregunta						{
<<<<<<< HEAD
													List<Pregunta> preguntas = (List<Pregunta>)$1;
=======
													List<JSonable> preguntas = (List<JSonable>)$1;
>>>>>>> master
													preguntas.add((Pregunta)$2);
													$$ = preguntas;
												}
	|	pregunta								{
<<<<<<< HEAD
													List<Pregunta> preguntas = new ArrayList<Pregunta>();
=======
													List<JSonable> preguntas = new ArrayList<JSonable>();
>>>>>>> master
													preguntas.add((Pregunta)$1);
													$$ = preguntas;
												}
	;
		
pregunta
	:	identificador TEXTO '{' respuestas '}' {
													String identificador = (String)$1;
													String pregunta = (String)$2;
													if(identificador==null)
														identificador=pregunta;
													List<Respuesta> respuestas = (List<Respuesta>)$4;
													List<String> respuestasCorrectas = new ArrayList<String>();	
													List<String> respuestasIncorrectas = new ArrayList<String>();
													for(Respuesta r : respuestas)
														if(r.isCorrecta)
															respuestasCorrectas.add(r.respuesta);
														else
															respuestasIncorrectas.add(r.respuesta);	
<<<<<<< HEAD
													String[] arrayp = new String[0];
													Pregunta preguntas = new Pregunta(identificador,pregunta,categoria, respuestasCorrectas.toArray(arrayp),respuestasIncorrectas.toArray(arrayp));
=======
															
													Pregunta preguntas = new Pregunta(identificador,pregunta,respuestasCorrectas,respuestasIncorrectas);
>>>>>>> master
													$$ = preguntas;	
												}
	;
		
identificador
	:	DOBLEPUNTO TEXTO DOBLEPUNTO	{
										$$ = $2;
									}
	|								{
										$$ = null;
									}
	;
	
respuestas
	:	respuestas respuesta
									{
										List<Respuesta> r1 = (List<Respuesta>)$1;
										r1.add((Respuesta)$2);
										$$ = r1;
									}
	|	respuesta					{
										List<Respuesta> r1 = new ArrayList<Respuesta>();
										r1.add((Respuesta)$1);
										$$ = r1;
									}
	;
		
respuesta
	:	simbolo TEXTO comentario 	{
										String simbolo = (String)$1;
										String texto = (String)$2;
										boolean isCorrecta= simbolo.equals("=");
										Respuesta r1 = new Respuesta(texto,isCorrecta);
										$$ = r1;									
									 }
	;
		
comentario
	:	'#'	TEXTO
	|			
	;
		
simbolo
	:	'='							{
										 $$ = $1; 
									}
	|	'~'							{
										$$ = $1;
									}
	;

%%

private Yylex lex;
<<<<<<< HEAD
private ArrayList<Pregunta> preguntas;
=======
private ArrayList<JSonable> preguntas;
>>>>>>> master
private int token;

public Parser(Yylex lex, boolean debug) {
  this(debug);
  this.lex = lex;
}

<<<<<<< HEAD
public int parse() { return yyparse(); }

private String categoria;

public void setCategoria(String nombre) {
	categoria = nombre;
	
}
=======

public int parse() { return yyparse(); }



>>>>>>> master
// Funciones requeridas por el parser

void yyerror(String s)
{
 System.out.println("Error sintactico en " + lex.line() + ":" + lex.column() + " Token = " + token + " lexema = \"" + lex.lexeme()+"\"");
}

int yylex() {
  try {
	token = lex.yylex();
	yylval = lex.lexeme();
	return token;
  } catch (Exception e) {
    return -1;
  }
}

<<<<<<< HEAD
public ArrayList<Pregunta> getPreguntas() {
	return preguntas;
}

=======
public ArrayList<JSonable> getPreguntas() {
	return preguntas;
}



>>>>>>> master
public Parser(Yylex lexico) {
	this.lex = lexico;
	lex.setParser(this);
}
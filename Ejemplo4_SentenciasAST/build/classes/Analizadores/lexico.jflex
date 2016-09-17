/*----------------------------------------------------------------------------
--------------------- 1ra. Area: Codigo de Usuario
----------------------------------------------------------------------------*/

//-------> Paquete, importaciones
package Analizadores;
import java_cup.runtime.*;

%%
/*----------------------------------------------------------------------------
--------------------- 2da. Area: Opciones y Declaraciones
----------------------------------------------------------------------------*/

%{
    //-------> Codigo de usuario en sintaxis java
%}

//-------> Directivas
%public
%class Lexico
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode

//-------> Expresiones Regulares
numero = [0-9]+


//-------> Estados
%state COMENT_SIMPLE
%state COMENT_MULTI

%%
/*-------------------------------------------------------------------
--------------------- 3ra. y ultima area: Reglas Lexicas
-------------------------------------------------------------------*/

//-------> Comentarios
<YYINITIAL> "/*"                {yybegin(COMENT_MULTI);}
<COMENT_MULTI> "*/"             {yybegin(YYINITIAL);}
<COMENT_MULTI>  .               {/* Omitir como es un comentario :D */}
<COMENT_MULTI> [ \t\r\n\f]      {}

<YYINITIAL> "//"            {yybegin(COMENT_SIMPLE);}
<COMENT_SIMPLE> [^"\n"]     {}
<COMENT_SIMPLE> "\n"        {yybegin(YYINITIAL);}
<COMENT_SIMPLE>  .          {/* Omitir como es un comentario :D */}


//-------> Palabras Reservadas
<YYINITIAL> "start"         {   System.out.println("Reconocido: <<"+yytext()+">>, iniciar");
                                return new Symbol(Simbolos.iniciar, yycolumn, yyline, yytext());}

<YYINITIAL> "end"           {   System.out.println("Reconocido: <<"+yytext()+">>, terminar");
                                return new Symbol(Simbolos.terminar, yycolumn, yyline, yytext());}

<YYINITIAL> "operar"        {   System.out.println("Reconocido: <<"+yytext()+">>, operar");
                                return new Symbol(Simbolos.operar, yycolumn, yyline, yytext());}

<YYINITIAL> "imprimir"      {   System.out.println("Reconocido: <<"+yytext()+">>, imprimir");
                                return new Symbol(Simbolos.imprimir, yycolumn, yyline, yytext());}

<YYINITIAL> "desplegar"     {   System.out.println("Reconocido: <<"+yytext()+">>, desplegar");
                                return new Symbol(Simbolos.desplegar, yycolumn, yyline, yytext());}

<YYINITIAL> "true"          {   System.out.println("Reconocido: <<"+yytext()+">>, true");
                                return new Symbol(Simbolos.rtrue, yycolumn, yyline, yytext());}

<YYINITIAL> "false"         {   System.out.println("Reconocido: <<"+yytext()+">>, false");
                                return new Symbol(Simbolos.rfalse, yycolumn, yyline, yytext());}


//-------> Simbolos
<YYINITIAL> ";"         {   System.out.println("Reconocido: <<"+yytext()+">>, punto_coma");
                            return new Symbol(Simbolos.punto_coma, yycolumn, yyline, yytext());}

<YYINITIAL> "("         {   System.out.println("Reconocido: <<"+yytext()+">>, apar");
                            return new Symbol(Simbolos.apar, yycolumn, yyline, yytext());}

<YYINITIAL> ")"         {   System.out.println("Reconocido: <<"+yytext()+">>, cpar");
                            return new Symbol(Simbolos.cpar, yycolumn, yyline, yytext());}

<YYINITIAL> "+"         {   System.out.println("Reconocido: <<"+yytext()+">>, mas");
                            return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());}

<YYINITIAL> "-"         {   System.out.println("Reconocido: <<"+yytext()+">>, menos");
                            return new Symbol(Simbolos.menos, yycolumn, yyline, yytext());}

<YYINITIAL> "*"         {   System.out.println("Reconocido: <<"+yytext()+">>, por");
                            return new Symbol(Simbolos.por, yycolumn, yyline, yytext());}

<YYINITIAL> "++"        {   System.out.println("Reconocido: <<"+yytext()+">>, aumento");
                            return new Symbol(Simbolos.aumento, yycolumn, yyline, yytext());}

<YYINITIAL> "--"        {   System.out.println("Reconocido: <<"+yytext()+">>, decremento");
                            return new Symbol(Simbolos.decremento, yycolumn, yyline, yytext());}


//-------> Dato
<YYINITIAL> {numero}        {   System.out.println("Reconocido: <<"+yytext()+">>, entero");
                                return new Symbol(Simbolos.numero, yycolumn, yyline, yytext());}

//-------> Espacios
[ \t\r\n\f]                 {/* Espacios en blanco, se ignoran */ }
 
//-------> Errores Lexicos
.                           {   System.out.println("Error Lexico: <<"+yytext()+">> Linea: "+yyline+" ,Columna: "+yycolumn);}


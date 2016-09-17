/*----------------------------------------------------------------------------
--------------------- 1ra. Area: Codigo de Usuario
----------------------------------------------------------------------------*/

//-------> Paquete, importaciones
package Analizadores;

import java_cup.runtime.*;
import java.util.ArrayList;
import Acciones.ErrorT;

%%
/*----------------------------------------------------------------------------
--------------------- 2da. Area: Opciones y Declaraciones
----------------------------------------------------------------------------*/

%{
    public ArrayList<ErrorT> lista_errores;
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


//-------> Simbolos
<YYINITIAL> ";"         {   return new Symbol(Simbolos.punto_coma, yycolumn, yyline, yytext());}
<YYINITIAL> "+"         {   return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());}
<YYINITIAL> "-"         {   return new Symbol(Simbolos.menos, yycolumn, yyline, yytext());}
<YYINITIAL> "*"         {   return new Symbol(Simbolos.por, yycolumn, yyline, yytext());}
<YYINITIAL> "/"         {   return new Symbol(Simbolos.dividir, yycolumn, yyline, yytext());}
<YYINITIAL> "^"         {   return new Symbol(Simbolos.potenciar, yycolumn, yyline, yytext());}
<YYINITIAL> "++"        {   return new Symbol(Simbolos.aumento, yycolumn, yyline, yytext());}
<YYINITIAL> "--"        {   return new Symbol(Simbolos.decremento, yycolumn, yyline, yytext());}
<YYINITIAL> "("         {   return new Symbol(Simbolos.apar, yycolumn, yyline, yytext());}
<YYINITIAL> ")"         {   return new Symbol(Simbolos.cpar, yycolumn, yyline, yytext());}

//-------> Dato
<YYINITIAL> {numero}        {   return new Symbol(Simbolos.numero, yycolumn, yyline, yytext());}

//-------> Espacios
[ \t\r\n\f]                 {/* Espacios en blanco, se ignoran */ }
 
//-------> Errores Lexicos
.                           {   System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");
                                lista_errores.add(new ErrorT(yytext(),yyline,yycolumn,"Error Lexico","Lexema Invalido"));}


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
digito = [0-9]
numero = {digito}+("." {digito}+)?
tstring = "\"" ~"\""
tchar = "'" ~"'"
letra = [a-zA-ZñÑ]
id = {letra}+({letra}|{digito}|"_")*


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
<COMENT_MULTI> .                {}
<COMENT_MULTI> [ \t\r\n\f]      {}

<YYINITIAL> "//"                {yybegin(COMENT_SIMPLE);}
<COMENT_SIMPLE> [^"\n"]         {}
<COMENT_SIMPLE> "\n"            {yybegin(YYINITIAL);}


//-------> Simbolos

<YYINITIAL> "="         {   System.out.println("Reconocido: <<"+yytext()+">>, igual1");
                            return new Symbol(Simbolos.igual1, yycolumn, yyline, yytext());}

<YYINITIAL> ","         {   System.out.println("Reconocido: <<"+yytext()+">>, coma");
                            return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());}

<YYINITIAL> ":"         {   System.out.println("Reconocido: <<"+yytext()+">>, dosp");
                            return new Symbol(Simbolos.dosp, yycolumn, yyline, yytext());}

<YYINITIAL> ";"         {   System.out.println("Reconocido: <<"+yytext()+">>, fin");
                            return new Symbol(Simbolos.fin, yycolumn, yyline, yytext());}

<YYINITIAL> "("         {   System.out.println("Reconocido: <<"+yytext()+">>, apar");
                            return new Symbol(Simbolos.apar, yycolumn, yyline, yytext());}

<YYINITIAL> ")"         {   System.out.println("Reconocido: <<"+yytext()+">>, cpar");
                            return new Symbol(Simbolos.cpar, yycolumn, yyline, yytext());}

<YYINITIAL> "{"         {   System.out.println("Reconocido: <<"+yytext()+">>, alla");
                            return new Symbol(Simbolos.alla, yycolumn, yyline, yytext());}

<YYINITIAL> "}"         {   System.out.println("Reconocido: <<"+yytext()+">>, clla");
                            return new Symbol(Simbolos.clla, yycolumn, yyline, yytext());}

<YYINITIAL> "["         {   System.out.println("Reconocido: <<"+yytext()+">>, acor");
                            return new Symbol(Simbolos.acor, yycolumn, yyline, yytext());}

<YYINITIAL> "]"         {   System.out.println("Reconocido: <<"+yytext()+">>, ccor");
                            return new Symbol(Simbolos.ccor, yycolumn, yyline, yytext());}

//-------> Operadores Relacionales

<YYINITIAL> "=="        {   System.out.println("Reconocido: <<"+yytext()+">>, igual2");
                            return new Symbol(Simbolos.igual2, yycolumn, yyline, yytext());}

<YYINITIAL> "!="        {   System.out.println("Reconocido: <<"+yytext()+">>, diferente");
                            return new Symbol(Simbolos.diferente, yycolumn, yyline, yytext());}

<YYINITIAL> ">"         {   System.out.println("Reconocido: <<"+yytext()+">>, mayor1");
                            return new Symbol(Simbolos.mayor, yycolumn, yyline, yytext());}

<YYINITIAL> "<"         {   System.out.println("Reconocido: <<"+yytext()+">>, menor1");
                            return new Symbol(Simbolos.menor, yycolumn, yyline, yytext());}

<YYINITIAL> ">="|"=>"   {   System.out.println("Reconocido: <<"+yytext()+">>, mayorigual");
                            return new Symbol(Simbolos.mayorigual, yycolumn, yyline, yytext());}

<YYINITIAL> "<="|"=<"   {   System.out.println("Reconocido: <<"+yytext()+">>, menorigual");
                            return new Symbol(Simbolos.menorigual, yycolumn, yyline, yytext());}


//-------> Operadores Aritmeticos

<YYINITIAL> "+"         {   System.out.println("Reconocido: <<"+yytext()+">>, mas");
                            return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());}

<YYINITIAL> "-"         {   System.out.println("Reconocido: <<"+yytext()+">>, menos");
                            return new Symbol(Simbolos.menos, yycolumn, yyline, yytext());}

<YYINITIAL> "*"         {   System.out.println("Reconocido: <<"+yytext()+">>, por");
                            return new Symbol(Simbolos.por, yycolumn, yyline, yytext());}

<YYINITIAL> "/"         {   System.out.println("Reconocido: <<"+yytext()+">>, dividir");
                            return new Symbol(Simbolos.dividir, yycolumn, yyline, yytext());}

<YYINITIAL> "%"         {   System.out.println("Reconocido: <<"+yytext()+">>, modular");
                            return new Symbol(Simbolos.modular, yycolumn, yyline, yytext());}

<YYINITIAL> "^"         {   System.out.println("Reconocido: <<"+yytext()+">>, potenciar");
                            return new Symbol(Simbolos.potenciar, yycolumn, yyline, yytext());}

<YYINITIAL> "++"        {   System.out.println("Reconocido: <<"+yytext()+">>, aumento");
                            return new Symbol(Simbolos.aumento, yycolumn, yyline, yytext());}

<YYINITIAL> "--"        {   System.out.println("Reconocido: <<"+yytext()+">>, decremento");
                            return new Symbol(Simbolos.decremento, yycolumn, yyline, yytext());}


//-------> Reservadas, tipos de datos y del sistema

<YYINITIAL> "void"      {   System.out.println("Reconocido: <<"+yytext()+">>, rvoid");
                            return new Symbol(Simbolos.rvoid, yycolumn, yyline, yytext());}

<YYINITIAL> "int"       {   System.out.println("Reconocido: <<"+yytext()+">>, rint");
                            return new Symbol(Simbolos.rint, yycolumn, yyline, yytext());}

<YYINITIAL> "double"    {   System.out.println("Reconocido: <<"+yytext()+">>, rdouble");
                            return new Symbol(Simbolos.rdouble, yycolumn, yyline, yytext());}

<YYINITIAL> "string"    {   System.out.println("Reconocido: <<"+yytext()+">>, rstring");
                            return new Symbol(Simbolos.rstring, yycolumn, yyline, yytext());}

<YYINITIAL> "char"      {   System.out.println("Reconocido: <<"+yytext()+">>, rchar");
                            return new Symbol(Simbolos.rchar, yycolumn, yyline, yytext());}

<YYINITIAL> "bool"      {   System.out.println("Reconocido: <<"+yytext()+">>, rbool");
                            return new Symbol(Simbolos.rbool, yycolumn, yyline, yytext());}

<YYINITIAL> "stack"         {   System.out.println("Reconocido: <<"+yytext()+">>, rstack");
                                return new Symbol(Simbolos.rstack, yycolumn, yyline, yytext());}

<YYINITIAL> "heap"          {   System.out.println("Reconocido: <<"+yytext()+">>, rheap");
                                return new Symbol(Simbolos.rheap, yycolumn, yyline, yytext());}

<YYINITIAL> "main"          {   System.out.println("Reconocido: <<"+yytext()+">>, rmain");
                                return new Symbol(Simbolos.rmain, yycolumn, yyline, yytext());}

<YYINITIAL> "if"            {   System.out.println("Reconocido: <<"+yytext()+">>, rif");
                                return new Symbol(Simbolos.rif, yycolumn, yyline, yytext());}

<YYINITIAL> "then goto"     {   System.out.println("Reconocido: <<"+yytext()+">>, rgoto");
                                return new Symbol(Simbolos.rgoto, yycolumn, yyline, yytext());}

<YYINITIAL> "goto"          {   System.out.println("Reconocido: <<"+yytext()+">>, rgoto");
                                return new Symbol(Simbolos.rgoto, yycolumn, yyline, yytext());}

<YYINITIAL> "call"          {   System.out.println("Reconocido: <<"+yytext()+">>, rcall");
                                return new Symbol(Simbolos.rcall, yycolumn, yyline, yytext());}

<YYINITIAL> "printf"        {   System.out.println("Reconocido: <<"+yytext()+">>, printf");
                                return new Symbol(Simbolos.printf, yycolumn, yyline, yytext());}

<YYINITIAL> "prints"        {   System.out.println("Reconocido: <<"+yytext()+">>, prints");
                                return new Symbol(Simbolos.prints, yycolumn, yyline, yytext());}

<YYINITIAL> "printi"        {   System.out.println("Reconocido: <<"+yytext()+">>, printi");
                                return new Symbol(Simbolos.printi, yycolumn, yyline, yytext());}

<YYINITIAL> {numero}        {   System.out.println("Reconocido: <<"+yytext()+">>, numero ");
                                return new Symbol(Simbolos.numero, yycolumn, yyline, yytext());}

<YYINITIAL> {tstring}       {   System.out.println("Reconocido: <<"+yytext()+">>, tstring ");
                                return new Symbol(Simbolos.tstring, yycolumn, yyline, yytext());}

<YYINITIAL> {tchar}         {   System.out.println("Reconocido: <<"+yytext()+">>, tchar ");
                                return new Symbol(Simbolos.tchar, yycolumn, yyline, yytext());}

<YYINITIAL> {id}            {   System.out.println("Reconocido: <<"+yytext()+">>, id ");
                                return new Symbol(Simbolos.id, yycolumn, yyline, yytext());}

[ \t\r\n\f]                 {/* ignore white space. */ }
 
.                           {   System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");
                                lista_errores.add(new ErrorT(yytext(),yyline,yycolumn,"Error Lexico","Lexema Invalido"));}

/*----------------------------------------------------------------------------->
                    //Atte.   José Joaquin Cacao Chub
                    //Carné:  2012-12577
                    //Correo: jjcacao2@gmail.com
----------------------------------------------------------------------------->*/
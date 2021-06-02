//@version 1.0
//@author Tomás Sepúlveda Franco
	
public class Valores{
    private int total;
    public int valorPalabras(String palabra){ //Los valores de cada letra se tomaron de la versión en español del juego original de Scrabble
        int[] valor = new int[palabra.length()];
        int total = 0;
        for(int x=0; x<palabra.length(); x++){ //recorre la palabra ingresada y suma el valor de cada una de sus letras
            if(palabra.charAt(x) == 'a' || palabra.charAt(x) == 'e' || palabra.charAt(x) == 'o' || palabra.charAt(x) == 's'
            || palabra.charAt(x) == 'i' || palabra.charAt(x) == 'u' || palabra.charAt(x) == 'n' || palabra.charAt(x) == 'l'
            || palabra.charAt(x) == 'r' || palabra.charAt(x) == 't' || palabra.charAt(x) == 'á' || palabra.charAt(x) == 'é'
            || palabra.charAt(x) == 'í' || palabra.charAt(x) == 'ó' || palabra.charAt(x) == 'ú'){
                total = total+1;
            }else if(palabra.charAt(x) == 'd' || palabra.charAt(x) == 'g' || palabra.charAt(x) == 'c'){
                total = total+2;
            }else if(palabra.charAt(x) == 'm' || palabra.charAt(x) == 'b' || palabra.charAt(x) == 'p'){
                total = total+3;
            }else if(palabra.charAt(x) == 'f' || palabra.charAt(x) == 'h' || palabra.charAt(x) == 'v'
            || palabra.charAt(x) == 'y'){
                total = total+4;
            }else if(palabra.charAt(x) == 'j'){
                total = total+6;
            }else if(palabra.charAt(x) == 'k' || palabra.charAt(x) == 'q' || palabra.charAt(x) == 'w'
            || palabra.charAt(x) == 'x'){
                total = total+8;
            }else if(palabra.charAt(x) == 'z'){
                total = total+10;
            }
            
        }
        return total; //@return el valor total de una palabra según su puntaje
    }
    
} 

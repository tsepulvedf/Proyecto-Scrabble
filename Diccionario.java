//@version 1.0
//@author Tomás Sepúlveda Franco	
import java.util.Map;
import java.util.HashMap;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Diccionario{
   private String letrasMano;
   
   public static Map<Character, Integer> getTotalLetras(String letrasMano){
        Map<Character, Integer> numeroDeUnaMismaLetra = new HashMap<>();
        for(int x = 0; x<letrasMano.length();x++){
            char letraActual = letrasMano.charAt(x);
            int totalLetras = numeroDeUnaMismaLetra.containsKey(letraActual) ? //verifica si dicha letra ya está, en caso de no estar la añade a la lista 
            numeroDeUnaMismaLetra.get(letraActual) : 0;                        // y si esta ya está simplemente suma el número de veces que se encuentra dicha letra
            numeroDeUnaMismaLetra.put(letraActual,totalLetras+1);
        }
        
        return numeroDeUnaMismaLetra; //@return las letras y las veces que una misma letra se repite
   }
    
   public static int indiceAlAzar(int minimo, int maximo){
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1); //escoge valores aleatorios en los array
   }
    
   public static String letrasAleatorias(int numeroLetras){ //genera valores al azar del un string que contiene todas las letras del alfabeto
        String letras = "abcdefghijklmnopqrstuvwxyzáéíóú";
        String letrasMano = "";
        
        for(int y=0; y<numeroLetras;y++){   //se toman letras aleatoriamente
            int indiceLetras = indiceAlAzar(0,letras.length()-1);
            char letraAleatoria = letras.charAt(indiceLetras);
            letrasMano = letrasMano + letraAleatoria;
        }
        return letrasMano;  //@return las letras aleatorias generadas por el método
   }
} 
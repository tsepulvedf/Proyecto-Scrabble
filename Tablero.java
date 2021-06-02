import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class Tablero{
    private char[][] tablero;
    private static HashSet<String> diccionario;
    
    public Tablero(){   //constructor vacío 
        
    }
    
    public void recorrerTablero(){  //crea un nuevo tablero vacío y lo recorre
        this.tablero = new char[15][15];
        for(int x = 0; x<tablero.length;x++){
            for(int y = 0; y<tablero.length;y++){
                this.tablero[x][y] = ' ';
            }
        }
    }
    
    public char [][] getTablero(){  //toma el tablero vacío y le asigna valores a la matriz
        char[][] impresionTablero = new char[15][15];
        for(int y = 0; y<15;y++){
            for(int w = 0; w<15; w++){
                impresionTablero[y][w] = this.tablero[y][w];
            }
        }
        return impresionTablero;
    }
    
    public void recorrerDiccionario() throws FileNotFoundException, IOException{ //toma el lector de la principal y lo modifica para añadir todas las palabras del diccionario al HashSet
        BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\USUARIO\\Scrabble proyecto\\Diccionario.txt"));
        diccionario = new HashSet<String>();
        for (String palabra = lector.readLine(); palabra != null;palabra = lector.readLine()){
            diccionario.add(palabra.toLowerCase());
        }
 
    }
    
    public void ponerPalabra(MoverseTablero moverse){   //Toma un objeto MoverseTablero y pone la palabra desea en el tablero en la dirección y posición desea
            String palabra = MoverseTablero.getPalabra();
            int fila = MoverseTablero.getInicioFila();
            int columna = MoverseTablero.getInicioColumna();
            
            for(int z = 0; z <MoverseTablero.getPalabra().length(); z++){
                if(MoverseTablero.getDireccion() == MoverseTablero.horizontal){ //Si la dirección es "1" la palabra se imprime de manera horizontal
                    this.tablero[fila][columna+z] = palabra.toLowerCase().charAt(z);
                }else if(MoverseTablero.getDireccion() == MoverseTablero.vertical){ //Si la dirección es "2" la palabra se imprime de manera vertical
                    this.tablero[fila+z][columna] = palabra.toLowerCase().charAt(z);
                }
            }
         
    }
    
    public void imprimirTablero(Tablero tablero){   //Imprime el tablero en forma de string 
        char[][] muestraTablero = tablero.getTablero();
        StringBuilder modeloTablero = new StringBuilder();
        modeloTablero.append("    0  1  2  3  4  5  6  7  8  9  10 11 12 13 14\n\n");   //Designa como imprimir los numeros de las columnas
        for(int g = 0;g<15;g++){
            if(g>=10){  //Designa como imprimir los numeros de las filas
                modeloTablero.append(g+ "  ");
            }else{
                modeloTablero.append(" "+g+ "  ");
            }
            for(int h = 0; h<15;h++){   //Define que imprimen los espacios del tablero
                if(muestraTablero[g][h] == ' '){    //En caso de estar vacío el espacio imprimir lo siguiente por defecto
                    modeloTablero.append('_'+"  ");
                }else{  //En caso de haber valores, imprimir dichos valores
                    modeloTablero.append(muestraTablero[g][h]+"  ");
                }
            }
            modeloTablero.append("\n\n"); //Evita la impresión en una sola línea
        }
        System.out.println(modeloTablero.toString());
    }
    
}



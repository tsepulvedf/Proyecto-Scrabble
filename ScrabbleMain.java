    //@version 1.0
    //@author Tomás Sepúlveda Franco        
    import java.util.Scanner;
    import java.io.FileReader;
    import java.io.BufferedReader;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.util.Map;
    import java.util.HashMap;
    
    public class ScrabbleMain extends Diccionario{
        public static void main(String [] args) throws FileNotFoundException, IOException{ //throws elimina errores de ruta del archivo
            Scanner entrada = new Scanner(System.in);
            Diccionario d = new Diccionario();
            Valores v = new Valores();
            String letrasMano = d.letrasAleatorias(12);
            System.out.println("Estas son tus letras: "+ letrasMano);
            System.out.println("Y estas son las posibles palabras del diccionario que puedes hacer con ellas y sus puntajes: ");
            Map<Character, Integer> numeroDeUnaMismaLetra = getTotalLetras(letrasMano);
            
            BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\USUARIO\\Scrabble proyecto\\Diccionario.txt")); //Diccionario del cual se toman las palabras 
                                                                                                                                  // del juego
            for (String palabra = lector.readLine(); palabra != null;palabra = lector.readLine()){ //lector del diccionario txt
                Map <Character, Integer> palabraActual = getTotalLetras(palabra);
                boolean palabraActualPosible = true;
                for(Character letra : palabraActual.keySet()){  //el for se mueve por todas las letras del mapa (palabraActual)
                    int totalLetraActual = palabraActual.get(letra); //comparando letras del mapa (palabraActual) con todas las palabras del diccionario
                    int totalLetras = numeroDeUnaMismaLetra.containsKey(letra) ? //verifica si nuestro mapa (numeroDeUnaMismaLetra) tiene dicha letra en caso de tenerla la agrega al mapa 
                    numeroDeUnaMismaLetra.get(letra) : 0;                       //en caso de no tenerla su valor será 0(nulo)
                    if(totalLetraActual>totalLetras){ //si para formar una palabra se necesitan mas letras de las que se tienen salir del programa
                        palabraActualPosible = false;
                        break;
                    }
                    
                }
                if(palabraActualPosible == true){ //si se tienen las letras necesarias para formar una palabra mostrar todas las palabras posibles con esas letras
                        v.valorPalabras(palabra);
                        System.out.println("Este es el valor esta palabra ↓ (palabra de abajo): "+v.valorPalabras(palabra));
                        System.out.println(palabra);
                }
            }
            
            boolean estado = true; // Estado de confirmación
            int totalP = 0; //Puntaje total del jugador
            while(estado == true){
                System.out.println("Desea formar una palabra: ");
                String confirmacion = entrada.next();
                if(confirmacion.equalsIgnoreCase("no")){    //Si el jugador no tiene palabras para jugar termina el juego
                    estado = false;
                    break;
            }else if(confirmacion.equalsIgnoreCase("si")){ //Si puede formar palabras pasa a ponerla en el tablero
                System.out.println("Ingrese la palabra que quiere formar: ");   //Entradas para formar el objeto de la clase MoverseTablero
                String palabraF = entrada.next();
                System.out.println("Ingrese la dirección de la palabra que quiere formar: (1 para horizontal y 2 para vertical)");
                int direccionF = entrada.nextInt();
                System.out.println("Ingrese el inicio de la columna en dónde quiere formar la palabra: ");
                int inicioCF = entrada.nextInt();
                System.out.println("Ingrese el inicio de la fila en dónde quiere formar la palabra: ");
                int inicioFF = entrada.nextInt();
                MoverseTablero mt = new MoverseTablero(palabraF,direccionF,inicioCF,inicioFF);
                Tablero t = new Tablero();
                
                t.recorrerDiccionario();    //Pasos para la impresión del tablero
                t.recorrerTablero();
                t.ponerPalabra(mt);
                t.imprimirTablero(t);
                totalP = totalP + v.valorPalabras(palabraF);
                System.out.println("Puntaje acumulado del jugador: "+totalP);
                
            }else{//En caso de que el usuario no ingrese correctamente la primera pregunta tendrá que volver a hacerlo
                System.out.println("Error, ingresar si o no");
                System.out.println("Desea formar una palabra: ");
                confirmacion = entrada.next();
            }
                 
       } 
    } 
}  

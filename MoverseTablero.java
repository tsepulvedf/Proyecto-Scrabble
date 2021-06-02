
public class MoverseTablero{
    private static int inicioFila;
    private static int direccion;
    private static int inicioColumna;
    public static final int horizontal = 1;
    public static final int vertical  = 2;
    private static String palabra;
     
    public MoverseTablero(String palabra, int direccion, int inicioColumna, int inicioFila){ //Método constructor
        this.palabra = palabra;
        this.direccion = direccion;
        this.inicioColumna = inicioColumna;
        this.inicioFila = inicioFila;
    }
    
    //Getters
    public static int getInicioFila(){
        return inicioFila;
    }
    
    public static int getInicioColumna(){
        return inicioColumna;
    }
    
    public static int getDireccion(){
        return direccion;
    }
    
    public static String getPalabra(){
        return palabra;
    }
    
}

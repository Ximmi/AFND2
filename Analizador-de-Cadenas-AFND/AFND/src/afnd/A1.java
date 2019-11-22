package afnd;
// AUTÓMATA QUE DETECTA DOS 0'S O DOS 1'S SEGUIDOS
public class A1 {
    String cadena;
    String respuesta;
    int lon, cont;

    
    public A1(String cadena){
        this.cadena=cadena;
        lon=cadena.length();
        if(analizar()){
            inicio();
        }
        else{
            respuesta="Cadena invalida";
        }
    }
    
    void inicio(){
        System.out.println("AFnD iniciado...");
        cont=0;
        A();
    }
    void A(){
        System.out.println("contador: "+ cont + " char= " + cadena.charAt(cont) + " en A");
        if(cont==(lon-1)){
            respuesta="La cadena no pertenece al lenguaje";
            System.out.println("La cadena no pertenece al lenguaje");
        }
        else if(cont<lon-1){
            if(cadena.charAt(cont)=='0'){
                if(cadena.charAt(cont+1)=='0'){
                    cont++;
                    B();
                }
                if(cadena.charAt(cont+1)=='1'){
                    cont++;
                    A();
                }
            }
            if(cadena.charAt(cont)=='1'){
                try{
                    if(cadena.charAt(cont+1)=='1'){
                    cont++;
                    C();
                    }
                    
                    if(cadena.charAt(cont+1)=='0'){
                    cont++;
                    A();
                    }
                }    
                catch(IndexOutOfBoundsException e){
                    System.out.println("Exepción");
                }
            }
            
        }
    }
    
    void B(){
        System.out.println("contador: "+ cont + " char= " + cadena.charAt(cont) + " en B");
        if(cont==lon-1){
            respuesta="La cadena no pertenece al lenguaje (B)";
        }
        else if(cont<lon-1){
            if(cadena.charAt(cont)=='0'){
                cont++;
                D();
            }
            /*if(cadena.charAt(cont)!='0'){
                respuesta="es dudoso que la cadena pertenezca (B)";
                System.out.println("es dudoso que la cadena pertenezca (B)");
            }*/
        }
    }

    void C(){
        System.out.println("contador: "+ cont + " char= " + cadena.charAt(cont) + " en C");
        if(cont==lon-1){
            respuesta="La cadena no pertenece al lenguaje(C)";
        }
        else if(cont<lon-1){
            if(cadena.charAt(cont)=='1'){
                cont++;
                D();
            }
            /*if(cadena.charAt(cont)!='1'){
                respuesta="es dudoso que la cadena pertenezca (C)";
                System.out.println("es dudoso que la cadena pertenezca (C)");
            }*/
        }
    }

    void D(){
        System.out.println("contador: "+ cont + " char= " + cadena.charAt(cont) + " en D ");
        if(cont==lon-1){
            respuesta="La cadena pertenece al lenguaje";
            System.out.println("resp: " + respuesta);
            System.out.println("La cadena pertenece al lenguaje");
        }
        if(cont<lon-1){
            //if(cadena.charAt(cont)=='1' || cadena.charAt(cont)=='0'){
                cont++;
                D();
            //}
        }
    }
    
    boolean analizar(){
        boolean resultado=true;
        int i=0;
        while(resultado && i<lon){
            if(cadena.charAt(i)=='0' || cadena.charAt(i)=='1'){
                i++;
            }
            else{
                resultado=false;
            }
        }
        
        return resultado;
    }
    
    public String getRespuesta() {
        return respuesta;
    }
}

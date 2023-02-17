package Inventario;

import java.util.*;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        ArrayList<Articulo> articulos=new ArrayList<Articulo>();

        byte opcion=0;

        byte opcionmod=0;

        boolean decisión=false;

        String elección=" ";
        


        do{
            do{
            
                opcion=Byte.parseByte(JOptionPane.showInputDialog("¿Que operación deseas realizar? \n1 - Ingresar un articulo \n2 - Eliminar un articulo \n3 - Modificar un articulo \n4 - Consultar un articulo \n5 - Salir"));
    
            }while(opcion<=0 || opcion>=6);
    
            switch(opcion){
    
                case 1:
    
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del articulo");
    
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad"));

                    Articulo a = new Articulo();

                    a.setnombre(nombre);
                    
                    a.setcantidad(cantidad);
                    
                    articulos.add(a);

                    break;
    
                case 2:
    
                    nombre = JOptionPane.showInputDialog("Ingrese el nombre del articulo que deseas eliminar");

                    Iterator<Articulo> it= articulos.iterator();

                    while(it.hasNext()){

                        Articulo b = it.next();
                        
                        if(b.getnombre().equals(nombre)){
                         
                            it.remove();

                        }

                    }

                    break;
            
                case 3:

                    nombre = JOptionPane.showInputDialog("Ingrese el nombre del articulo que deseas modificar");

                    do{

                        opcionmod=Byte.parseByte(JOptionPane.showInputDialog("¿Que operación deseas realizar? \n1 - Reemplazar el articulo \n2 - Modificar la cantidad del articulo  \n3 - Salir"));

                    }while(opcionmod<=0 || opcionmod>=4);

                    if(opcionmod==1){

                        String nuevonombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del articulo");

                        int nuevacantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad"));

                        Iterator<Articulo> it2= articulos.iterator();

                        while(it2.hasNext()){

                            Articulo c= it2.next();
                    
                            if(c.getnombre().equals(nombre)){
                     
                            c.setnombre(nuevonombre);
                            c.setcantidad(nuevacantidad);
                        
                            }

                        }

                    }else if(opcionmod==2){

                        int nuevacantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad"));

                        Iterator<Articulo> it2= articulos.iterator();

                        while(it2.hasNext()){

                            Articulo c= it2.next();
                    
                            if(c.getnombre().equals(nombre)){
                            
                            c.setcantidad(nuevacantidad);
                        
                            }

                        }

                    }
    
    
                    break;
    
                case 4:

                    for(Articulo i:articulos){

                        System.out.println("Articulo: " + i.getnombre() + " -  cantidad " + i.getcantidad());

                    }
    
    
                    break;

                case 5:

                    decisión=true;

                    break;
    
                default:
    
            }
            
            if(decisión==false){
                
                do{

                    elección=JOptionPane.showInputDialog("¿Desea realizar otra operacion? \nY - Si \nN - No");
    
                }while(elección.equalsIgnoreCase("Y")==false && elección.equalsIgnoreCase("N")==false);
    
                if(elección.equalsIgnoreCase("Y")==true){
    
                    decisión=false;
    
                }else if(elección.equalsIgnoreCase("N")==true){
    
                    decisión=true;
                    
                }
            }

        }while(decisión==false);
  
    }
}

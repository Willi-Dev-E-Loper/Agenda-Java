
import java.io.*;
import java.util.ConcurrentModificationException;

public class Main {
    public static void main(String[] args) {
      int checker = 0;
      Contacto uno = new Contacto();

      System.out.println("Bienvenido, agenda creada, seleccione una opcion");
      while(checker==0){

          int option = leer.leerEntero(
                  "1-Dar de alta a un contacto\n" +
                  "2-Consultar un contacto por su nombre\n" +
                  "3-Cantidad de contactos grabados\n" +
                  "4-Mostrar toda la agenda\n" +
                  "5-Borrar un contacto\n" +
                  "6-Modificar un contacto\n" +
                  "7-Importar la agenda\n" +
                  "8-Exportar la agenda\n" +
                  "9-Salir\n");

          switch (option){
              case 1:
                  uno.altaContacto();
                  break;
              case 2:
                  try {
                      uno.consultarContacto(leer.leerTexto("Que contacto deseas modificar?"));

                  }catch (NullPointerException e){
                      System.out.println("Excepcion capturada");
                  }
                  break;
              case 3:
                  try {
                      uno.numeroContactos();
                  }catch (NullPointerException e){
                      System.out.println("Excepcion capturada");
                  }
                  break;
              case 4:
                  try {
                      uno.consultarAgenda();

                  }catch (NullPointerException e){
                      System.out.println("Excepcion capturada");
                  }

                  break;
              case 5:
                  try {
                      uno.borrarContacto(leer.leerTexto("Que contacto deseas borrar?"));
                  }catch (NullPointerException | ConcurrentModificationException  e){
                      System.out.println("Excepcion capturada");
                  }
                  break;
              case 6:
                  try {
                      uno.modificarContacto(leer.leerTexto("Que contacto deseas modificar?"));
                  }catch (NullPointerException e){
                      System.out.println("Excepcion capturada");
                  }
                  break;
              case 7:
                  try {
                      uno.importarAgenda();
                  }catch (IOException e){
                      System.out.println("Excepcion capturada");
                  }
                  break;
              case 8:
                  try {
                      uno.exportarAgenda();
                  }catch (IOException | ClassNotFoundException e){
                      System.out.println("Excepcion capturada");
                      e.printStackTrace();
                  }
                  break;
              case 9:
                  String flag =leer.leerTexto("Ha seleccionado salir, si no ha importado su agenda, perdera los cambios\n" +
                          "¿Salir? si/no");
                  if(flag.equalsIgnoreCase("si")){
                      checker=1;
                  }
                  break;
          }

      }


    }
}
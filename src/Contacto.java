import java.io.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
/*NOTA:
 La clase contiene comentado una primera version en la que los datos introducidos se almaceban directamente en un fichero en formato de texto
 y luego lo cambie para hacer uso de los objetos en los ficheros*/
public class Contacto implements Serializable {
    //Declaracion de variables
    String nombre;
    String numero;
    ArrayList<Contacto> agenda= new ArrayList<>();
    //Constructores
    public Contacto(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }
    public Contacto() {

    }
    //Getters & setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    //Funcion que pregunta al usuario el nombre y el numero de un contacto, crea el objeto y lo introduce en el array
    public void altaContacto() {
        int check = 0;
        while (check == 0){
            String nom = leer.leerTexto("Nombre de el contacto: \n");
            String num = leer.leerTexto("Numero de telefono de el contacto: \n");
            //String path = "src/Contactos.txt";
            //File contacts = new File(path);

            Contacto contacto = new Contacto(nom, num);
            this.agenda.add(contacto);
            System.out.println(agenda.size());
            check = leer.leerEntero("Si quieres añadir mas contactos pulsa 0, de lo contrario introduce cualquier numero");
        }






        //FileWriter writer= new FileWriter(contacts, true);


        //writer.write(nom+"-"+num+"\n");
        //writer.close();

    }

    //Funcion que pide un nombre y recorriendo el array muestra el que hace match con el nombre introducido.
    public void consultarContacto(String n) {
        boolean check = false;
        ArrayList<Contacto> a = this.agenda;
        for (Contacto agenda : a) {
            if(agenda.nombre.equalsIgnoreCase(n)){
                check = true;
                System.out.println(agenda.nombre+"-"+ agenda.getNumero());

            }

        }
        if(!check) {
            System.out.println("Contacto no encontrado");


        }
        //FICHERO CON TEXTO, NO HACER CASO
        /*String path = "src/Contactos.txt";
        File contacts = new File(path);
        FileReader a = new FileReader(contacts);
        BufferedReader reader = new BufferedReader(a);
        String s="";

        while ((s = reader.readLine()) != null){
            String[] es = s.split("-");
            //System.out.println(es[0]);
            if(es[0].equalsIgnoreCase(n)){
                System.out.println(s);

            }
        }


        reader.close();
        a.close();*/
    }
    //Funcion que devuelve la longitud del array
    public  void numeroContactos() {
        System.out.println("Numero de contactos:");
        System.out.println(this.agenda.size());
        /*String path = "src/Contactos.txt";
        File contacts = new File(path);
        FileReader a = new FileReader(contacts);
        BufferedReader reader = new BufferedReader(a);
        String s = "";
        int count = 0;

        while ((s = reader.readLine()) != null){
            count++;
        }
        System.out.println("Total de contactos en la agenda: " + (count-1));
        reader.close();
        a.close();*/
    }
    //Funcion que imprime uno por uno el contenido del array
    public  void consultarAgenda()  {
        ArrayList<Contacto> a = this.agenda;
        System.out.println("LISTA DE CONTACTOS");


        for (Contacto agenda : a) {
            System.out.println(agenda.nombre+"-"+agenda.numero);
        }


        /*String path = "src/Contactos.txt";
        File contacts = new File(path);
        FileReader a = new FileReader(contacts);
        BufferedReader reader = new BufferedReader(a);
        String s="";
        System.out.println("LISTA DE CONTACTOS");
        while ((s = reader.readLine()) != null){
            System.out.println(s);
        }


        reader.close();
        a.close();*/
    }
    //Funcion que hace lo mismo que el consultar contacto pero en lugar de mostrarlo, lo elimina
    public void borrarContacto(String nombre) throws ConcurrentModificationException {
        ArrayList<Contacto> a = this.agenda;
        boolean sd = true;
        for (Contacto agenda : a) {
            if(agenda.nombre.equalsIgnoreCase(nombre)){
                sd = a.remove(agenda);
                System.out.println("Contacto borrado con exito");

            }

        }
        if(!sd){
            System.out.println("Contacto no borrado");
        }
    }
    //Funcion que pide el nombre de el contacto que se desea modificar y le pregunta los nuevos datos a introducirle
    public void modificarContacto(String nombre){
        ArrayList<Contacto> a = this.agenda;
        boolean sd = false;
        for (Contacto agenda : a) {
            if(agenda.nombre.equalsIgnoreCase(nombre)){
                agenda.setNombre(leer.leerTexto("Introduce el nuevo nombre: "));
                agenda.setNumero(leer.leerTexto("Introduce el nuevo numero"));
                sd = true;
            }

        }
        if(!sd){
            System.out.println("El contacto no se ha encontrado");
        }
    }
    //Funcion que pide un nombre de fichero al que deseas importar tu agenda de contactos
    public  void importarAgenda() throws IOException { //Lanzo la excepcion aqui y en el main lo capturo con un bloque try-catch
        String fichero_destino = leer.leerTexto("Indica el nombre de el fichero al que importar tus contactos" +
                "Si no existe se creara");
        FileOutputStream fichero = new FileOutputStream(fichero_destino);
        ObjectOutputStream obj = new ObjectOutputStream(fichero);
        obj.writeObject(this.agenda);
        System.out.println("Agenda importada al fichero con nombre "+ fichero_destino);

    }
    //Funcion que pide un nombre de fichero que se desea exportar, una vez realizado se ppuede trabajar con esa agenda.
    public  void exportarAgenda() throws IOException, ClassNotFoundException {
        String fichero_origen = leer.leerTexto("Indica el nombre de el fichero desde el  que importar tus contactos");
        FileInputStream fichero = new FileInputStream(fichero_origen);
        ObjectInputStream obj = new ObjectInputStream(fichero);
        ArrayList<Contacto> agnd = (ArrayList<Contacto>) obj.readObject();
        this.agenda = agnd;
        if (this.agenda.size()>0){
            System.out.println("Exportado con exito");
        }

    }


}

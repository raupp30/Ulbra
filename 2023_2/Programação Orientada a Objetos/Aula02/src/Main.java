import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // create list
        ArrayList<String> lista = new ArrayList();

        //Create
        Create(lista, "coffe");
        Create(lista, "milk");
        Create(lista, "meat");

        //Read
        System.out.println("Reading: ");
        Read(lista);

        //Update
        System.out.println("Updating ");
        Update(lista, 0, "coFFFe");

        //Read
        System.out.println("Reading after update");
        Read(lista);

        //Delete
        System.out.println("Deleting ");
        Delete(lista, 0);

        //Read
        System.out.println("Reading after delete");
        Read(lista);
    }


    public static void Create(ArrayList<String> lista, String item) {
        lista.add(item);
    }

    public static void Read(ArrayList<String> lista) {
        System.out.println(lista);
    }

    public static void Update(ArrayList<String> lista, int posicion, String item) {
        lista.set(posicion, item);
    }


    public static void Delete(ArrayList<String> lista, int posicion) {
        lista.remove(0);
    }
}


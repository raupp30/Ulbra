import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();

        addItem(myList, "item1");
        addItem(myList, "item2");
        addItem(myList, "item3");

        System.out.println("Lista após add itens" +myList);

        attItem(myList, 1, "Item atualizado");

        System.out.println("Lista após att item" +myList);

        removeItem(myList, 0);

        System.out.println("Lista após remover item" +myList);

        String itemLido = lerItem(myList, 0);

        System.out.println("Item lido" +myList);
    }
    public static void addItem(List<String> lista, String item){
        lista.add(item);
    }

    public static void attItem(List<String> list, int indice, String newItem){
        if(indice >= 0 && indice < list.size()){
            list.set(indice, newItem);
        }else{
            System.out.println("Ìndice inválido");
        }
    }

    public static void removeItem(List<String> list, int indice){
        if (indice >= 0 && indice < list.size()){
            list.remove(indice);
        }else{
            System.out.println("Índice inválido");
        }
    }

    public static String lerItem(List<String> list, int indice){
        if (indice >= 0 && indice < list.size()){
            return list.get(indice);
    }else{
            return "Indice inválido";
        }
}
}
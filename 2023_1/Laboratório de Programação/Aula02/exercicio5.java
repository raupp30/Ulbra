public class exercicio5 {
    public static void main(String[] args) {
        double dia = 31;
        double mes = 04;
        double ano = 2023;

        boolean dataValida = true;

        if (mes < 1 || mes > 12){
            dataValida = false;
        }else if (dia < 1 || dia > 31){
            dataValida = false;
        }else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30){
            dataValida = false;
        }else if (mes == 2) {
            if (dia > 29 || (dia == 29 && !(ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0 )))
            dataValida = false;
        }

        if (dataValida) {
            System.out.println("Data válida");
        } else {
            System.out.println("Data inválida");
        }
    }
}



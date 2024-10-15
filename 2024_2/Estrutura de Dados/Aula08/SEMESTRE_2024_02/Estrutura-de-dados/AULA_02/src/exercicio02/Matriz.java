public class Matriz {
    private int[][] matriz;

    public Matriz(int[][] matriz) {
        if (matriz == null || matriz.length == 0 || matriz[0].length == 0) {
            throw new IllegalArgumentException("Matriz não pode ser nula ou vazia");
        }
        this.matriz = matriz;
    }

    // Obter o maior elemento da matriz
    public int obterMaiorElemento() {
        int maior = matriz[0][0];
        for (int[] linha : matriz) {
            for (int elemento : linha) {
                if (elemento > maior) {
                    maior = elemento;
                }
            }
        }
        return maior;
    }

    // Obter o menor elemento da matriz
    public int obterMenorElemento() {
        int menor = matriz[0][0];
        for (int[] linha : matriz) {
            for (int elemento : linha) {
                if (elemento < menor) {
                    menor = elemento;
                }
            }
        }
        return menor;
    }

    // Calcular a média dos elementos da matriz
    public double calcularMedia() {
        int soma = 0;
        int totalElementos = 0;
        for (int[] linha : matriz) {
            for (int elemento : linha) {
                soma += elemento;
                totalElementos++;
            }
        }
        return (double) soma / totalElementos;
    }

    // Somar elementos por linha
    public int[] somarElementosPorLinha() {
        int[] somaLinhas = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            int soma = 0;
            for (int elemento : matriz[i]) {
                soma += elemento;
            }
            somaLinhas[i] = soma;
        }
        return somaLinhas;
    }

    // Somar elementos por coluna
    public int[] somarElementosPorColuna() {
        int colunas = matriz[0].length;
        int[] somaColunas = new int[colunas];
        for (int i = 0; i < colunas; i++) {
            int soma = 0;
            for (int j = 0; j < matriz.length; j++) {
                soma += matriz[j][i];
            }
            somaColunas[i] = soma;
        }
        return somaColunas;
    }

    // Calcular a soma total dos elementos da matriz
    public int calcularSomaTotal() {
        int soma = 0;
        for (int[] linha : matriz) {
            for (int elemento : linha) {
                soma += elemento;
            }
        }
        return soma;
    }

    // Contar ocorrências de um valor na matriz
    public int contarOcorrencias(int valor) {
        int contador = 0;
        for (int[] linha : matriz) {
            for (int elemento : linha) {
                if (elemento == valor) {
                    contador++;
                }
            }
        }
        return contador;
    }

    // Teste da classe Matriz
    public static void main(String[] args) {
        int[][] dados = {
                {3, 5, 1},
                {7, 2, 8},
                {9, 6, 4}
        };

        Matriz matriz = new Matriz(dados);

        System.out.println("Maior elemento: " + matriz.obterMaiorElemento());
        System.out.println("Menor elemento: " + matriz.obterMenorElemento());
        System.out.println("Média dos elementos: " + matriz.calcularMedia());

        int[] somaLinhas = matriz.somarElementosPorLinha();
        System.out.print("Soma por linha: ");
        for (int soma : somaLinhas) {
            System.out.print(soma + " ");
        }
        System.out.println();

        int[] somaColunas = matriz.somarElementosPorColuna();
        System.out.print("Soma por coluna: ");
        for (int soma : somaColunas) {
            System.out.print(soma + " ");
        }
        System.out.println();

        System.out.println("Soma total dos elementos: " + matriz.calcularSomaTotal());
        System.out.println("Ocorrências do número 2: " + matriz.contarOcorrencias(2));
    }
}


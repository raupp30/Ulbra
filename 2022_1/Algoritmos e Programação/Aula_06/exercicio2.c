#include <stdio.h>
#include <math.h>
#include <string.h>

int main()
{
    {
        float nota1[10];
        float nota2[10];
        float media[10];
        char aluno[10][20];
        float aprovados[10][10];
        float reprovados[10][10];
        int aprov = 0, reprov = 0;
        int cont = 0, op;
        int funcao, posicao;
        int i = 0;
        float compare;

        for (i = 0; i < 10; i++)
        {
            printf("Digite o nome do aluno:\n");
            scanf("%s%*c", &aluno[i]);
            printf("Digite a nota da primeira prova:\n");
            scanf("%f%*c", &nota1[i]);
            printf("Digite a nota da segunda prova:\n");
            scanf("%f%*c", &nota2[i]);
            media[i] = (nota1[i] + nota2[i]) / 2;

            if (media[i] >= 7)
            {
                strcpy(aprovados[aprov], aluno[i]);
                aprov++;
            }
            else
            {
                strcpy(reprovados[reprov], aluno[i]);
                reprov++;
            }

            printf("Deseja adicionar um novo aluno?\n1- SIM\n2- NAO\n");
            scanf("%d%*c", &op);

            if (op != 1)
            {
                break;
            }
            cont++;
        }
        do
        {
            printf("Digite uma das opcoes abaixo:\n1- Listar todos os alunos aprovados\n2 -Listar todos os alunos reprovados\n3- Listar todos os alunos com nota maior que uma nota informada pelo usuario.\n4-Informar uma Posicao e o programa exibir os dados e notas do aluno.\n5- Encerrar o programa.\n");
            scanf("%d%*c", &funcao);
            switch (funcao)
            {
            case 1: // nos trinques
                printf("Alunos aprovados: \n");
                for (i = 0; i < aprov; i++)
                {
                    printf("Aluno %s aprovado \n", aprovados[i]);
                    printf("-------------------------\n");
                }
                break;
            case 2: // nos trinques
                printf("Alunos reprovados: \n");
                for (i = 0; i < reprov; i++)
                {
                    printf("Aluno %s reprovado \n", reprovados[i]);
                    printf("-------------------------\n");
                }
                break;
            case 3: // nos trinques
                printf("Digite a nota de comparacao: \n");
                scanf("%f%*c", &compare);
                for (i = 0; media[i] > compare; i++)
                {
                    printf("O aluno %s tem a media %.2f que e maior que o comparativo.\n", aluno[i], media[i]);
                }
                break;
            case 4: // nos trinques
                printf("Digite a posicao para exibir os dados da mesma: \n");
                scanf("%d%*c", &posicao);
                if (posicao <= cont)
                {
                    printf("O aluno %s com a primeira nota de %.2f com a segunda nota de %.2f e com media de %.2f\n", aluno[posicao], nota1[posicao], nota2[posicao], media[posicao]);
                }
                else
                {
                    printf("Valor invalido!\n");
                }
            default:
                break;
            }

        } while (funcao != 5);
    }

    printf("Encerrando o programa");
}
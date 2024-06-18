public class Fracao {
    double numerador;
    double denominador;

    Fracao multiplicar (Fracao f) {
        //Cria um novo resultado
        Fracao result = new Fracao();

        //Multiplica os numeradores e denominadores das frações
        result.numerador = this.numerador * f.numerador;
        result.denominador = this.denominador * f.denominador;

        //Retorna a nova fração
        return result;
    }

}

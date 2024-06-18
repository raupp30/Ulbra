class Main {
    public static void main(String[] args) {
        Cliente cliente01 = new Cliente("Vinicius", 20);
        Cliente cliente02 = new Cliente("Lauren", 19);

        ContaCorrente conta01 = new ContaCorrente(cliente01);
        ContaCorrente conta02 = new ContaCorrente(cliente02);

        ContaPoupanca conta03 = new ContaPoupanca(cliente01);
        ContaPoupanca conta04 = new ContaPoupanca(cliente02);

        conta01.deposita(920);
        conta02.deposita(1234);

        conta01.consultaSaldo();
        conta02.consultaSaldo();
        conta03.consultaSaldo();
        conta04.consultaSaldo();

        conta01.transfere(conta03, 220);
        conta02.transfere(conta04, 270);

        conta01.consultaSaldo();
        conta02.consultaSaldo();
        conta03.consultaSaldo();
        conta04.consultaSaldo();


    }
}
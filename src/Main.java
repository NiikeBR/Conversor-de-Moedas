import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        double resultado = 0;
        var opcao = "";
        double valorConversao = 0;

        System.out.println("Seja bem vindo(a) ao Conversor de Moeda :D");
        Scanner entrada = new Scanner(System.in);
        System.out.println();

        while (true) {
            System.out.println("""
                    1) Dolar => Real 
                    2) Real => Dolar 
                    3) Dolar => Peso Argentino 
                    4) Peso Argentino => Dolar 
                    5) Dolar => Euro 
                    6) Euro => Dolar
                    7) Sair
                    """);

            opcao = entrada.nextLine();
            Scanner valor = new Scanner(System.in);

            if (opcao.equals("7")) {
                System.out.println("Conversão encerrada!");
                break;
            }

            try {

                switch (opcao) {
                    case "1":
                        System.out.println("Digite o valor para conversão: ");
                        valorConversao = valor.nextDouble();
                        resultado = Conversor.converter("USD", "BRL", valorConversao);
                        System.out.println(valorConversao + " (USD) corresponde ao valor final de " + resultado + " (BRL)");
                        break;

                    case "2":
                        System.out.println("Digite o valor para conversão: ");
                        valorConversao = valor.nextDouble();
                        resultado = Conversor.converter("BRL", "USD", valorConversao);
                        System.out.println(valorConversao + " (BRL) corresponde ao valor final de " + resultado + " (USD)");
                        break;

                    case "3":
                        System.out.println("Digite o valor para conversão: ");
                        valorConversao = valor.nextDouble();
                        resultado = Conversor.converter("USD", "ARS", valorConversao);
                        System.out.println(valorConversao + " (USD) corresponde ao valor final de " + resultado + " (ARS)");
                        break;

                    case "4":
                        System.out.println("Digite o valor para conversão: ");
                        valorConversao = valor.nextDouble();
                        resultado = Conversor.converter("ARS", "USD", valorConversao);
                        System.out.println(valorConversao + " (ARS) corresponde ao valor final de " + resultado + " (USD)");
                        break;

                    case "5":
                        System.out.println("Digite o valor para conversão: ");
                        valorConversao = valor.nextDouble();
                        resultado = Conversor.converter("USD", "EUR", valorConversao);
                        System.out.println(valorConversao + " (USD) corresponde ao valor final de " + resultado + " (EUR)");
                        break;

                    case "6":
                        System.out.println("Digite o valor para conversão: ");
                        valorConversao = valor.nextDouble();
                        resultado = Conversor.converter("EUR", "USD", valorConversao);
                        System.out.println(valorConversao + " (EUR) corresponde ao valor final de " + resultado + " (USD)");
                        break;
                }


            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao realizar conversão: " + e.getMessage());
            }

            System.out.println();
        }
    }
}
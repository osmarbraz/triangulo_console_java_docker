
import java.util.Scanner; // Permite ler dados digitados pelo usuário no teclado.

public class Principal {

    public static void main(String[] args) {

        // Variáveis
        Scanner scanner = new Scanner(System.in);
        double base = 0;
        double altura = 0;
        double area = 0;
        int opcao = 0;

        // Menu
        do {
            System.out.println("\n===== CÁLCULO DE ÁREA DO TRIÂNGULO =====");
            System.out.println("1 - Leitura dos dados");
            System.out.println("2 - Calcular a área");
            System.out.println("9 - Sair");
            System.out.print("Escolha uma opção: ");

            // Entrada
            opcao = scanner.nextInt();

            // Processamento e saída
            switch (opcao) {

                case 1:
                    // Entrada: solicita a base e a altura.
                    System.out.print("Informe a base do triângulo: ");
                    base = scanner.nextDouble();

                    System.out.print("Informe a altura do triângulo: ");
                    altura = scanner.nextDouble();
                    break;

                case 2:
                    // Processamento: verifica se os dados foram informados.
                    area = (base * altura) / 2;

                    // Saída: apresenta o resultado.
                    System.out.println("\nCálculo");
                    System.out.println("Base: " + base);
                    System.out.println("Altura: " + altura);
                    System.out.println("Área do triângulo: " + area);
                    break;

                case 9:
                    // Saída: encerra o programa.
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    // Saída: informa que a opção é inválida.
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 9);

        // Finalização: libera o recurso de entrada.
        scanner.close();
    }
}

import java.util.HashSet; // Importa a classe HashSet usando coleções que não permitem elementos duplicados
import java.util.InputMismatchException; // Importa a exceção capturando os erros de entrada de dados incorretos
import java.util.Scanner; // Importa a classe Scanner para lidar com a entrada do usuário

public class PrincipalFrutas { // Classe principal
    public static void main(String[] args) { // Método de entrada da aplicação
        Scanner scanner = new Scanner(System.in); // Inicializa o Scanner para receber dados do usuário
        HashSet<String> frutas = new HashSet<>(); // Cria um conjunto de frutas, que impede elementos duplicados

        while (true) { // Loop contínuo para o menu de opções
            try {
                // Exibe as opções do menu
                System.out.println("\nEscolha uma ação:");
                System.out.println("1. Inserir uma nova fruta");
                System.out.println("2. Mostrar todas as frutas");
                System.out.println("3. Remover uma fruta");
                System.out.println("4. Consultar se uma fruta está presente");
                System.out.println("5. Encerrar o programa");
                System.out.print("Digite a opção desejada: ");

                int opcao = scanner.nextInt(); // Lê a escolha do usuário
                scanner.nextLine(); // Limpa o buffer para evitar erros de leitura

                switch (opcao) {
                    case 1: // Caso para adicionar uma fruta ao conjunto
                        System.out.print("Digite o nome da fruta que deseja adicionar: ");
                        String novaFruta = scanner.nextLine(); // Recebe o nome da fruta do usuário
                        if (frutas.add(novaFruta)) { // Tenta adicionar a fruta; retorna falso se já existir
                            System.out.println(novaFruta + " foi adicionada com sucesso.");
                        } else {
                            System.out.println(novaFruta + " já existe no conjunto.");
                        }
                        break;

                    case 2: // Caso para listar todas as frutas do conjunto
                        System.out.println("Frutas cadastradas: " + frutas); // Exibe todas as frutas presentes
                        break;

                    case 3: // Caso para remover uma fruta específica
                        System.out.print("Digite o nome da fruta que deseja remover: ");
                        String frutaRemover = scanner.nextLine(); // Recebe o nome da fruta a ser removida
                        if (frutas.remove(frutaRemover)) { // Tenta remover a fruta; retorna falso se não existir
                            System.out.println(frutaRemover + " foi removida com sucesso.");
                        } else {
                            System.out.println(frutaRemover + " não foi encontrada no conjunto.");
                        }
                        break;

                    case 4: // Caso para verificar se uma fruta está presente no conjunto
                        System.out.print("Digite o nome da fruta para verificar: ");
                        String frutaVerificar = scanner.nextLine(); // Recebe o nome da fruta a ser verificada
                        if (frutas.contains(frutaVerificar)) { // Verifica a presença da fruta no conjunto
                            System.out.println(frutaVerificar + " está cadastrada no conjunto.");
                        } else {
                            System.out.println(frutaVerificar + " não foi encontrada.");
                        }
                        break;

                    case 5: // Caso para sair do programa
                        System.out.println("Encerrando o programa...");
                        scanner.close(); // Fecha o Scanner para liberar o recurso
                        return; // Termina a execução do programa

                    default: // Caso de entrada de opção inválida
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) { // Captura erros de tipo incorreto na entrada
                System.out.println("Entrada inválida. Digite um número válido para a opção.");
                scanner.nextLine(); // Limpa a entrada errada para evitar novo erro na próxima leitura
            }
        }
    }
}

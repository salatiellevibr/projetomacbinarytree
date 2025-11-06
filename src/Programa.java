
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        ArvoreTarefas arvore = new ArvoreTarefas();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Buscar tarefa por ID");
            System.out.println("4 - Remover tarefa");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");

            String entrada = sc.nextLine().trim();
            int op;
            try {
                op = Integer.parseInt(entrada);
            } catch (Exception e) {
                System.out.println("Opção inválida.");
                continue;
            }

            switch (op) {
                case 1 -> {
                    try {
                        System.out.print("ID (inteiro): ");
                        int id = Integer.parseInt(sc.nextLine().trim());

                        System.out.print("Título: ");
                        String titulo = sc.nextLine();

                        System.out.print("Descrição: ");
                        String descricao = sc.nextLine();

                        arvore.inserir(new Tarefa(id, titulo, descricao));
                        System.out.println("✅ Tarefa adicionada com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao adicionar tarefa. Tente novamente.");
                    }
                }

                case 2 -> {
                    arvore.listar();
                }

                case 3 -> {
                    System.out.print("ID para buscar: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    Tarefa t = arvore.buscar(id);
                    if (t != null) System.out.println("Encontrada: " + t);
                    else System.out.println("Tarefa não encontrada.");
                }

                case 4 -> {
                    System.out.print("ID para remover: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    arvore.remover(id);
                    System.out.println("Remoção concluída (se o ID existia).");
                }

                case 5 -> {
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                }

                default -> System.out.println("Opção inválida!");
            }
        }
    }
}

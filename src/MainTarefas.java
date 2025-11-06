import entities.Tarefa;
import java.util.List;
import java.util.Scanner;

public class MainTarefas {

    public static int menu(Scanner sc) {
        System.out.println("\n=== SISTEMA DE TAREFAS ===");
        System.out.println("1 - Adicionar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Remover tarefa por prioridade");
        System.out.println("4 - Mostrar estrutura da árvore");
        System.out.println("5 - Sair");
        System.out.print("Escolha: ");
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreTarefas sistema = new ArvoreTarefas();

        sistema.adicionarTarefa("Estudar", "Revisar matéria de ED", 5);
        sistema.adicionarTarefa("Trabalho", "Fazer projeto da árvore", 9);
        sistema.adicionarTarefa("Compras", "Ir no mercado", 3);

        int opcao;
        do {
            opcao = menu(sc);
            switch (opcao) {
                case 1:
                    sc.nextLine();
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Prioridade (1-10): ");
                    int pri = sc.nextInt();
                    sistema.adicionarTarefa(titulo, desc, pri);
                    break;
                case 2:
                    System.out.println("\n=== Tarefas em ordem ===");
                    List<Tarefa> lista = sistema.listarEmOrdem();
                    for (Tarefa t : lista) {
                        System.out.println(t);
                    }
                    break;
                case 3:
                    System.out.print("Prioridade da tarefa a remover: ");
                    int p = sc.nextInt();
                    sistema.removerTarefa(p);
                    break;
                case 4:
                    sistema.mostrarArvore();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        sc.close();
    }
}

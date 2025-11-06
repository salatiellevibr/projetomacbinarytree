public class Node {
    public Tarefa tarefa;
    public Node left;
    public Node right;

    public Node(Tarefa tarefa) {
        this.tarefa = tarefa;
        this.left = null;
        this.right = null;
    }
}

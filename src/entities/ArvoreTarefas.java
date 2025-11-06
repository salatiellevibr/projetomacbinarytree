public class ArvoreTarefas {
    private Node raiz;

    // --- INSERIR ---
    public void inserir(Tarefa t) {
        raiz = inserirRec(raiz, t);
    }

    private Node inserirRec(Node atual, Tarefa t) {
        if (atual == null) return new Node(t);

        if (t.getId() < atual.tarefa.getId()) {
            atual.left = inserirRec(atual.left, t);
        } else if (t.getId() > atual.tarefa.getId()) {
            atual.right = inserirRec(atual.right, t);
        } else {
            System.out.println("ID já existe. Inserção ignorada.");
        }
        return atual;
    }

    // --- LISTAR ---
    public void listar() {
        if (raiz == null) System.out.println("Nenhuma tarefa cadastrada.");
        else listarRec(raiz);
    }

    private void listarRec(Node n) {
        if (n == null) return;
        listarRec(n.left);
        System.out.println(n.tarefa);
        listarRec(n.right);
    }

    // --- BUSCAR ---
    public Tarefa buscar(int id) {
        return buscarRec(raiz, id);
    }

    private Tarefa buscarRec(Node n, int id) {
        if (n == null) return null;
        if (id == n.tarefa.getId()) return n.tarefa;
        if (id < n.tarefa.getId()) return buscarRec(n.left, id);
        return buscarRec(n.right, id);
    }

    // --- REMOVER ---
    public void remover(int id) {
        raiz = removerRec(raiz, id);
    }

    private Node removerRec(Node n, int id) {
        if (n == null) return null;
        if (id < n.tarefa.getId()) {
            n.left = removerRec(n.left, id);
        } else if (id > n.tarefa.getId()) {
            n.right = removerRec(n.right, id);
        } else {
            // achou o nó pra remover
            if (n.left == null && n.right == null) return null; // sem filhos
            if (n.left == null) return n.right; // só direita
            if (n.right == null) return n.left; // só esquerda

            // dois filhos
            Node menor = encontrarMenor(n.right);
            n.tarefa = menor.tarefa;
            n.right = removerRec(n.right, menor.tarefa.getId());
        }
        return n;
    }

    private Node encontrarMenor(Node n) {
        while (n.left != null) n = n.left;
        return n;
    }
}

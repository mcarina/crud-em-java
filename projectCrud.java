import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tarefa {
  private String descricao;

  public Tarefa(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}

public class Main {
  public static void main(String[] args) {
    List<Tarefa> listaDeTarefas = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    while (true) {
      System.out.println("Escolha uma operação:");
      System.out.println("1. Criar tarefa");
      System.out.println("2. Listar tarefas");
      System.out.println("3. Atualizar tarefa");
      System.out.println("4. Excluir tarefa");
      System.out.println("5. Sair");

      int escolha = input.nextInt();
      input.nextLine(); // Limpa o buffer do teclado

      switch (escolha) {
        case 1: // Criar tarefa
          System.out.print("Digite a descrição da tarefa: ");
          String descricao = input.nextLine();
          Tarefa novaTarefa = new Tarefa(descricao);
          listaDeTarefas.add(novaTarefa);
          System.out.println("Tarefa criada com sucesso!");
          break;

        case 2: // Listar tarefas
          System.out.println("Lista de Tarefas:");
          for (int i = 0; i < listaDeTarefas.size(); i++) {
            System.out.println((i + 1) + ". " + listaDeTarefas.get(i).getDescricao());
          }
          break;

        case 3: // Atualizar tarefa
          System.out.print("Digite o número da tarefa que deseja atualizar: ");
          int indiceAtualizar = input.nextInt() - 1;
          input.nextLine();
          if (indiceAtualizar >= 0 && indiceAtualizar < listaDeTarefas.size()) {
            System.out.print("Digite a nova descrição da tarefa: ");
            String novaDescricao = input.nextLine();
            listaDeTarefas.get(indiceAtualizar).setDescricao(novaDescricao);
            System.out.println("Tarefa atualizada com sucesso!");
          } else {
            System.out.println("Tarefa não encontrada.");
          }
          break;

        case 4: // Excluir tarefa
          System.out.print("Digite o número da tarefa que deseja excluir: ");
          int indiceExcluir = input.nextInt() - 1;
          if (indiceExcluir >= 0 && indiceExcluir < listaDeTarefas.size()) {
            listaDeTarefas.remove(indiceExcluir);
            System.out.println("Tarefa excluída com sucesso!");
          } else {
            System.out.println("Tarefa não encontrada.");
          }
          break;

        case 5: // Sair
          System.out.println("Saindo do aplicativo.");
          System.exit(0);

        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }
    }
  }
}

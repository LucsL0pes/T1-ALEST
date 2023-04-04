import classesdeapoio.ListaMercadorias;
import classesdeapoio.ordenacao.BubbleSort;

import java.io.FileNotFoundException;

public class AppExemplo {
    public static void main(String[] args) {
        ListaMercadorias lista = new ListaMercadorias();

        String arquivo = "arquivos\\mercadorias_N_1000.txt";

        try {
            lista.carregarArquivo(arquivo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Arquivo " + arquivo + " carregado com sucesso.");
        System.out.println("Total de " + lista.getQuantidade() + " itens.");

        //Exemplo de como ordenar com o BubbleSort
        //primeira coisa é pegar os codigos da lista e colocar em um array de int
        int[] arrayCodigos = new int[lista.getQuantidade()];
        for (int i = 0; i < lista.getQuantidade(); i++) {
            arrayCodigos[i] = lista.buscar(i).getCodigo();
        }
        //arrayCodigos já está preenchido com todos os codigos do arquivos de mercadorias
        //agora so rodar o bubble e pegar os resultdos
        BubbleSort bs = new BubbleSort();
        bs.ordenar(arrayCodigos);
        System.out.println("Total de operacoes = " + bs.getOperacoes());
        System.out.println("Tempo percorrido (ms) = " + bs.getTempoExecucao());

    }
}

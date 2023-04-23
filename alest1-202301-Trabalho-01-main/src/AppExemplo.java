import classesdeapoio.ListaMercadorias;
import classesdeapoio.ordenacao.*;

import java.io.FileNotFoundException;

public class AppExemplo {
    public static void main(String[] args) {
        ListaMercadorias lista = new ListaMercadorias();

        String arquivo = "arquivos\\mercadorias_N_20000.txt";

        try {
            lista.carregarArquivo(arquivo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Arquivo " + arquivo + " carregado com sucesso.");
        System.out.println("Total de " + lista.getQuantidade() + " itens.");

        //Exemplo de como ordenar com o BubbleSort
        //primeira coisa é pegar os codigos da lista e colocar em um array de int
        int[] arrayCodigosBS = new int[lista.getQuantidade()];
        int[] arrayCodigosBSO = new int[lista.getQuantidade()];
        int[] arrayCodigosIS = new int[lista.getQuantidade()];
        int[] arrayCodigosMS = new int[lista.getQuantidade()];
        int[] arrayCodigosQS = new int[lista.getQuantidade()];
        for (int i = 0; i < lista.getQuantidade(); i++) {
            arrayCodigosBS[i] = lista.buscar(i).getCodigo();
            arrayCodigosBSO[i] = lista.buscar(i).getCodigo();
            arrayCodigosIS[i] = lista.buscar(i).getCodigo();
            arrayCodigosMS[i] = lista.buscar(i).getCodigo();
            arrayCodigosQS[i] = lista.buscar(i).getCodigo();
        }
        //arrayCodigos já está preenchido com todos os codigos do arquivos de mercadorias
        //agora so rodar o bubble e pegar os resultdos
        BubbleSort bs = new BubbleSort();
        bs.ordenar(arrayCodigosBS);
        System.out.println("Total de operacoes = " + bs.getOperacoes() );
        System.out.println("Tempo percorrido (ms) = " + bs.getTempoExecucao());

        BubbleSortOtimizado bso = new BubbleSortOtimizado();
        bso.ordenar(arrayCodigosBSO);
        System.out.println("Total de operacoes = " + bso.getOperacoes() );
        System.out.println("Tempo percorrido (ms) = " + bso.getTempoExecucao());

        InsertionSort is = new InsertionSort();
        is.ordenar(arrayCodigosIS);
        System.out.println("Total de operacoes = " + is.getOperacoes() );
        System.out.println("Tempo percorrido (ms) = " + is.getTempoExecucao());

        MergeSort ms = new MergeSort();
        ms.ordenar(arrayCodigosMS);
        System.out.println("Total de operacoes = " + ms.getOperacoes() );
        System.out.println("Tempo percorrido (ms) = " + ms.getTempoExecucao());

        QuickSort qs = new QuickSort();
        qs.ordenar(arrayCodigosQS);
        System.out.println("Total de operacoes = " + qs.getOperacoes() );
        System.out.println("Tempo percorrido (ms) = " + qs.getTempoExecucao());


    }
}
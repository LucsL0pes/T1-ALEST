package classesdeapoio.ordenacao;

public class MergeSort {
    private int operacoes; //propriedade para guardar o numero de operacoes realizadas
    private long tempoInicio; //usado para guardar o inicio da execucao
    private long tempoFim;
    private int[] arrayInteiros;
    private int[] arrayAuxiliar;
    private int tamanho;

    public long getOperacoes() {
        return operacoes;
    }

    public long getTempoExecucao() {
        long tempoExecucao = (tempoFim - tempoInicio) / 1_000_000  ;
        return tempoExecucao;
    }

    public void ordenar(int[] arrayInteiros) {
        tempoInicio = System.nanoTime();
        operacoes = 0;
        this.arrayInteiros = arrayInteiros; //apenas copia o array recebido por parametro para uma propriedade da class
        tamanho = arrayInteiros.length; //tamanho do array
        this.arrayAuxiliar = new int[tamanho]; //cria um novo array que terá os elementos ordenados
        mergeSort(0, tamanho - 1); //inicia o merge no array inteiro
        tempoFim = System.nanoTime();
    }

    private void mergeSort(int esquerda, int direita) {
        // verifica se esquerda eh menor que direita, se for igual eh pq ja terminou de dividir
        if (esquerda < direita) {
            // pega a posicao do meio
            int meio = (esquerda + direita) / 2;
            // chama recursivamente o mergeSort com o lado esquerdo da divisao
            mergeSort(esquerda, meio);
            // // chama recursivamente o mergeSort com o lado esquerdo da divisao
            mergeSort(meio + 1, direita);
            // Combina tudo
            merge(esquerda, meio, direita);
        }
    }

    private void merge(int esquerda, int meio, int direita) {

        // copia tudo para o array auxiliar
        for (int i = esquerda; i <= direita; i++) {
            arrayAuxiliar[i] = arrayInteiros[i];
            operacoes++;
        }

        int i = esquerda;
        int j = meio + 1;
        int k = esquerda;
        // Faz o merge pegando o menor elemnento da esquerda ou da direita e incrementa o k (array ordenado)
        while (i <= meio && j <= direita) {
            if (arrayAuxiliar[i] <= arrayAuxiliar[j]) {
                arrayInteiros[k] = arrayAuxiliar[i];
                i++;
                operacoes++;
            } else {
                arrayInteiros[k] = arrayAuxiliar[j];
                j++;
                operacoes++;
            }
            k++;
            operacoes++;
        }

        while (i <= meio) {
            arrayInteiros[k] = arrayAuxiliar[i];
            k++;
            i++;
            operacoes++;
        }
    }
}
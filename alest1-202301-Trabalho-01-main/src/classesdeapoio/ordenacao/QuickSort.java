package classesdeapoio.ordenacao;

public class QuickSort {
    public long getOperacoes() {
        return operacoes;
    }
    public long getTempoInicio() {
        return tempoInicio;
    }
    public long getTempoFim() {
        return tempoFim;
    }
    private long operacoes; //propriedade para guardar o numero de operacoes realizadas
    private long tempoInicio; //usado para guardar o inicio da execucao
    private long tempoFim;
    private int[] arrayInteiros;
    private int[] arrayAuxiliar;
    int tamanho;
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
        quickSort(0, tamanho - 1);
        tempoFim = System.nanoTime();
        testar();
    }

    public void quickSort(int inicio, int fim) {
        if(inicio < fim) {
            int indicePivot = particionar(inicio, fim);

            quickSort(inicio, indicePivot-1);
            quickSort(indicePivot+1, fim);

        }

    }

    public int particionar(int inicio, int fim) {
        int pivot = arrayInteiros[inicio];
        int direita = fim;

        for (int i = fim; i > inicio ; i--) {
            if(arrayInteiros[i] > pivot) {
                int temp = arrayInteiros[i];
                arrayInteiros[i] = arrayInteiros[direita];
                arrayInteiros[direita] = temp;
                direita--;
                operacoes++;
            }
            operacoes++;
        }
        int temp = arrayInteiros[direita];
        arrayInteiros[direita] = arrayInteiros[inicio];
        arrayInteiros[inicio] = temp;

        return direita;
    }
    public static void main(String[] args) {
        int[] arrayInt = {90, 18, 77, 45, 25, 15, 9, 100, 16};

        QuickSort qs = new QuickSort();
        qs.ordenar(arrayInt);

        for (int i = 0; i < arrayInt.length; i++) {
            System.out.println(arrayInt[i]);
        }
    }

    private void testar()  {
        for (int i = 1; i < arrayInteiros.length; i++) {
            if(arrayInteiros[i-1]>arrayInteiros[i]) {
                try {
                    throw new Exception("Array com problemas de ordenação");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

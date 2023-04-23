package classesdeapoio.ordenacao;

public class BubbleSort {

    public long getOperacoes() {
        return operacoes;
    }

    public long getTempoInicio() {
        return tempoInicio;
    }

    public long getTempoFim() {
        return tempoFim;
    }

    private int[] arrayInteiros;
    private long operacoes; //propriedade para guardar o numero de operacoes realizadas
    private long tempoInicio; //usado para guardar o inicio da execucao
    private long tempoFim;

    public long getTempoExecucao() {
        long tempoExecucao = (tempoFim - tempoInicio) / 1_000_000  ;
        return tempoExecucao;
    }
    public void ordenar(int[] arrayInteiros) {
        this.arrayInteiros = arrayInteiros;
        tempoInicio = System.nanoTime();
        operacoes = 0;
        int tamanho = arrayInteiros.length;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho-1-i; j++) {
                operacoes++;
                //System.out.printf("Compara %d com %d%n", arrayInteiros[j+1], arrayInteiros[j]);
                if(arrayInteiros[j]>arrayInteiros[j+1]) {
                    //System.out.printf("Troca %d por %d%n", arrayInteiros[j+1], arrayInteiros[j]);
                    int temp = arrayInteiros[j];
                    arrayInteiros[j] = arrayInteiros[j+1];
                    arrayInteiros[j+1] = temp;
                    operacoes++;
                }
                //ArrayUtils.imprimir(arrayInteiros);
            }
        }
        tempoFim = System.nanoTime();
        testar();
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

    public static void main(String[] args) {
        int[] arrayInt = new int[5];
        arrayInt[0] = 99;
        arrayInt[1] = 32;
        arrayInt[2] = 77;
        arrayInt[3] = 85;
        arrayInt[4] = 95;

        /*arrayInt[0] = 82;
        arrayInt[1] = 32;
        arrayInt[2] = 77;
        arrayInt[3] = 45;
        arrayInt[4] = 25;
         */
        BubbleSort bs = new BubbleSort();
        bs.ordenar(arrayInt);
        System.out.println(arrayInt);

    }

}

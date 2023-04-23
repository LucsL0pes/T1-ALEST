package classesdeapoio.arquivosaida;

public class LinhaArquivoSaida {
    public int valorN;
    public long bubbleSortTempo;
    public long bubbleSortOperacoes;
    public long bubbleSortOtimizadoTempo;
    public long bubbleSortOtimizadoOperacoes;
    public long insertionSortTempo;
    public long insertionSortOperacoes;
    public long mergeSortTempo;
    public long mergeSortOperacoes;
    public long quickSortTempo;
    public long quickSortOperacoes;

    public LinhaArquivoSaida(int valorN, long bubbleSortTempo, long bubbleSortOperacoes, long bubbleSortOtimizadoTempo, long bubbleSortOtimizadoOperacoes, long insertionSortTempo, long insertionSortOperacoes, long mergeSortTempo, long mergeSortOperacoes, long quickSortTempo, long quickSortOperacoes) {
        this.valorN = valorN;
        this.bubbleSortTempo = bubbleSortTempo;
        this.bubbleSortOperacoes = bubbleSortOperacoes;
        this.bubbleSortOtimizadoTempo = bubbleSortOtimizadoTempo;
        this.bubbleSortOtimizadoOperacoes = bubbleSortOtimizadoOperacoes;
        this.insertionSortTempo = insertionSortTempo;
        this.insertionSortOperacoes = insertionSortOperacoes;
        this.mergeSortTempo = mergeSortTempo;
        this.mergeSortOperacoes = mergeSortOperacoes;
        this.quickSortTempo = quickSortTempo;
        this.quickSortOperacoes = quickSortOperacoes;
    }

    public LinhaArquivoSaida(int valorN) {
        this.valorN = valorN;
    }

    @Override
    public String toString() {
        return "" + valorN +
                "," + bubbleSortTempo +
                "," + bubbleSortOperacoes +
                "," + bubbleSortOtimizadoTempo +
                "," + bubbleSortOtimizadoOperacoes +
                "," + insertionSortTempo +
                "," + insertionSortOperacoes +
                "," + mergeSortTempo +
                "," + mergeSortOperacoes +
                "," + quickSortTempo +
                "," + quickSortOperacoes;
    }
}

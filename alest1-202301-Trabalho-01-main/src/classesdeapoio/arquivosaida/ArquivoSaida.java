package classesdeapoio.arquivosaida;

import java.io.FileWriter;
import java.io.IOException;
import java.security.PublicKey;

public class ArquivoSaida {

    private String nome;
    private final int MAX_NUMERO_LINHAS = 200_000;
    private LinhaArquivoSaida[] linhas;

    private int quantidade;
    public ArquivoSaida(String nome){
        this.nome = nome;
        this.linhas = new LinhaArquivoSaida[MAX_NUMERO_LINHAS];
        this.quantidade = 0;
    }

    public void adicionarLinha(LinhaArquivoSaida linha) {
        linhas[quantidade] = linha;
        quantidade++;
    }

    public void salvar() {
        try {
            FileWriter objetoArquivo = new FileWriter(this.nome);
            objetoArquivo.write("N,Bubble Sort (Tempo),"
                    + "Bubble Sort (Operacoes),"
                    + "Bubble Sort Otimizado (Tempo),"
                    + "Bubble Sort Otimizado (Operacoes),"
                    + "Insertion Sort (Tempo),"
                    + "Insertion Sort (Operacoes),"
                    + "Merge Sort (Tempo),"
                    + "Merge Sort (Operacoes),"
                    + "Quick Sort (Tempo),"
                    + "Quick Sort (Operacoes)"
                    + System.lineSeparator());
            for (int i = 0; i < this.quantidade; i++) {
                objetoArquivo.write(linhas[i].toString() + System.lineSeparator());
            }
            objetoArquivo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

package classesdeapoio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListaMercadorias {

    private static final int CAPACIDADE_INICIAL = 1000;
    private Mercadoria[] itens;

    public int getQuantidade() {
        return quantidade;
    }

    private int quantidade;
    private int capacidade;

    public ListaMercadorias() {
        this.capacidade = CAPACIDADE_INICIAL;
        this.itens = new Mercadoria[capacidade];
        this.quantidade = 0;
    }

    public void limpar() {
        this.quantidade = 0;
        this.itens = new Mercadoria[this.capacidade];
    }
    private void atualizarCapacidade(int novaCapacidade) {
        this.capacidade = novaCapacidade;
        this.itens = new Mercadoria[this.capacidade];
    }

    public void adicionar(Mercadoria item) {
        gerenciarCapacidade();
        this.itens[quantidade] = item;
        this.quantidade++;
    }
    public void carregarArquivo(String arquivo) throws FileNotFoundException {
        File objArquivo = new File(arquivo);
        Scanner leitor = new Scanner(objArquivo);
        this.quantidade = 0;
        leitor.nextLine(); //pula primeira linha
        while (leitor.hasNextLine()) {
            String linha = leitor.nextLine();
            String[] colunas = linha.split(";");
            Mercadoria novaMercadoria = new Mercadoria(Integer.parseInt(colunas[0]), colunas[1]);
            adicionar(novaMercadoria);
        }
        leitor.close();
    }
    public void gerenciarCapacidade() {
        if(this.quantidade <this.capacidade)  { //não chegou no limite
            return;
        }
        int novaCapacidade = this.capacidade * 2; //dobra a capacidade
        Mercadoria[] auxItens = new Mercadoria[novaCapacidade];
        for (int i = 0; i < this.quantidade; i++) {
            auxItens[i] = this.itens[i];
        }
        this.itens = auxItens;
        this.capacidade = novaCapacidade;
    }
    public Mercadoria buscar(int posicao) {
        return itens[posicao];
    }

}
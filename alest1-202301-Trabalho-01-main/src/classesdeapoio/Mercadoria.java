package classesdeapoio;

public class Mercadoria {

    private int codigo;
    private String marca;

    public Mercadoria(int codigo, String marca) {
        this.codigo = codigo;
        this.marca = marca;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}

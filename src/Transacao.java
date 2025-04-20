public class Transacao {
    private int id;
    private String descricao;
    private double valor;

    public Transacao(int id, String descricao, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Transacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Transacao [id=" + id + ", descricao=" + descricao + ", valor=" + valor + "]";
    }
}

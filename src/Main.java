import java.util.List;

public class Main {
    public static void main(String[] args) {
        TransacaoDAO dao = new TransacaoDAO();

        // 5 registros
        dao.insert(new Transacao("Compra no mercado", 150.0));
        dao.insert(new Transacao("Pagamento de conta", 200.0));
        dao.insert(new Transacao("Salário recebido", 3000.0));
        dao.insert(new Transacao("Assinatura de streaming", 39.9));
        dao.insert(new Transacao("Reembolso", 120.5));

        // Consulta de todos os registros
        List<Transacao> lista = dao.getAll();
        for (Transacao t : lista) {
            System.out.println(t);
        }
    }
}

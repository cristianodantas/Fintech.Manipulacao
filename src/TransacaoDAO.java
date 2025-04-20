import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {

    private String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Altere se necessário
    private String usuario = "SEU_USUARIO"; // Coloque seu usuário Oracle aqui
    private String senha = "SUA_SENHA";     // Coloque sua senha Oracle aqui

    public void insert(Transacao transacao) {
        String sql = "INSERT INTO transacoes (descricao, valor) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, transacao.getDescricao());
            stmt.setDouble(2, transacao.getValor());
            stmt.executeUpdate();

            System.out.println("Transação inserida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir transação: " + e.getMessage());
        }
    }

    public List<Transacao> getAll() {
        List<Transacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM transacoes";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                lista.add(new Transacao(id, descricao, valor));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar transações: " + e.getMessage());
        }

        return lista;
    }
}


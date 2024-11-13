import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseMenager {
    private static final String DB_URL = "jdbc:sqlite:voti.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connessione al database SQLite stabilita.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                stmt.execute("CREATE TABLE IF NOT EXISTS percorsi (" +
                        "id INTEGER PRIMARY KEY," +
                        "nome TEXT NOT NULL)");
                stmt.execute("CREATE TABLE IF NOT EXISTS voti (" +
                        "id INTEGER PRIMARY KEY, " +
                        "percorso_id INTEGER, " +
                        "materia TEXT NOT NULL, " +
                        "voto INTEGER NOT NULL, " +
                        "crediti INTEGER NOT NULL, " +
                        "FOREIGN KEY (percorso_id) REFERENCES percorsi(id))");
                System.out.println("Tabelle create con successo.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void savePercorso(Percorso percorso) {
        String sql = "INSERT INTO percorsi(nome) VALUES(?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, percorso.getNome());
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    percorso.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveVoto(Voto voto, int percorsoId) {
        String sql = "INSERT INTO voti(percorso_id, materia, voto, crediti) VALUES(?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, percorsoId);
            pstmt.setString(2, voto.getMateria());
            pstmt.setInt(3, voto.getVoto());
            pstmt.setInt(4, voto.getCrediti());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateVoto(Voto voto) {
        String sql = "UPDATE voti SET materia = ?, voto = ?, crediti = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, voto.getMateria());
            pstmt.setInt(2, voto.getVoto());
            pstmt.setInt(3, voto.getCrediti());
            pstmt.setInt(4, voto.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteVoto(int votoId) {
        String sql = "DELETE FROM voti WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, votoId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Percorso> loadPercorsi() {
        String sql = "SELECT * FROM percorsi";
        List<Percorso> percorsi = new ArrayList<>();
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Percorso percorso = new Percorso(rs.getString("nome"));
                percorso.setId(rs.getInt("id"));
                percorso.setVoti(loadVoti(percorso.getId()));
                percorsi.add(percorso);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return percorsi;
    }

    public static ArrayList<Voto> loadVoti(int percorsoId) {
        String sql = "SELECT * FROM voti WHERE percorso_id = ?";
        ArrayList<Voto> voti = new ArrayList<>();
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, percorsoId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Voto voto = new Voto(rs.getString("materia"), rs.getInt("voto"), rs.getInt("crediti"));
                    voto.setId(rs.getInt("id"));
                    voti.add(voto);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return voti;
    }
}


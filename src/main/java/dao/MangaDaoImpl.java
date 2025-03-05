package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Manga;

public class MangaDaoImpl implements IMangaDao {
    @Override
    public Manga save(Manga m) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO MANGAS(NOM_MANGA,PRIX) VALUES(?,?)");
            ps.setString(1, m.getNomManga());
            ps.setDouble(2, m.getPrix());
            ps.executeUpdate();
            PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(ID_MANGA) as MAX_ID FROM MANGAS");
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                m.setIdManga(rs.getLong("MAX_ID"));
            }
            ps.close();
            ps2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public List<Manga> mangasParMC(String mc) {
        List<Manga> mangas = new ArrayList<Manga>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM MANGAS WHERE NOM_MANGA LIKE ?");
            ps.setString(1, "%" + mc + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Manga m = new Manga();
                m.setIdManga(rs.getLong("ID_MANGA"));
                m.setNomManga(rs.getString("NOM_MANGA"));
                m.setPrix(rs.getDouble("PRIX"));
                mangas.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mangas;
    }

    @Override
    public Manga getManga(Long id) {
        Connection conn = SingletonConnection.getConnection();
        Manga m = new Manga();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM MANGAS WHERE ID_MANGA = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                m.setIdManga(rs.getLong("ID_MANGA"));
                m.setNomManga(rs.getString("NOM_MANGA"));
                m.setPrix(rs.getDouble("PRIX"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public Manga updateManga(Manga m) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE MANGAS SET NOM_MANGA=?, PRIX=? WHERE ID_MANGA=?");
            ps.setString(1, m.getNomManga());
            ps.setDouble(2, m.getPrix());
            ps.setLong(3, m.getIdManga());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public void deleteManga(Long id) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM MANGAS WHERE ID_MANGA = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

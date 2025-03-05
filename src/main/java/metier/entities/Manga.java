package metier.entities;

import java.io.Serializable;

public class Manga implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idManga;
    private String nomManga;
    private double prix;

    public Manga() {
        super();
    }

    public Manga(String nomManga, double prix) {
        super();
        this.nomManga = nomManga;
        this.prix = prix;
    }

    public Long getIdManga() {
        return idManga;
    }

    public void setIdManga(Long idManga) {
        this.idManga = idManga;
    }

    public String getNomManga() {
        return nomManga;
    }

    public void setNomManga(String nomManga) {
        this.nomManga = nomManga;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}

package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.Manga;

public class MangaModele {
    private String motCle;
    private List<Manga> mangas = new ArrayList<>();

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<Manga> getMangas() {
        return mangas;
    }

    public void setMangas(List<Manga> mangas) {
        this.mangas = mangas;
    }
}

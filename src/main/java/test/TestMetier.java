package test;

import java.util.List;
import dao.MangaDaoImpl;
import metier.entities.Manga;

public class TestMetier {
    public static void main(String[] args) {
        MangaDaoImpl mdao = new MangaDaoImpl();
        Manga manga = mdao.save(new Manga("One Piece", 3800));
        System.out.println(manga);
        
        List<Manga> mangas = mdao.mangasParMC("Naruto");
        for (Manga m : mangas)
            System.out.println(m);
    }
}

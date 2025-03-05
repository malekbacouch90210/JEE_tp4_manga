package dao;

import java.util.List;
import metier.entities.Manga;

public interface IMangaDao {
    public Manga save(Manga m);

    public List<Manga> mangasParMC(String mc);

    public Manga getManga(Long id);

    public Manga updateManga(Manga m);

    public void deleteManga(Long id);
}

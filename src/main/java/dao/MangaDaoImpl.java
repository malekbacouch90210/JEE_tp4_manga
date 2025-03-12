package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Manga;
import util.JPAutil;

public class MangaDaoImpl implements IMangaDao {
    private EntityManager entityManager = JPAutil.getEntityManager("JEE_TP5_Manga");

    @Override
    public Manga save(Manga m) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(m);
        tx.commit();
        return m;
    }

    @Override
    public List<Manga> mangasParMC(String mc) {
        List<Manga> mangas =
            entityManager.createQuery("select m from Manga m where m.nomManga like :mc")
                .setParameter("mc", "%" + mc + "%")
                .getResultList();
        return mangas;
    }

    @Override
    public Manga getManga(Long id) {
        return entityManager.find(Manga.class, id);
    }

    @Override
    public Manga updateManga(Manga m) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(m);
        tx.commit();
        return m;
    }

    @Override
    public void deleteManga(Long id) {
        Manga manga = entityManager.find(Manga.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(manga);
        entityManager.getTransaction().commit();
    }
}
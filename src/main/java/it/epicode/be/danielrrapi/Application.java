package it.epicode.be.danielrrapi;

import com.github.javafaker.Faker;
import it.epicode.be.danielrrapi.dao.OperaEditorialeDAO;
import it.epicode.be.danielrrapi.dao.PrestitoDAO;
import it.epicode.be.danielrrapi.dao.UtenteDAO;
import it.epicode.be.danielrrapi.entities.Libro;
import it.epicode.be.danielrrapi.entities.Rivista;
import it.epicode.be.danielrrapi.entities.Utente;
import it.epicode.be.danielrrapi.enums.LibroGenereTypes;
import it.epicode.be.danielrrapi.enums.RivistaPeriodicitaTypes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D5");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        // -----------------------------------DAO-----------------------------------------

        OperaEditorialeDAO od = new OperaEditorialeDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        PrestitoDAO pd = new PrestitoDAO(em);

        // -----------------------------------SUPPLIER-----------------------------------------
        Faker faker = new Faker();
        Supplier<Integer> anniRandomSupplier = () -> {
            Random random = new Random();
            return Integer.valueOf(random.nextInt(1950, 2000));
        };
        Supplier<Integer> mesiRandomSupplier = () -> {
          Random random = new Random();
          return Integer.valueOf(random.nextInt(1, 12));
        };
        Supplier<Integer> giorniRandomSupplier = () -> {
          Random random = new Random();
          return Integer.valueOf(random.nextInt(1, 27));
        };
        Supplier<RivistaPeriodicitaTypes> rivistaPeriodicitaTypesSupplier = () -> {
            int rndmInt = new Random().nextInt(1, 4);
            RivistaPeriodicitaTypes result = null;
            switch (rndmInt) {
                case 1 -> result = RivistaPeriodicitaTypes.SEMESTRALE;
                case 2 -> result = RivistaPeriodicitaTypes.SETTIMANALE;
                case 3 -> result = RivistaPeriodicitaTypes.MENSILE;
            }
            return result;
        };
        Supplier<LibroGenereTypes> libroGenereTypesSupplier = () -> {
          int rndmInt = new Random().nextInt(1, 6);
          LibroGenereTypes result = null;
          switch (rndmInt) {
              case 1 -> result = LibroGenereTypes.FANTASY;
              case 2 -> result = LibroGenereTypes.SAGGIO;
              case 3 -> result = LibroGenereTypes.GIALLO;
              case 4 -> result = LibroGenereTypes.STORICO;
              case 5 -> result = LibroGenereTypes.ALTRO;
          }
          return result;
        };
        Supplier<Rivista> rivistaSupplier = () -> {
            return new Rivista(faker.book().title(), faker.random().nextInt(2000, 2024), faker.random().nextInt(10, 300), rivistaPeriodicitaTypesSupplier.get());
        };
        Supplier<Libro> libroSupplier = () -> {
            return new Libro(faker.book().title(), faker.random().nextInt(2000, 2024), faker.random().nextInt(10, 300), faker.book().author(), libroGenereTypesSupplier.get());
        };
        AtomicInteger atomicIntForTessera = new AtomicInteger();
        Supplier<Utente> utenteSupplier = () -> {
          return new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.of(anniRandomSupplier.get(), mesiRandomSupplier.get(), giorniRandomSupplier.get()), atomicIntForTessera.getAndIncrement());
        };


//        for (int i = 0; i < 16; i++) {
//            ud.save(utenteSupplier.get());
//            od.save(libroSupplier.get());
//            od.save(rivistaSupplier.get());
//
//        }
        System.out.prinln(od.findById(2));





        em.close();
        emf.close();
    }

}

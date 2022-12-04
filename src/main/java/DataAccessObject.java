import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.HibernateUtil;
import pl.sda.hibernate.model.Mechanik;
import pl.sda.hibernate.model.Pojazd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataAccessObject <T>{

    // specyficzny typo obiektu, który służy do dostępu/zarządzania dostępem obiektów w bazie
    // instancja klasy, która umożliwia manipulowanie danymi w bazie


    public void insert (T obiektDoWstawieniaDoBazy){
        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(obiektDoWstawieniaDoBazy);

            transaction.commit();

        } catch (Exception e){
            System.err.println("Błąd: "+ e);
        }
    }
    public List<T> findAll (Class<T> tClass){

        List<T> list = new ArrayList<>();


        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            TypedQuery<T> zapytanie = session.createQuery("FROM "+tClass.getName(), tClass);

           list.addAll(zapytanie.getResultList()); // zwraca listę, nie wypisue

        } catch (Exception e){
            System.err.println("Błąd: "+e);
        }
        return list;
    }

    public Optional<T> find(Class<T> tClass, Long id){
        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){

            Pojazd pojazd = session.get(Pojazd.class, id);
            T encja = session.get(tClass, id);

        return Optional.ofNullable(encja);
        } catch (Exception ioe){
            System.err.println("Błąd: "+ ioe);
        }
        return Optional.empty();
    }

    public boolean delete(Class<T> tClass, Long id){
        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            //sprawdz czy istnieje - pobrac id i spr czy nie jest null
            T encja = session.get(tClass, id);

            if(encja == null){
                return false; // nie ma encji z takim id
            } else {
                session.remove(encja);
                transaction.commit();
                return true; // znaleźliśmy encję i ją usunęliśmy, zrobiliśmy commit
            }

        } catch (Exception ioe){
            System.err.println("Błąd: "+ ioe);
        }

        return false; //wystąpił błąd, nie usunęliśmy rekordu
    }

    public void update(Class<T> tClass, Long id, T encjaAktualizujaca){
        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            T encja = session.get(tClass, id);
            if(encja==null){
                System.err.println("Nie znaleziono rekordu.");
                return;
            }
            session.merge(encjaAktualizujaca);

        } catch (Exception e){
            System.err.println("Błąd: "+e);
        }
    }

    public boolean exists(Class<T> tClass, Long id){
        try(Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){

            T encja = session.get(tClass, id);
            if(encja !=null){
                return true;
            }

        }catch (Exception e){
            System.err.println("Błąd: "+ e);
        }
        return false;
    }

}

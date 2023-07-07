package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
       EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
       EntityManager em = emf.createEntityManager();

       EntityTransaction tx =  em.getTransaction();
       tx.begin();
       try{
          Member member = new Member();
          member.setId(100L);
          member.setName("helloJPA");

          em.persist(member);//여기서 영속상태가된다.

          tx.commit();
       } catch (Exception e){
          tx.rollback();
       } finally {
          em.close();
       }

       emf.close();
    }
}

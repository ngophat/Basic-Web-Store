package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entityBeans.Sua;

/**
 * Session Bean implementation class CtHoadon
 */
@Stateless
public class CtHoadonSB implements CtHoadonSBLocal {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("QLBanSuaSE");
	EntityManager em;
    /**
     * Default constructor. 
     */
    public CtHoadonSB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Sua> suaBanChay() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("SuaBanChay", CtHoadonSB.class);
		List<Sua> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return list;
	}

}

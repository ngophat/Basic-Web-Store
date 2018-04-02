package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entityBeans.CtHoadon;
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
	public List<Sua> suaBanChay(int n) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
//		Query query = em.createQuery("SELECT hd.sua " + 
//		"FROM CtHoadon hd " + 
//		"GROUP BY hd.sua.ten_sua " +
//		"ORDER BY SUM(hd.so_luong) desc");
		Query query = em.createNamedQuery("SuaBanChay", CtHoadon.class);
		query.setFirstResult(0);
		query.setMaxResults(n);
		List<Sua> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return list;
	}

}

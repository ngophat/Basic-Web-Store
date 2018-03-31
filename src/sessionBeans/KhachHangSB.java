package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entityBeans.KhachHang;

/**
 * Session Bean implementation class KhachHangSB
 */
@Stateless
public class KhachHangSB implements KhachHangSBLocal {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("QLBanSuaSE");
	EntityManager em;
    /**
     * Default constructor. 
     */
    public KhachHangSB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void them(KhachHang khachHang) {
		em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(khachHang);
		em.getTransaction().commit();
		em.close();
	}

}

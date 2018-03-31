package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entityBeans.HangSua;
import entityBeans.LoaiSua;
import entityBeans.Sua;

/**
 * Session Bean implementation class HangSuaSB
 */
@Stateless
public class HangSuaSB implements HangSuaSBLocal {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("QLBanSuaSE");
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public HangSuaSB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<HangSua> docTatCa() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("HangSua.findAll", Sua.class);
		List<HangSua> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return list;
	}

	@Override
	public HangSua timTheoMa(String mahang) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		HangSua hangSua = em.find(HangSua.class, mahang);
		em.getTransaction().commit();
		em.close();
		return hangSua;
	}
}

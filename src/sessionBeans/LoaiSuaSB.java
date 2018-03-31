package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entityBeans.LoaiSua;
import entityBeans.Sua;

/**
 * Session Bean implementation class LoaiSuaSB
 */
@Stateless
public class LoaiSuaSB implements LoaiSuaSBLocal {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("QLBanSuaSE");
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public LoaiSuaSB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<LoaiSua> docTatCa() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("LoaiSua.findAll", Sua.class);
		List<LoaiSua> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return list;
	}

	@Override
	public LoaiSua timTheoMa(String maloai) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		LoaiSua loaiSua = em.find(LoaiSua.class, maloai);
		em.getTransaction().commit();
		em.close();
		return loaiSua;
	}

}

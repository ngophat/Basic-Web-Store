package sessionBeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entityBeans.Sua;

/**
 * Session Bean implementation class SuaSB
 */
@Stateless
public class SuaSB implements SuaSBLocal {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("QLBanSuaSE");
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public SuaSB() {
    }

	@Override
	public List<Sua> docTatCa() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("Sua.findAll", Sua.class);
		List<Sua> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return list;
	}

	@Override
	public Sua timTheoMa(String masua) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Sua sua = em.find(Sua.class, masua);
		em.getTransaction().commit();
		em.close();
		return sua;
	}

	@Override
	public void themSua(Sua sua) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(sua);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Sua> timTheoTen(String maHS, String maLS, String tenSua) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select s from Sua s where s.hangSua.ma_hang_sua = '"+maHS+"'"
				+ " and s.loaiSua.ma_loai_sua = '"+maLS+"' and s.ten_sua like '%"+tenSua+"%'");
		List<Sua> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return list;
	}

	@Override
	public int tongSanPham(List<Sua> list) {
		return list.size();
	}

}

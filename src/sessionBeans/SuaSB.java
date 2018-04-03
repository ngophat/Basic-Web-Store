package sessionBeans;

import java.util.ArrayList;
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

	@Override
	public List<Sua> phanTrang(List<Sua> list, int page, int tongSP, int tongST) {
		int div = tongSP%5, min=0, max = 5;
		if(page!=0) {
			min = 5*((page)-1);
	        max =(page==tongST) ?
	        		5*page-div+1 : 5*page;   
		}	    
		List<Sua> sua = new ArrayList<>();
		for(int i=min;i<max;i++) {
			sua.add(list.get(i));
		}
		return sua;
	}

	@Override
	public int tongSoTrang(int tongSanPham) {
		int div, tongSoTrang;
		tongSoTrang = tongSanPham/5;
		div = tongSanPham%5;
        if(div!=0) {
        	tongSoTrang ++;
        }
		return tongSoTrang;
	}	
}

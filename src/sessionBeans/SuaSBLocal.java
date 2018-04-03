package sessionBeans;

import java.util.List;

import javax.ejb.Local;

import entityBeans.Sua;

@Local
public interface SuaSBLocal {
	List<Sua> docTatCa();
	Sua timTheoMa(String mahang);
	void themSua(Sua sua);
	List<Sua> timTheoTen(String maHS, String maLS, String tenSua);
	int tongSanPham(List<Sua> list);
	int tongSoTrang(int tongSanPham);
	List<Sua> phanTrang(List<Sua> list, int page, int tongSP, int tongST);
}

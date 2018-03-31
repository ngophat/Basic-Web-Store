package sessionBeans;

import java.util.List;

import javax.ejb.Local;

import entityBeans.LoaiSua;

@Local
public interface LoaiSuaSBLocal {
	List<LoaiSua> docTatCa();
	LoaiSua timTheoMa(String maloai);
}

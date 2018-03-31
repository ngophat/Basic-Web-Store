package sessionBeans;

import java.util.List;

import javax.ejb.Local;

import entityBeans.HangSua;

@Local
public interface HangSuaSBLocal {
	List<HangSua> docTatCa();
	HangSua timTheoMa(String mahang);
}

package sessionBeans;

import java.util.List;

import javax.ejb.Local;

import entityBeans.Sua;

@Local
public interface CtHoadonSBLocal {
	List<Sua> suaBanChay(int n);
}

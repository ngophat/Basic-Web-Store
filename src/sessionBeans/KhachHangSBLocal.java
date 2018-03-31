package sessionBeans;

import javax.ejb.Local;

import entityBeans.KhachHang;

@Local
public interface KhachHangSBLocal {
	void them(KhachHang khachHang);
}

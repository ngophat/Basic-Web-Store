package entityBeans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sua database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Sua.findAll", query="SELECT s FROM Sua s")
})
public class Sua implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ma_sua;

	private int don_gia;

	private String hinh;

	@Lob
	private String loi_ich;

	private String ten_sua;

	@Lob
	private String tp_dinh_duong;

	private int trong_luong;

	//bi-directional many-to-one association to CtHoadon
	@OneToMany(mappedBy="sua")
	private List<CtHoadon> ctHoadons;

	//bi-directional many-to-one association to HangSua
	@ManyToOne
	@JoinColumn(name="Ma_hang_sua")
	private HangSua hangSua;

	//bi-directional many-to-one association to LoaiSua
	@ManyToOne
	@JoinColumn(name="Ma_loai_sua")
	private LoaiSua loaiSua;

	public Sua() {
	}

	public String getMa_sua() {
		return this.ma_sua;
	}

	public void setMa_sua(String ma_sua) {
		this.ma_sua = ma_sua;
	}

	public int getDon_gia() {
		return this.don_gia;
	}

	public void setDon_gia(int don_gia) {
		this.don_gia = don_gia;
	}

	public String getHinh() {
		return this.hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public String getLoi_ich() {
		return this.loi_ich;
	}

	public void setLoi_ich(String loi_ich) {
		this.loi_ich = loi_ich;
	}

	public String getTen_sua() {
		return this.ten_sua;
	}

	public void setTen_sua(String ten_sua) {
		this.ten_sua = ten_sua;
	}

	public String getTp_dinh_duong() {
		return this.tp_dinh_duong;
	}

	public void setTp_dinh_duong(String tp_dinh_duong) {
		this.tp_dinh_duong = tp_dinh_duong;
	}

	public int getTrong_luong() {
		return this.trong_luong;
	}

	public void setTrong_luong(int trong_luong) {
		this.trong_luong = trong_luong;
	}

	public List<CtHoadon> getCtHoadons() {
		return this.ctHoadons;
	}

	public void setCtHoadons(List<CtHoadon> ctHoadons) {
		this.ctHoadons = ctHoadons;
	}

	public CtHoadon addCtHoadon(CtHoadon ctHoadon) {
		getCtHoadons().add(ctHoadon);
		ctHoadon.setSua(this);

		return ctHoadon;
	}

	public CtHoadon removeCtHoadon(CtHoadon ctHoadon) {
		getCtHoadons().remove(ctHoadon);
		ctHoadon.setSua(null);

		return ctHoadon;
	}

	public HangSua getHangSua() {
		return this.hangSua;
	}

	public void setHangSua(HangSua hangSua) {
		this.hangSua = hangSua;
	}

	public LoaiSua getLoaiSua() {
		return this.loaiSua;
	}

	public void setLoaiSua(LoaiSua loaiSua) {
		this.loaiSua = loaiSua;
	}

}
<%-- 
    Document   : san-pham
    Author     : hv
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page1" class="main">
    <div class="col1">
        <p id="sp">Sản phẩm theo hãng sữa</p>
        <ul>
            <c:forEach  items="${listHS}" var="list">
                <li><a href="trang-chu.jsp?">${list.ten_hang_sua}</a></li>
            </c:forEach>
        </ul>
        <p>Sản phẩm theo loại</p>
        <ul>
            <c:forEach items="${listLS}" var="list">
               <li><a href="trang-chu.jsp?">${list.ten_loai}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col2">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp"%>
        </div>
        <div class="col21">
            <table border="1" width="100%">
                <caption>DANH SÁCH SỮA</caption>
                <thead>
                    <tr>
                        <th>Hình</th>
                        <th>Tên sữa</th>
                        <th>Trọng lượng</th>
                        <th>Đơn giá</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listS}" var="list">
                    <tr>
                        <td style="text-align: center;"><img src="./images/${list.hinh}"/></td>
                        <td><a href="trang-thong-tin-sua.jsp?maSua=${list.ma_sua}">${list.ten_sua}</a></td>
                        <td style="text-align: right;">${list.trong_luong}</td>
                        <fmt:setLocale value="vi-VN"></fmt:setLocale>
                        <fmt:formatNumber value="${list.don_gia}" var="donGia" type="number"></fmt:formatNumber>
                        <td style="text-align: right;">${donGia}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="danh-sach-trang">
            <c:if test="${tongSoTrang>1}">
                <c:forEach var="i" begin="1" end="${tongSoTrang}" step="1">
                    <c:if test="${!empty param.maHang}">
                        <a href="trang-chu.jsp?maHang=${param.maHang}&trang=${i}"> ${i} </a>
                    </c:if>
                    <c:if test="${!empty param.maLoai}">
                        <a href="trang-chu.jsp?maLoai=${param.maLoai}&trang=${i}"> ${i} </a>
                    </c:if>
                    <c:if test="${empty param.maHang && empty param.maLoai}">
                        <a href="trang-chu.jsp?trang=${i}"> ${i} </a>
                    </c:if>
                </c:forEach>
            </c:if>
            </div>
        </div>
        <div class="col22">
            <%@include file="hinh-anh.html"%>
        </div>
    </div>
</div>
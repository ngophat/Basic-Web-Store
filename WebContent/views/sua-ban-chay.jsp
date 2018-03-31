<%-- 
    Document   : sua-ban-chay
    Author     : hv
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="vi-VN"/>
<div id="page3" class="main">
    <div class="col1">
        <p>Danh sách sữa bán chạy</p>
        <ul>
            <c:forEach items="${listDS }"  var="list">
                <li><a href="trang-sua-ban-chay.jsp?maSua=${list.ma_sua}">${list.ten_sua}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col2">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp" %>
        </div>
        <table>
            <tr>
                <td colspan="2" class="tieu-de-sua">${Sua.ten_sua}</td>
            </tr>
            <tr>
                <td><img src="./images/${Sua.hinh}"></td>
                <td>
                    <p><b><i>Thành phần dinh dưỡng:</i></b><br>${Sua.tp_dinh_duong }</p>
                    <p><b><i>Lợi ích:</i></b><br>${Sua.loi_ich }</p>
                    <fmt:formatNumber value="${Sua.don_gia }" type="number" var="donGia"/>
                    <p><b><i>Trọng lượng:</i></b> ${Sua.trong_luong } gr - <b><i>Đơn giá:</i></b> ${donGia} đ</p>
                </td>
            </tr>
        </table>
    </div>
</div>
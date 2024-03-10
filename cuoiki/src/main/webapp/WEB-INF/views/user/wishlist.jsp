<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page-heading header-text">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<span class="breadcrumb"><a
					href="${pageContext.request.contextPath}/home">Trang chủ/ Căn
						hộ yêu thích</a></span>
				<h3>Căn nhà yêu thích của bạn</h3>
			</div>
		</div>
	</div>
</div>
<%
                	HttpSession session2 = request.getSession();
                	String msg = (String) session2.getAttribute("msg");
                	String msg1 = msg;
                	session2.removeAttribute("msg");
                %>
<c:if test="<%= msg1 != null %>">
	<script>
                	alert('<%= msg1 %>');
                	</script>
</c:if>
<div class="contact-page section" style="margin-top: 60px;">
	<div class="container">
		<a href="${pageContext.request.contextPath}/userapartment"><button
				class="btn"
				style="margin-left: 24px; color: white; background-color: #f35525; font-weight: bold;">
				<i class="fa-solid fa-arrow-right fa-rotate-180"></i> Tiếp tục xem
			</button></a>
		<div class="row mb-5 mt-5 border border-white" id="contact-form">
			<h3
				style="text-align: center; color: coral; text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;">
				Căn nhà yêu thích của bạn</h3>
		</div>
		<div class="row">
			<div class="col-lg-12">
				<form id="contact-form" action="" method="post">
					<table class="table table-hover border-dark-subtle">
						<thead>
							<tr
								style="vertical-align: top; text-align: center; padding: 12px 24px;"
								class="bg-secondary-subtle">
								<th scope="col" style="width: 240px;">Căn hộ</th>
								<th scope="col-1" style="width: 550px;">Tiêu đề</th>
								<th scope="col-2">Giá</th>
								<th scope="col-2">Mô tả</th>
								<th scope="col-2">Xem chi tiết</th>
								<th scope="col-2">Xóa</th>
							</tr>
						</thead>
						<tbody style="vertical-align: middle; text-align: center;">
							<c:forEach var="post" items="${sessionScope.posts }"
								varStatus="i">
								<tr>
									<td><img
										src="${pageContext.request.contextPath}/assets/user/images/150canho/${post.avatar}"
										height="140"></td>
									<td>${post.subject}</td>
									<td>${post.price}tỷ VNĐ</td>
									<td>${post.description}</td>
									<td><a
										href="${pageContext.request.contextPath}/userapartmentdetails?id=${post.id}">Xem
											chi tiết</a></td>
									<td><a
										href="${pageContext.request.contextPath}/wishlist?action=remove&id=${i.index}"
										onclick="return confirm('Xóa căn hộ khỏi danh sách yêu thích?');"><i
											class="fa-solid fa-trash text-danger"></i></a></td>
								</tr>
							</c:forEach>


						</tbody>
					</table>
				</form>
			</div>
			<!-- <div class="col-lg-4">
          <div class="section-heading">
            <h6>| Liên hệ với chúng tôi</h6>
            <h2>Đừng ngần ngại xin hãy liên hệ</h2>
          </div>
          <p>Hệ thống nhà ở $Apartment xin cảm ơn bạn đã ghé thăm và liên hệ với chúng tôi. Là một thành viên trong ngành tuy còn mới nhưng chúng tôi tin rằng sẽ đem đến những điều tốt đẹp nhất đến với khách hàng và cộng đồng. Nếu bạn cần chúng tôi tìm kiếm căn hộ phù hợp với nhu cầu của bạn, đừng ngần ngại hãy liên hệ theo thông tin bên dưới</p>
          <div class="row">
            <div class="col-lg-12">
              <div class="item phone">
                <img src="${pageContext.request.contextPath}/assets/user/images/phone-icon.png" alt="" style="max-width: 52px;">
                <h6>0916700827<br><span>Số điện thoại</span></h6>
              </div>
            </div>
            <div class="col-lg-12">
              <div class="item email">
                <img src="${pageContext.request.contextPath}/assets/user/images/email-icon.png" alt="" style="max-width: 52px;">
                <h6>apart@gmail.com<br><span>Email của chúng tôi</span></h6>
              </div>
            </div>
          </div>
        </div> -->
		</div>
	</div>
</div>
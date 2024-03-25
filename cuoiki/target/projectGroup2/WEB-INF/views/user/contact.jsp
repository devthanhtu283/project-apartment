<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <div class="page-heading header-text">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <span class="breadcrumb"><a href="${pageContext.request.contextPath}/home">Trang chủ</a></span>
          <h3> Liên Hệ Chúng Tôi</h3>
        </div>
      </div>
    </div>
  </div>

  <div class="contact-page section">
    <div class="container">
      <div class="row">
        <div class="col-lg-6">
          <div class="section-heading">
            <h6>| Liên hệ với chúng tôi</h6>
            <h2>Đừng ngần ngại xin hãy liên hệ</h2>
          </div>
          <p>Hệ thống nhà ở Apartment xin cảm ơn bạn đã ghé thăm và liên hệ với chúng tôi. Là một thành viên trong ngành tuy còn mới nhưng chúng tôi tin rằng sẽ đem đến những điều tốt đẹp nhất đến với khách hàng và cộng đồng. Nếu bạn cần chúng tôi tìm kiếm căn hộ phù hợp với nhu cầu của bạn, đừng ngần ngại hãy liên hệ theo thông tin bên dưới</p>
          <div class="row">
            <div class="col-lg-12">
              <div class="item phone">
                <img src="${pageContext.request.contextPath}/assets/user/images/phone-icon.png" alt="" style="max-width: 52px;">
                <h6>18001515<br><span>Đường dây nóng</span></h6>
              </div>
            </div>
            <div class="col-lg-12">
              <div class="item email">
                <img src="${pageContext.request.contextPath}/assets/user/images/email-icon.png" alt="" style="max-width: 52px;">
                <h6>apart@gmail.com<br><span>Email của chúng tôi</span></h6>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-6">
          <form id="contact-form" action="${pageContext.request.contextPath }/contact?action=contact" method="post">
            <div class="row">
              <div class="col-lg-12">
                <fieldset>
                  <span style="color: red;">* </span><label for="name">Họ tên</label>
                  <input type="name" name="name" id="name" placeholder="Vui lòng nhập họ tên" autocomplete="on" required>
                </fieldset>
              </div>
               <div class="col-lg-12">
                <fieldset>
                  <span style="color: red;">* </span><label for="email">Số điện thoại</label>
                  <input type="text" name="phoneNumber" id="phoneNumber" pattern="(\(\+[0-9]{2}\)|0)([0-9]{9,10})" type="tel" placeholder="Nhập số điện thoại của bạn" required>
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <span style="color: red;">* </span><label for="email">Địa chỉ email</label>
                  <input type="text" name="email" id="email" pattern="[^ @]*@[^ @]*" placeholder="Vui lòng nhập email" required="">
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <label for="subject">Tiêu đề</label>
                  <input type="subject" name="subject" id="subject" placeholder="Vui lòng nhập tiêu đề" autocomplete="on" required="">
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <label for="message">Thông điệp</label>
                  <textarea name="message" id="message" required="" placeholder="Vui lòng nhập thông điệp"></textarea>
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <button type="submit" id="form-submit" class="orange-button">Gửi</button>
                </fieldset>
                <br>
                <%
                	HttpSession session1 = request.getSession();
                	String success = (String) session1.getAttribute("success");
                	String success1 = success;               	
                	session1.removeAttribute("success");
                %>
              <c:if test="<%= success1 != null %>">
              	<script>
              		alert('<%= success1 %>');
              	</script>
              </c:if>
              </div>
            </div>
          </form>
        </div>
        <div class="col-lg-12">
          <div id="map">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d31355.769673958534!2d106.67776287966731!3d10.775176369887062!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752f38f9ed887b%3A0x14aded5703768989!2zUXXhuq1uIDEsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1697898273223!5m2!1svi!2s" width="100%" height="500" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
          </div>
        </div>
      </div>
    </div>
  </div>
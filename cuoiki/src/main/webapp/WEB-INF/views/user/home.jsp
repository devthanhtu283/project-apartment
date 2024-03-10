<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <div class="main-banner">
    <div class="owl-carousel owl-banner">
      <div class="item item-1">
        <div class="header-text">
          <span class="category"><em>CĂN HỘ CỦA CHÚNG TÔI</em></span>
          <h2>ApaRTMENT!<br>Cung cấp những căn hộ cao cấp nhất!</h2>
        </div>
      </div>
      <div class="item item-2">
        <div class="header-text">
          <span class="category"><em>CÁC CĂN HỘ KHÁC</em></span>
          <h2>Chúng tôi<br>cung cấp các căn hộ cao cấp, uy tín khác!</h2>
        </div>
      </div>
      <div class="item item-3">
        <div class="header-text">
          <span class="category"><em>SÀN MÔI GIỚI</em></span>
          <h2>Sàn môi giới<br>kí gửi các căn hộ của bạn!</h2>
        </div>
      </div>
     
    </div>
  </div>

  <div class="featured section">
    <div class="container">
      <div class="row">
        <div class="col-lg-4">
          <div class="left-image">
            <img src="${pageContext.request.contextPath}/assets/user/images/featured.jpg" alt="">
             <a href="${pageContext.request.contextPath}/userapartmentdetails"><img src="${pageContext.request.contextPath}/assets/user/images/featured-icon.png" alt="" style="max-width: 60px; padding: 0px;"></a>
          </div>
        </div>
        <div class="col-lg-5">
          <div class="section-heading">
            <h6>| Về Apartment</h6>
            <h2>Dịch vụ cung cấp căn hộ tốt nhất</h2>
          </div>
          <div class="accordion" id="accordionExample">
            <div class="accordion-item">
              <h2 class="accordion-header" id="headingOne">
                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                  *Các căn hộ của chúng tôi
                </button>
              </h2>
              <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                Chúng tôi <strong>chuyên cung cấp và quản lý</strong> các căn hộ cao cấp trên địa bàn TP. Hồ Chí Minh.  <span style="color: blue;">Phân phối và quản lý hơn 100 căn hộ thuộc hệ thống Apartment, </span>bước đệm đầu tiên trong tầm nhìn chiến lược vươn tầm quốc tế của Apartment.</div>
              </div>
            </div>
            <div class="accordion-item">
              <h2 class="accordion-header" id="headingTwo">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                  * Cung cấp những căn hộ khác.
                </button>
              </h2>
              <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                  Ngoài ra, chúng tôi còn cung cấp các căn hộ khác từ những người bán uy tín trên địa bàn TP. Hồ Chí Minh.
                </div>
              </div>
            </div>
            <div class="accordion-item">
              <h2 class="accordion-header" id="headingThree">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                  *Sàn môi giới, kí gửi bất động sản uy tín.
                </button>
              </h2>
              <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                  Chúng tôi cung cấp và tư vấn giải pháp quản lý – marketing căn hộ cao cấp trên địa bàn TP HCM. Hãy đăng ký tài khoản và cung cấp cho chúng tôi đầy đủ thông tin về dự án của quý khách.
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-3">
          <div class="info-table">
            <ul>
              <li>
                <img src="${pageContext.request.contextPath}/assets/user/images/info-icon-03.png" alt="" style="max-width: 52px;">
                <h4>Căn hộ<br>Cao cấp nhất</h4>
              </li>
              <li>
                <img src="${pageContext.request.contextPath}/assets/user/images/info-icon-01.png" alt="" style="max-width: 52px;">
                <h4>Trên khắp<br>TPHCM</h4>
              </li>
              <li>
                <img src="${pageContext.request.contextPath}/assets/user/images/info-icon-04.png" alt="" style="max-width: 52px;">
                <h4>An toàn<br>Và uy tín</h4>
              </li>
            
              
              <li>
                <img src="${pageContext.request.contextPath}/assets/user/images/info-icon-02.png" alt="" style="max-width: 52px;">
                <h4>Hợp đồng<br>Nhanh chóng</h4>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="video section">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 offset-lg-4">
          <div class="section-heading text-center">
            <h6>| Video Căn Hộ</h6>
            <h2>Xem video chi tiết về căn hộ của chúng tôi</h2>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="video-content">
    <div class="container">
      <div class="row">
        <div class="col-lg-10 offset-lg-1">
          <div class="video-frame">
            <img src="${pageContext.request.contextPath}/assets/user/images/video-frame.jpg" alt="">
            <a href="https://www.youtube.com/watch?v=nM2PWSDaQhE" target="_blank"><i class="fa fa-play"></i></a>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="fun-facts">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="wrapper">
            <div class="row">
              <div class="col-lg-4">
                <div class="counter">
                  <h2 class="timer count-title count-number" data-to="5" data-speed="1000"></h2>
                   <p class="count-text ">HỆ THỐNG TRÊN TP.HCM<br></p>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="counter">
                  <h2 class="timer count-title count-number" data-to="12" data-speed="1000"></h2>
                  <p class="count-text ">NĂM THÀNH LẬP</p>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="counter">
                  <h2 class="timer count-title count-number" data-to="24" data-speed="1000"></h2>
                  <p class="count-text ">GIẢI THƯỞNG</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="section best-deal">
    <div class="container">
      <div class="row">
        <div class="col-lg-4">
          <div class="section-heading">
            <h6>| Về chúng tôi</h6>
            <h2>Tìm ngay bây giờ!</h2>
          </div>
        </div>
        <div class="col-lg-12">
          <div class="tabs-content">
            <div class="row">
              <div class="nav-wrapper ">
                <ul class="nav nav-tabs" role="tablist">
                  <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="appartment-tab" data-bs-toggle="tab" data-bs-target="#appartment" type="button" role="tab" aria-controls="appartment" aria-selected="true">Chi Nhánh</button>
                  </li>
                  <li class="nav-item" role="presentation">
                    <button class="nav-link" id="villa-tab" data-bs-toggle="tab" data-bs-target="#villa" type="button" role="tab" aria-controls="villa" aria-selected="false">Căn Hộ</button>
                  </li>
                  <li class="nav-item" role="presentation">
                    <button class="nav-link" id="penthouse-tab" data-bs-toggle="tab" data-bs-target="#penthouse" type="button" role="tab" aria-controls="penthouse" aria-selected="false">Sàn cung cấp</button>
                  </li>
                </ul>
              </div>              
              <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="appartment" role="tabpanel" aria-labelledby="appartment-tab">
                  <div class="row">
                    <div class="col-lg-3">
                      <div class="info-table">
                        <ul>
                          <li>123, Nguyễn Văn Cừ <span>Quận 1</span></li>
                          <li>456, Hoàng Văn Thụ <span>Quận 2</span></li>
                          <li>35, Hoàng Diệu <span>Quận 3</span></li>
                          <li>11, võ Văn Ngân <span>Quận 4</span></li>
                          <li>88, Hoàng Hoa Thám <span>Quận 5</span></li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <img src="${pageContext.request.contextPath}/assets/user/images/ban-do-tphcm.jpg" alt="">
                    </div>
                    <div class="col-lg-3">
                      <h4>Apartment - Hệ thống cung cấp căn hộ/chung cư cao cấp</h4>
                      <p>Phân phối hơn 100 căn hộ/chung cư cao cấp trên địa bàn thành phố Hồ Chí Minh, bước đệm đầu tiên trong tầm nhìn chiến lược vươn tầm quốc tế của Apartment
                      <br><br>Chúng tôi có 5 hệ thống/chi nhánh Apartment trên địa bàn thành phố Hồ Chí Minh và nhiều căn hộ/ chung cư cao cấp khác từ các người môi giới.</p>
                      <div class="icon-button">
                        <a href="${pageContext.request.contextPath }/contact"><i class="fa fa-calendar"></i>Liên hệ</a>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="tab-pane fade" id="villa" role="tabpanel" aria-labelledby="villa-tab">
                  <div class="row">
                    <div class="col-lg-3">
                      <div class="info-table">
                        <ul>
                          <li>Diện tích: <span>Từ 250 m2</span></li>
                          <li>Số phòng ngủ <span>1-3 phòng</span></li>
                          <li>Số nhà vệ sinh <span>1-2 phòng</span></li>
                          <li>Nội thất <span>Đầy đủ</span></li>
                          <li style="color: red;">Giá <span style="color: red;">Chỉ từ 1 tỷ</span></li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <img src="${pageContext.request.contextPath}/assets/user/images/deal-02.jpg" alt="">
                    </div>
                    <div class="col-lg-3">
                      <h4>Mô tả chi tiết</h4>
                      <p>Mỗi hệ thống/chi nhánh Apartment sẽ có 5 tầng, 1 tầng sẽ có 5 phòng với đầy đủ tiện nghi khép kín(siêu thị, hồ bơi, phòng gym, nhà thuốc, cafe, ..)<br><br>Các căn hộ/chung cư trong 1 hệ thống tất cả đều chung 1 thiết kế và full nội thất, thang máy, sảnh lễ tân, hầm xe, bảo vệ 24/7, ở từ 2-4 người, cho nuôi pet. Liên hệ để biết thêm thông tin.</p>
                      <div class="icon-button">
                        <a href="${pageContext.request.contextPath }/systemapartment"><i class="fa fa-calendar"></i> Xem thêm chi tiết</a>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="tab-pane fade" id="penthouse" role="tabpanel" aria-labelledby="penthouse-tab">
                  <div class="row">
                    <div class="col-lg-3">
                      <div class="info-table">
                        - Bạn cần phải cung cấp đầy đủ thông tin về căn hộ của bạn theo mẫu có sẵn như địa chỉ/ vị trí, mô tả (giá tiền, số phòng ngủ, số phòng vệ sinh, ban công,..), các dịch vụ, tiện ích liên quan, thông tin cá nhân, thông tin liên lạc,...
                        <br>
                        - Các giấy tờ pháp lý liên quan nếu bạn là chủ sở hữu, còn nếu bạn là người môi giới thì cần cung cấp được thông tin liên lạc với chủ sở hữu hoặc giấy ủy quyền mua bán nhà đất, ...
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <img src="${pageContext.request.contextPath}/assets/user/images/deal-03.jpg" alt="">
                    </div>
                    <div class="col-lg-3">
                      <h4>Dịch vụ kí gửi/môi giới căn hộ/chung cư</h4>
                      <p>Chúng tôi cung cấp và tư vấn giải pháp quản lý – marketing căn hộ dịch vụ và phòng cao cấp cho thuê trên địa bàn TP HCM. <br><br>Cung cấp cho chúng tôi đầy đủ thông tin về dự án của quý khách, chuyên viên của chúng tôi sẽ tổng hợp tất cả các thông tin của quý khách từ đó xây dựng kế hoạch marketing, quảng cáo và chăm sóc HOÀN TOÀN MIỄN PHÍ căn hộ của quý khách trong vòng 24h kể từ khi nhận được yêu cầu ký gửi.</p>
                      <div class="icon-button">
                        <a href="${pageContext.request.contextPath }/postapartment"><i class="fa fa-calendar"></i> Ký gửi ngay!</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="properties section">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 offset-lg-4">
          <div class="section-heading text-center">
            <h6>| Các căn hộ khác</h6>
            <h2>Các căn hộ cao cấp khác</h2>
          </div>
        </div>
      </div>
      <div class="row">
      <c:forEach var="post" items="${posts }">
       <div class="col-lg-4 col-md-6">
          <div class="item">
             <a href="${pageContext.request.contextPath}/userapartmentdetails?id=${post.id}"><img src="${pageContext.request.contextPath}/assets/user/images/150canho/${post.avatar}" alt=""></a>
            <span class="category">Căn hộ</span>
            <h6>3 tỷ VNĐ</h6>
             <h4><a href="${pageContext.request.contextPath}/userapartmentdetails?id=${post.id}">${post.subject}</a></h4>
            <ul>
              <li>Phòng ngủ: <span>${post.bedroom}</span></li>
              <li>Phòng tắm: <span>${post.bathroom}</span></li>
              <li>Diện tích: <span>${post.area} m2</span></li>
              <li>Ngày đăng: <span><f:formatDate value="${post.postdate }"
													pattern="dd-MM-yyyy" var="postdate" /> ${postdate }</span></li>
              <li>Địa chỉ: <span>${post.address}</span></li>
            </ul>
            <div class="main-button">
              <a href="${pageContext.request.contextPath}/userapartmentdetails?id=${post.id}">Chi tiết</a>
            </div>
          </div>
        </div> 
      </c:forEach>
      	
      
          </div>
        </div>
      </div>


  <div class="contact section">
    <div class="container">
      <div class="row">
        <div class="col-lg-4 offset-lg-4">
          <div class="section-heading text-center">
            <h6>| Hãy để lại đánh giá của bạn</h6>
            <h2>Để chúng tôi hoàn thiện hơn</h2>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="contact-content">
    <div class="container">
      <div class="row">
        <div class="col-lg-7">
          <div id="map">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d31355.769673958534!2d106.67776287966731!3d10.775176369887062!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752f38f9ed887b%3A0x14aded5703768989!2zUXXhuq1uIDEsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1697898273223!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
          </div>
          <div class="row">
            <div class="col-lg-6">
              <div class="item phone">
                <img src="${pageContext.request.contextPath}/assets/user/images/phone-icon.png" alt="" style="max-width: 52px;">
                <h6>18001515<br><span>Đường dây nóng</span></h6>
              </div>
            </div>
            <div class="col-lg-6">
              <div class="item email">
                <img src="${pageContext.request.contextPath}/assets/user/images/email-icon.png" alt="" style="max-width: 52px;">
                <h6>apart@gmail.com<br><span>Email</span></h6>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-5">
          <form id="contact-form" action="${pageContext.request.contextPath }/home?action=submitFeedback" method="post" accept-charset="UTF-8" >
            <div class="row">
              <div class="col-lg-12">
                <fieldset>
                  <label for="name">Họ và tên</label>
                  <input type="name" name="name" id="name" placeholder="Nhập tên của bạn..." autocomplete="on" required>
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <label for="email">Email của bạn</label>
                  <input type="text" name="email" id="email" pattern="[^ @]*@[^ @]*" placeholder="Nhập thư điện tử ..." required>
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <label for="subject">Tiêu đề</label>
                  <input type="subject" name="subject" id="subject" placeholder="Tiêu đề" autocomplete="on" >
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <label for="message">Đánh giá</label>
                  <textarea name="message" id="message" placeholder="Đánh giá của bạn"></textarea>
                </fieldset>
              </div>
              <div class="col-lg-12">
                <fieldset>
                  <button type="submit" id="form-submit" class="orange-button">Gửi</button>
                </fieldset>
                <br>
                 <%
                	HttpSession session1 = request.getSession();
                	String success = (String) session1.getAttribute("msg");
                	String success1 = success;               	
                	session1.removeAttribute("msg");
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
      </div>
    </div>
  </div>
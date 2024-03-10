<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <div class="featured section">
    <div class="container" style="margin-top: -50px;">
      <div class="row">
        <%
	HttpSession session2 = request.getSession();
	String errorAccount = (String) session2.getAttribute("msg");
	String errorAccount1 = errorAccount;
	session2.removeAttribute("msg");
%>
 		<%
            	if(errorAccount1 != null) {
            		
        %>
            <script>
				alert("<%= errorAccount1 %>");
            </script> 
            <%} %>
        <div class="col-lg-4">
          <div class="card mb-4 mb-xl-0">
            <div class="card-header">Ảnh đại diện</div>
            <div class="card-body text-center">
               <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/account">
                <!-- Profile picture image-->
                <img id="imgAvatar" class="img-account-profile rounded-circle mb-2" src="${pageContext.request.contextPath }/assets/user/images/${sessionScope.accountdetails != null ? sessionScope.accountdetails.avatar : "" }" alt="">
                <!-- Profile picture help block-->
                <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                <!-- Profile picture upload button-->
                <input  type="file" name="file" accept="image/*" id="inputAvatar">
                <label for="inputAvatar" class="custom-upload-btn"><i class="fa-solid fa-arrow-up-from-bracket"></i> &nbsp; Tải lên</label>
                <script>
                  $(document).ready(function(){
                    $('#inputAvatar').change( function() {
                var tmppath = URL.createObjectURL(event.target.files[0]);
                    
                    $("#imgAvatar").attr('src',tmppath);       
                });
                  });
                </script>
            </div>
        </div>
        </div>
          
        <div class="col-lg-8">
          <div class="card mb-4">
            <div class="card-header d-flex justify-content-between">
              <span>Cập nhật thông tin tài khoản ...</span>
              <a href="${pageContext.request.contextPath }/login?action=logout"> <i style="font-size: 20px;" class="fa-solid fa-right-from-bracket"></i></a>
            </div>
            <div class="card-body">
       
                    <!-- Form Group (username)-->
                    <div class="mb-3">
                        <label class="small mb-1" for="inputUsername"><span style="color: red;">*</span> Họ và tên </label>
                        <input class="form-control" name="fullName" id="inputUsername" value="${sessionScope.accountdetails != null ? sessionScope.accountdetails.name : "" }" type="text" placeholder="Nhập họ và tên" required>
                    </div>
                    <div class="mb-3">
                      <label class="small mb-1" for="inputPassword">Mật khẩu mới</label>
                      <input class="form-control" name="newPass" id="inputPassword"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,}" type="password" placeholder="Nhập mật khẩu mới">
                  </div>
                  <div class="mb-3">
                    <label class="small mb-1" for="inputUsername">Xác nhận mật khẩu</label>
                    <input class="form-control" name="confirm" id="inputConfirmPassword" type="password" placeholder="Nhập lại mật khẩu của bạn">
                  </div>
                  <script>
                    var password = document.getElementById("inputPassword")
                      , confirm_password = document.getElementById("inputConfirmPassword");

                    function validatePassword(){
                      if(password.value != confirm_password.value) {
                        confirm_password.setCustomValidity("Passwords Don't Match");
                      } else {
                        confirm_password.setCustomValidity('');
                      }
                    }

                    password.onchange = validatePassword;
                    confirm_password.onkeyup = validatePassword;
                  </script>
                  <div class="mb-3">
                    <label class="small mb-1" for="inputAddress"><span style="color: red;">*</span> Địa chỉ</label>
                    <input class="form-control" name="address" id="inputAddress" type="text" value="${sessionScope.accountdetails != null ? sessionScope.accountdetails.address : "" }" placeholder="Nhập địa chỉ" required>
                </div>
                    <!-- Form Group (email address)-->
                    <div class="mb-3">
                        <label class="small mb-1" for="inputEmailAddress">Email</label>
                        <input class="form-control" name="email" pattern="[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$" id="inputEmailAddress" type="email" placeholder="Nhập email">
                    </div>
                    <!-- Form Row-->
                    <div class="row gx-3 mb-3">
                        <!-- Form Group (phone number)-->
                        <div class="col-md-6">
                            <label class="small mb-1" for="inputPhone"><span style="color: red;">*</span> Số điện thoại</label>
                            <input class="form-control" value="${sessionScope.accountdetails != null ? sessionScope.accountdetails.phonenumber : "" }" name="phoneNumber" id="inputPhone" pattern="(\(\+[0-9]{2}\)|0)([0-9]{9,10})" type="tel" placeholder="Nhập số điện thoại của bạn" required>
                        </div>
                        <!-- Form Group (birthday)-->
                        <div class="col-md-6">
                            <label class="small mb-1" for="inputBirthday"><span style="color: red;">*</span> Ngày sinh</label>
                            <f:formatDate value="${sessionScope.accountdetails.birthday }" pattern="dd/MM/yyyy" var="birthday" />
                            <input class="form-control" id="datepicker" value="${sessionScope.accountdetails != null ? birthday : "" }"  type="text" name="birthday" placeholder="Nhập ngày sinh" required>
                        </div>
                    </div>
                    <!-- Save changes button-->
                  <button class="btn btn-primary" type="submit">Cập nhật</button>
               </form>
            </div>
        </div>
         
        </div>
      </div>
    </div>
  </div>

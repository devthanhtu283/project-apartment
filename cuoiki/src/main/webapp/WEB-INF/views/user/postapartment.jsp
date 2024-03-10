<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
  <div class="page-heading header-text">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <span class="breadcrumb"><a href="${pageContext.request.contextPath }/home">Trang chủ</a></span>
          <h3>Ký gửi căn hộ</h3>
        </div>
      </div>
    </div>
  </div>
 
  <!-- ***** Header Area End ***** -->
  <div class="featured section">
    <div class="container" style="margin-top: -50px;">
      <div class="row">
        <div class="col-lg-8">
          <div class="card mb-4">
            <div class="card-header d-flex justify-content-between">
              <span>Bài đăng</span>
              <button class="btn" style="background-color: #f35525; "><a style="color: white;" 
              href="${pageContext.request.contextPath}/mypost">Xem bài viết đã đăng</a></button>
            </div>
            
           
            <div class="card-body">
                <form method="post" action="${pageContext.request.contextPath}/postapartment" enctype="multipart/form-data">
                    <!-- Form Group (username)-->
                    <div class="mb-3">
                        <label class="small mb-1" for="inputUsername">Tiêu đề</label>
                        <input class="form-control" name="subject" id="inputUsername" type="text" placeholder="Nhập tiêu đề" required>
                    </div>
                    <div class="mb-3">
                      <label class="small mb-1" for="inputUsername">Giá (tỷ đồng)</label>
                      <input class="form-control" id="inputUsername" step="0.1" name="price" type="number" placeholder="Nhập giá" required>
                  </div>
                  <div class="mb-3">
                      <label class="small mb-1" for="inputUsername">Đặt cọc (triệu đồng)</label>
                      <input class="form-control" id="inputUsername" step="0.1" name="deposit" type="number" placeholder="Nhập giá" required>
                  </div>
                  <div class="row gx-3 mb-3">
                    <!-- Form Group (phone number)-->
                    <div class="col-md-6">
                        <label class="small mb-1" for="inputPhone">Số phòng ngủ</label>
                        <input class="form-control" name="bedroom" id="inputPhone" min="1" max="3" type="number" placeholder="Nhập số phòng ngủ" required>
                    </div>
                    <!-- Form Group (birthday)-->
                    <div class="col-md-6">
                      <label class="small mb-1" for="inputPhone">Số phòng tắm</label>
                      <input class="form-control" name="bathroom" id="inputPhone" min="1" max="3" type="number" placeholder="Nhập số phòng tắm" required>
                  </div>
                </div>
                <div class="row gx-3 mb-3">
                  <!-- Form Group (phone number)-->
                  <div class="col-md-6">
                      <label class="small mb-1" for="inputPhone">Địa chỉ</label>
                      <input class="form-control" name="address" id="inputPhone" type="text" placeholder="Nhập địa chỉ" required>
                  </div>
                  <!-- Form Group (birthday)-->
                  <div class="col-md-6">
                    <label class="small mb-1" for="inputPhone">Diện tích (mét vuông)</label>
                    <input class="form-control" name="area" id="inputPhone" min="1" step="0.1" type="number" placeholder="Nhập diện tích căn hộ" required>
                </div>
              </div>
              
                  <div class="mb-3">
                    <label class="small mb-1" for="inputUsername">Mô tả</label>
                    <br>
                    <textarea class="form-control" name="description" id="inputUsername" cols="30" rows="10" required></textarea>
                </div>
             
                
                    <!-- Save changes button-->
                    <input class="btn btn-primary" type="submit" value="Đăng bài">
              
            </div>
        </div>
         
        </div>
        <div class="col-lg-4">
          <div class="card mb-4 mb-xl-0">
            <div class="card-header">Ảnh căn hộ</div>
            <div class="card-body text-center">
              <div class="small font-italic text-muted mb-2"><span id="msg">File hình không quá 5MB</span></div>
              <div class="small font-italic text-muted mb-4"><span id="msg">Chỉ được phép tối đa 4 ảnh</span></div>
                <!-- Profile picture image-->
                <div id="pictures" style="max-height: 300px; overflow: auto ;">
                    
                </div>
                <!-- Profile picture help block-->
              
                <!-- Profile picture upload button-->
                <input style="margin-left: 100px;"  type="file" name="files" multiple="multiple" required accept="image/*" id="inputAvatar">
                <label style="margin-top: 5px;" for="inputAvatar" class="custom-upload-btn"><i class="fa-solid fa-arrow-up-from-bracket"></i> &nbsp; Tải lên</label>
                <script>
                  $(document).ready(function(){
                    var src = [];
                      $('#inputAvatar').change( function(event) {
                        if(event.target.files.length > 4){
                           alert('Chỉ được chọn tối đa 4 tấm hình');
                           location.reload();
                        } else {
                          for (var i = 0; i <  event.target.files.length; i++) {
                        console.log(event.target.files[i].name);
                        src[i] = URL.createObjectURL(event.target.files[i]);
                        $('<img src="' + src[i] + '" height="200" style="margin-top: 5px"/> ').appendTo('#pictures');
                        console.log(src[i]);
                    
                      }
                        }
                    
                      
                       
                });
                    
                   /*  $('<p>Thành phần p</p>').appendTo('#div'); */
                   
                  });
                </script>
            </div>
        </div>
        </div>
      </form>
        <!-- <div class="col-lg-3">
          <div class="info-table">
            <ul>
              <li>
                <img src="assets/images/info-icon-03.png" alt="" style="max-width: 52px;">
                <h4>Căn hộ<br>Cao cấp nhất</h4>
              </li>
              <li>
                <img src="assets/images/info-icon-01.png" alt="" style="max-width: 52px;">
                <h4>Trên khắp<br>TPHCM</h4>
              </li>
              <li>
                <img src="assets/images/info-icon-04.png" alt="" style="max-width: 52px;">
                <h4>An toàn<br>Và uy tín</h4>
              </li>
            
              
              <li>
                <img src="assets/images/info-icon-02.png" alt="" style="max-width: 52px;">
                <h4>Hợp đồng<br>Nhanh chóng</h4>
              </li>
            </ul>
          </div>
        </div> -->
      </div>
    </div>
  </div>

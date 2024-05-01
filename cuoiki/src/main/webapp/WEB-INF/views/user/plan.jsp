<%@page import="com.demo.models.InvoiceModel"%>
<%@page import="com.demo.entities.Account"%>
<%@page import="com.demo.entities.Invoice"%>
<%@page import="com.demo.models.ServiceModel"%>
<%@page import="com.demo.entities.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	HttpSession httpSession = request.getSession();
	ServiceModel serviceModel = new ServiceModel();
	InvoiceModel invoiceModel = new InvoiceModel();
	Account account = (Account)  httpSession.getAttribute("account") == null ? new Account() : (Account)  httpSession.getAttribute("account");
	Invoice invoice = invoiceModel.findByID(account.getId(), true);
	int serviceId = (invoice != null) ? invoice.getServiceId() : 0;
	String msg = (String) httpSession.getAttribute("msg");
	String msg1 = msg;
	httpSession.removeAttribute("msg");
%>
<c:if test="<%= msg1 != null %>">
	<script>
		alert('<%=msg1 %>')
	</script>
</c:if>
<style>
.popup-container, .popup-container-vnpay {
	display:none;
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
    z-index: 1001;
    max-width: 400px;
    width: 90%; 
    text-align: center; 
}

.popup-container h1 {
    font-size: 24px;
    margin-bottom: 20px;
}
.close-button {
    position: absolute;
    top: 0px;
    right: 2px;
    background-color: transparent;
    border: none;
    font-size: 20px;
    cursor: pointer;
    outline: none;
}

.popup-content {
    display: flex;
    justify-content: center;
}

.payment-option {
    cursor: pointer;
    margin: 10px;
    padding: 10px;
    border-radius: 5px;
    transition: all 0.3s;
    width: 150px; 
}

.payment-option:hover {
    transform: translateY(-5px);
}

.payment-option img {
    width: 100%;
    height: auto;
    border-radius: 5px;
}

</style>
	<script>
		$(document).ready(function() {
			$('#rechargeBtn').click(function() {
				$('.popup-container').css('display','block');
			})
			$('.payment-option').click(function() {
				$('.popup-container-vnpay').css('display','block');
				$('.popup-container').css('display','none');
			})
		});

		function closePopup() {
		    var popup = document.querySelector('.popup-container');
		    var popupvnpay = document.querySelector('.popup-container-vnpay');
		    popup.style.display = 'none';
		    popupvnpay.style.display = 'none';
		}
	</script>
	<br>
	<br>
	<%-- <form action="${pageContext.request.contextPath}/payment" method="post">
		<input type="number" name="amount">
		<input type="submit" value="Submit">
	</form> --%>
	<div class="container">
		<div>
			<button id="rechargeBtn" class="btn btn-primary mx-3">Nạp tiền</button>
		</div>
	</div>
	
<div class="wrapper">
		<div class="pricing-content">
			<div class="PageWidth">
				<div class="pricing-detail-content">
			
				<div class="pricing-content-items-tabs">
					<div class="pricing-yearly" style="display: flex;">
					<% for(Service service : serviceModel.findAll()) {%>
					<div class="pricing-item">
						<div class="pricing-item-box">
						<c:if test="<%= serviceId  == service.getId() %>">
							<span class="ribbon"></span>
						</c:if>
						<div class="plan-name"><%= service.getName() %></div>
						<div class="plan-text"><%= service.getIntroduction() %></div>

						<div class="plan-price-content">
							<div class="plan-price"><%= service.getPrice() %> VND <span class="month-text"> / tháng</span></div>
							
						</div>

						<div class="plan-features">
							<div class="plan-feature-item"><%= service.getDescription() %></div>
							
						</div>

						<div class="plan-button"><a href="${pageContext.request.contextPath }/plan?action=buy&id=<%= service.getId()%>">Mua ngay</a></div>
						</div>
					</div>
	               <% } %>


				</div>			
			</div>
			</div>
	

	
		</div>
		</div>
		
	</div>
	
 
    <!-- Popup -->
	<div class="popup-container">
	<h1>Vui lòng chọn phương thức thanh toán</h1>
	<button class="close-button" onclick="closePopup()">x</button>
    <div class="popup-content">
        <div class="payment-option" id="vnpay-option">
            <img src="${pageContext.request.contextPath }/assets/user/images/vnpay-logo.jpg" alt="VNPAY Logo">
        </div>
        <div class="payment-option" id="paypal-option">
            <img src="${pageContext.request.contextPath }/assets/user/images/paypal-logo.webp" alt="PayPal Logo">
        </div>
    </div>
    </div>
    
    <div id="vn-pay" class="popup-container-vnpay" style="display: none">
	<h1>Vui lòng nhập số tiền</h1>
	<button class="close-button" onclick="closePopup()">x</button>
    <div class="popup-content">
       <form action="${pageContext.request.contextPath }/payment" method="POST">
       		<div class="input-group mb-3">
			  <input type="text" class="form-control" name="amount" placeholder="Nhập số tiền" required>
			  <div class="input-group-append">
			    <span class="input-group-text">VND</span>
			  </div>
			</div>
       		<input type="submit" class="btn btn-primary" value="Nạp tiền">
       </form>
    </div>
    </div>
<script type="text/javascript">
	$(document).ready(function(){
  $("#tab1").click(function(){
  
   $('.pricing-monthly').addClass('active-tab-content');
   $('.pricing-yearly').hide();
   $(this).addClass('tab-active');
     $('#tab2').removeClass('tab-active');
 
  });
 $("#tab2").click(function(){
  
   $('.pricing-monthly').removeClass('active-tab-content');
   $('.pricing-yearly').show();
  $(this).addClass('tab-active');
     $('#tab1').removeClass('tab-active');
  });


  });


</script>

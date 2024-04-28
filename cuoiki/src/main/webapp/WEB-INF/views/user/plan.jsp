<%@page import="com.demo.models.ServiceModel"%>
<%@page import="com.demo.entities.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	ServiceModel serviceModel = new ServiceModel();

%>
<body>
<div class="wrapper">
		<div class="pricing-content">
			<div class="PageWidth">
				<div class="pricing-detail-content">
			
				<div class="pricing-content-items-tabs">
					<div class="pricing-yearly">
					<% for(Service service : serviceModel.findAll()) {%>
					<div class="pricing-item">
						<div class="pricing-item-box">
						<div class="plan-name"><%= service.getName() %></div>
						<div class="plan-text"><%= service.getIntroduction() %></div>

						<div class="plan-price-content">
							<div class="plan-price"><%= service.getPrice() %> VND <span class="month-text"> / 6 tháng</span></div>
							
						</div>

						<div class="plan-features">
							<div class="plan-feature-item"><%= service.getDescription() %></div>
							
						</div>

						<div class="plan-button"><a href="">Mua ngay</a></div>
						</div>
					</div>
	               <% } %>


				</div>			
			</div>
			</div>
	

	
		</div>
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


</body>
</html>
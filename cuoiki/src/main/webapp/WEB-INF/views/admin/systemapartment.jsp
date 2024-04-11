<%@page import="com.demo.entities.Chat"%>
<%@page import="com.demo.models.AccountDetailsModel"%>
<%@page import="com.demo.models.ChatModel"%>
<%@page import="com.demo.entities.Systemapartment"%>
<%@page import="com.demo.models.BranchModel"%>
<%@page import="com.demo.models.SystemApartmentModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
 	ChatModel chatModel = new ChatModel();
 	AccountDetailsModel accountDetailsModel = new AccountDetailsModel();
 %>
 <style>
 	.userTR{
 		cursor: pointer;
 	}
 	.backgroundTR {
 		background-color: navy;
 	}
 	
 	
 </style>
  <script>
  var userID = 0;
  $(document).ready(function(){
		var i = 1;
		var j = 1;
		$('#button').click(function(){
			
			$('#chatAdmin').append(
				'<tr>' + 
					'<td id="td' + (i++) + '1">' + 
						'Aaaa'
					+'</td>' +
					'<td id="td' + (j++) + '2">' + 
						'Aaaa'
					+'</td>'
					
				+'</tr>' 
			);
		});
		$('.userTR').click(function() {
			userID = $(this).attr('data-id');
			$('.userTR').removeClass('backgroundTR');
			$(this).addClass('backgroundTR');
			console.log(userID);
		});
		
	});
        var socket = new WebSocket("ws://localhost:8080/projectGroup2/chat");
        
        socket.onmessage = function(event) {
        	var i = 1;
     		var j = 1;
            var message = event.data;
            $('#chatAdmin').append(
     				'<tr>' + 
     					'<td id="td' + (i++) + '1">' + 
     						message.replace("-USER21042003" + "-" + userID  , "")
     					+'</td>' +
     					'<td id="td' + (j++) + '2">' + 
     						''
 						+'</td>'
     					
     				+'</tr>' 
     			);
            
          
        };

        function sendMessage() {
        	var i = 1;
     		var j = 1;
            var message = $("#message").val();
            socket.send(message + "-ADMIN21042003" + "-" + userID);
            $("#message").val("");
            $('#chatAdmin').append(
     				'<tr>' + 
     					'<td id="td' + (i++) + '1">' + 
     						''
     					+'</td>' +
     					'<td id="td' + (j++) + '2">' + 
     					message
 						+'</td>'
     					
     				+'</tr>' 
     			);
            
            
        }
        
     	
    </script>
  <style>
    /* Custom CSS */
   
    tr{
    	height: 70px;
    }
    td{
    	width:270px;
    }
  </style>
   <div class="content-wrapper">
<div class="container">
	
  <div class="row">
  	<div class="col-4" style="height: 100%;   border: 1px solid #ccc;">
  		<div>
  			<table >
  			
  			<% for(Chat chat : chatModel.listUser()) { %>
  				<tr class="userTR"  data-id="<%= chat.getUserID() %>">
  					<td ><img style="border-radius: 50%; margin-right: 10px;" src="${pageContext.request.contextPath }/assets/user/images/<%= accountDetailsModel.findAccountByAccountID(chat.getUserID()).getAvatar() %>" height="50" width="50"><%= accountDetailsModel.findAccountByAccountID(chat.getUserID()).getName() %></td>
  				</tr>
  			<% } %>
  			
  		</table>
  		</div>
  	</div>
  	<div class="col-2"></div>
  	
  	
  		<div class="col-6" style="border: 1px solid #ccc;">
  			<table id="chatAdmin">
  			
  			</table>
  		</div>
  	
  </div>
  <br>
  <br>
</div>
   	
    <input type="text" id="message" placeholder="Type your message">
    <button onclick="sendMessage()">Send</button>
</div>
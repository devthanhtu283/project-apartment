<%@page import="com.demo.models.ChatModel"%>
<%@page import="com.demo.entities.Chat"%>
<%@page import="com.demo.entities.Account"%>
<%@page import="com.demo.entities.Systemapartment"%>
<%@page import="com.demo.models.BranchModel"%>
<%@page import="com.demo.models.SystemApartmentModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
 	HttpSession httpSession = request.getSession();
 	Account account = null;
 	if(httpSession.getAttribute("account") != null){
 		account = (Account) httpSession.getAttribute("account");
 	}
 	ChatModel chatModel = new ChatModel();
 	int n = 0;
 %>
  <script>
        var socket = new WebSocket("ws://localhost:8080/projectGroup2/chat");
        
        socket.onmessage = function(event) {
        	var i = 1;
     		var j = 1;
            var message = event.data;
            $('#tableMSG').append(
     				'<tr>' + 
     					'<td  id="td' + (i++) + '1">' + 
     						message.replace("-ADMIN21042003" + "-" + <%= account != null ? account.getId() : 0%>, "")
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
            socket.send(message + "-USER21042003" + "-" + <%= account != null ? account.getId() : 0%>);
            $("#message").val("");
            $('#tableMSG').append(
     				'<tr>' + 
     					'<td id="td' + (i++) + '1">' + 
     						''
     					+'</td>' +
     					'<td style="text-align: right;"  id="td' + (j++) + '2">' + 
     					message
 						+'</td>'
     					
     				+'</tr>' 
     			);
            
            
        }
        
     	$(document).ready(function(){
     	
     		var i = 1;
     		var j = 1;
     		$('#button').click(function(){
     			
     			$('#tableMSG').append(
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
			var n = 0;
			var count = 0;
         	$('#buttonLoadMore').click(function() {
         		count++;
         		n = 7 * count;
         		$.ajax({
             		type: "GET",
             		url: "${pageContext.request.contextPath}/loadMoreMSG",
             		data: {
             			n : n
             		},
             		success: function(chats) {
						var s = '';
						for(var i = 0; i < chats.length; i++){
							s+= '<tr>';
								if(chats[i].role == 0){
									s+= '<td>' + chats[i].message + '- ' + chats[i].id + '</td>';
									s+= '<td></td>';
								}
								if(chats[i].role == 1){
									s+= '<td></td>';
									s+= '<td>' + chats[i].message + '- ' + chats[i].id + '</td>';
								}
							s+= '</tr>';
						}
						$('#tableMSG').html(s);
					}
             	});
			});
     	});

     	
     	
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
<br><br>
<div class="container">
  <div class="row">
    <div id="boxchat" class="col-6" style="border: 1px solid #ccc; height: 600px; overflow: auto;">
      <table id="chatAdmin" class="table table-bordered">
        <!-- Bảng chatAdmin -->
      </table>
    </div>
     <div class="col-6" style="border: 1px solid #ccc; height: 600px; overflow: auto;">
     <button id="buttonLoadMore">Load more msg</button>
      <button onclick="return location.reload();">Reload</button>
      <table id="tableMSG" class="table table-bordered">
	  		<%
	  		for(Chat chat : chatModel.findChatByUserID(account.getId(), n)){ %>
	  			<tr>
	  				<% if(chat.getRole() == 0) { %>
	  					<td>
	  						<%= chat.getMessage() %> - <%= chat.getId() %>
	  					</td>
	  					<td></td>
	  				<% } %>
	  				<% if(chat.getRole() == 1) { %>
	  					<td></td>
	  					<td><%= chat.getMessage() %> - <%= chat.getId() %> </td>
	  				<% } %>
	  			</tr>
	  		
  		<% } %>
  		
      </table>
    </div>
  </div>
</div>

<br><br>

<div class="container">
  <div class="row">
    <div class="col-6">
      <input type="text" id="message" class="form-control" placeholder="Type your message">
    </div>
    <div class="col-6">
      <button onclick="sendMessage()" class="btn btn-primary">Send</button>
    </div>
  </div>
</div>
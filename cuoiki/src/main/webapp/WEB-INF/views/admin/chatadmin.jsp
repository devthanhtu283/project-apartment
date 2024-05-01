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
			/* $.ajax({
				type: "GET",
				url: "${pageContext.request.contextPath}/admin/chatadmin",
				data: {
					userID: userID,
					action: 'loadMsg'
				},
				success: function(chat){
					var s = '';
					console.log(chat.length)
					for(var i = 0;i < chat.length;i++) {
						s+= '<tr>';
						if(chat[i].role == 0) {
							s+= '<td></td>';
							s+= '<td>' + chat[i].message +'</td>';
							console.log(chat[i].message);
						}
						if(chat[i].role == 1) {
							s+= '<td>' + chat[i].message +'</td>';
							s+= '<td></td>';
						}
						s+='</tr>';
					}
					$('#chatAdmin tbody').html(s);
				}
			}); */
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
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <table class="table">
                            <% for(Chat chat : chatModel.listUser()) { %>
                            <tr class="userTR" data-id="<%= chat.getUserID() %>">
                                <td>
                                    <img class="rounded-circle" src="${pageContext.request.contextPath }/assets/user/images/<%= accountDetailsModel.findAccountByAccountID(chat.getUserID()).getAvatar() %>" height="50" width="50" alt="User Avatar">
                                    <%= accountDetailsModel.findAccountByAccountID(chat.getUserID()).getName() %>
                                </td>
                            </tr>
                            <% } %>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-md-2"></div>
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <table id="chatAdmin" class="table">
                            
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <br><br>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="input-group">
                    <input type="text" id="message" class="form-control" placeholder="Type your message">
                    <div class="input-group-append">
                        <button onclick="sendMessage()" class="btn btn-primary">Send</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

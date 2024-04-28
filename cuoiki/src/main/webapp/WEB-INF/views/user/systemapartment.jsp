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
 
 %>
  <script>
        var socket = new WebSocket("ws://localhost:8080/projectGroup2/chat");
        
        socket.onmessage = function(event) {
        	var i = 1;
     		var j = 1;
            var message = event.data;
            $('#chatAdmin').append(
     				'<tr>' + 
     					'<td id="td' + (i++) + '1">' + 
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

<div class="container">
  <div class="row">
    <div id="boxchat" class="col-6" style="border: 1px solid #ccc; height: 500px; overflow: auto;">
      <table id="chatAdmin" class="table table-bordered">
        <!-- Bảng chatAdmin -->
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
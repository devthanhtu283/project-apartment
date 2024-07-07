<%@page import="com.demo.models.AccountDetailsModel"%>
<%@page import="com.demo.models.AccountModel"%>
<%@page import="com.demo.entities.Transaction"%>
<%@page import="com.demo.models.TransactionModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="com.demo.entities.Sale"%>
<%@page import="com.demo.models.SaleModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    TransactionModel transactionModel = new TransactionModel();
	AccountModel accountModel = new AccountModel();
	AccountDetailsModel accountDetailsModel = new AccountDetailsModel();
%>
<div class="content-wrapper">
    <!-- Tiêu đề nội dung -->
    <section class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-12">
                    <h1>Danh sách giao dịch</h1>
                </div>
            </div>
        </div><!-- /.container-fluid -->
    </section>
<script>
								$(document).ready(function() {
									$('#buttonReload').click(function() {
										location.reload();
									});
								});
							
							
							</script>
    <!-- Nội dung chính -->
    <section class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="card">
          
                        <!-- /.card-header -->
                        <div class="card-body">
                         
                            
                            <button id="buttonReload" class="btn"><i class="fa-solid fa-rotate"></i></button>
                            <table style="text-align: center;" id="example2" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Mã giao dịch</th>
                                        <th>Loại giao dịch</th>
                                        <th>Số tiền</th>
                                        <th>Thời gian giao dịch</th>
                                        <th>Tài khoản</th>
                                        <th>Chi tiết giao dịch</th>
                                        <th>Phương thức giao dịch</th>
                                
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for(Transaction transaction : transactionModel.findAll()){ %>
                                    	 <tr>
                                        <td><%= transaction.getTransactionNo() %></td>
                                        <td><%= transaction.getType() == 1 ? "Nạp tiền" : "Rút tiền" %></td>
                                        <td><%= transaction.getPrice() %> <%= transaction.getPaymentType().equals("ATM") ? "VND" : "$" %></td>
                                        <td><%= transaction.getDate()%></td>
                                        <td><%= transaction.getAccountID() %> - <%= accountDetailsModel.findAccountByAccountID(transaction.getAccountID()).getName() %></td>
                                        <td><%= transaction.getOrderInfo() %></td>
                                        <td><%= transaction.getPaymentType() %></td>
                                  
                                    </tr>
                                    <% } %>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
            </div>
        </div>
    </section>
    <!-- /.content -->
</div>

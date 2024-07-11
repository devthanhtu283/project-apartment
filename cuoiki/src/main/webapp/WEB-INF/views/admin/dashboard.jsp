<%@page import="com.demo.entities.Log"%>
<%@page import="com.demo.models.LogModel"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.demo.models.AccountDetailsModel"%>
<%@page import="com.demo.entities.Post"%>
<%@page import="com.demo.models.FeedbackModel"%>
<%@page import="com.demo.models.AccountModel"%>
<%@page import="com.demo.models.ContactModel"%>
<%@page import="com.demo.models.PostModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
		PostModel postModel = new PostModel();
		ContactModel contactModel = new ContactModel();
		AccountModel accountModel = new AccountModel();
		FeedbackModel feedbackModel = new FeedbackModel();
		AccountDetailsModel accountDetailsModel = new AccountDetailsModel();
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	LogModel logModel = new LogModel();
	%>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Trang chủ</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6"></div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<!-- Small boxes (Stat box) -->
			<div class="row">
				<div class="col-lg-3 col-12">
					<!-- small box -->
					<div class="small-box bg-info">
						<div class="inner">
							<h3><%= postModel.findAll().size() %></h3>

							<p>Tổng số bài đăng người dùng</p>
						</div>
						<div class="icon">
							<i class="ion fa-solid fa-pen" style="font-size: 60px; top: 28px"></i>
						</div>
						<a href="${pageContext.request.contextPath }/admin/postapartment"
							class="small-box-footer">Xem thêm <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-success">
						<div class="inner">
							<h3>
								<%= contactModel.findAll().size() %>
							</h3>

							<p>Tổng số liên hệ</p>
						</div>
						<div class="icon">
							<i class="ion fa-solid fa-envelope"
								style="font-size: 60px; top: 28px"></i>
						</div>
						<a href="${pageContext.request.contextPath }/admin/contact"
							class="small-box-footer">Xem thêm <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-warning">
						<div class="inner">
							<h3><%= accountModel.findAll().size() %></h3>

							<p>Tổng số người dùng</p>
						</div>
						<div class="icon">
							<i class="ion ion-person-add"></i>
						</div>
						<a href="${pageContext.request.contextPath }/admin/account"
							class="small-box-footer">Xem thêm <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-danger">
						<div class="inner">
							<h3><%= feedbackModel.findAll().size() %></h3>

							<p>Tổng số đánh giá</p>
						</div>
						<div class="icon">
							<i class="ion fa-solid fa-comment"
								style="font-size: 60px; top: 28px"></i>
						</div>
						<a href="${pageContext.request.contextPath }/admin/feedback"
							class="small-box-footer">Xem thêm <i
							class="fas fa-arrow-circle-right"></i></a>
					</div>
				</div>
				<!-- ./col -->
			</div>
			<!-- /.row -->
			<!-- Main row -->

			<!-- /.row (main row) -->
			<table id="example2" class="table table-bordered table-hover dataTable dtr-inline"
                          aria-describedby="example2_info">
                          <thead>
                            <tr>
                              <th>IP</th>
                              <th>Mô tả</th>
                              <th>Thời Gian</th>
                              <th>Level</th>
                              <th>Quốc Gia</th>
                              <th>Before Value</th>
                              <th>After Value</th>
                            </tr>
                          </thead>
                          <tbody>
                         
                        	<% for(Log log: logModel.findTop20Log()) { %>
                            <tr style="<%= log.getLevel().equalsIgnoreCase("danger") || log.getLevel().equalsIgnoreCase("warning") ? "color: red;" : "" %>">
                            	<td><%= log.getIp() %></td>
                            	<td><%= log.getDescription() %></td>
                            	<td><%= log.getTime() %></td>
                            	<td><%= log.getLevel() %></td>
                            	<td><%= log.getNational() %></td>
                            	<td><textarea class="form-control" rows="3" cols="1" disabled > <%= log.getBeforeValue() == null ? "" : log.getBeforeValue()%></textarea></td>
                            	<td><textarea class="form-control" rows="3" cols="1" disabled > <%= log.getAfterValue() == null ? "" : log.getAfterValue()%></textarea></td>
                            </tr>
                    		<% } %>	
                          </tbody>
                
                        </table>
		</div>
		<!-- /.container-fluid -->
	</section>

	</div>

	
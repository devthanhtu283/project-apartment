<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="com.demo.entities.Duration"%>
<%@page import="com.demo.models.DurationModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%
 	DurationModel durationModel = new DurationModel();
 %>
 <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-12">
              <h1>Danh sách thời hạn</h1>
             
 

            </div>
            
          </div>
        </div><!-- /.container-fluid -->
      </section>

      <!-- Main content -->
      <section class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-12">
              <div class="card">
            
                <!-- /.card-header -->
                <div class="card-body">
                	<script>
								$(document).ready(function() {
									$('#buttonReload').click(function() {
										location.reload();
									});
								});
							
							
							</script>

						<!-- /.card-header -->
				<%
                	HttpSession session2 = request.getSession();
                	String msg = (String) session2.getAttribute("msg");
                	String msg1 = msg;
                	session2.removeAttribute("msg");
                %>
                <c:if test="<%= msg1 != null %>">
                	<script>
                	alert('<%= msg1 %>');
                	</script>
                </c:if>
								<button id="buttonReload" class="btn" ><i class="fa-solid fa-rotate"></i></button>
                  <table style="text-align: center;" id="example2" class="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th style="vertical-align: top;">
                          Thời hạn                      
                        </th>
                        <br>
                        <th style="vertical-align: top;">Trạng thái
                          <br>
                          <select style="margin-top: 10px;" name="" id="changeStatus">
                            <option value="0">Chọn trạng thái</option>
                            <option value="1">1</option>
                            <option value="2">0</option>

                          </select>
                        </th>
                        <th style="vertical-align: top;">Hành động</th>
                      </tr>
                    </thead>
                    <tbody>
                    <% for(Duration duration : durationModel.findAll()) {%>
                      <tr>
                        <td><%= duration.getName() %></td>
                        <td><%= duration.isStatus() ? "1" : "0"%></td>
                        <td><a onclick="return confirm('Bạn có chắc muốn xóa thời hạn này ra khỏi hệ thống?')" href="${pageContext.request.contextPath }/superadmin/duration?action=deleteDuration&id=<%= duration.getId() %>"><i class="fa-solid fa-trash"></i></a></td>
                      </tr>

				</tbody>
                  </table>
                </div>
                <!-- /.card-body -->
              </div>
              <!-- /.card -->


              <!-- /.card -->
            </div>
            <!-- /.col -->
          </div>
          <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
      </section>
      <!-- /.content -->
    </div>
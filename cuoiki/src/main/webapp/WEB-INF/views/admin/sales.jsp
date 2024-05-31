<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="com.demo.entities.Sale"%>
<%@page import="com.demo.models.SaleModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%
 	SaleModel saleModel = new SaleModel();
 %>
 <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-12">
              <h1>Danh sách doanh thu</h1>
             
 

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
                <script>
					$(document).ready(function() {
						$('#name').keyup(function() {
							var name = $(this).val();
							console.log(name);
							$.ajax({
								type: 'GET',
								dataType: 'json',
								contentType: 'application/json; charset=utf-8',
								url: '${pageContext.request.contextPath}/superadmin/sale',
								data: {
									action: "searchByName",
									name: name
								},
								success: function(sales) {
									var s ='';
									for(var i = 0;i < sales.length; i++) {
										s+='<tr>';
										s+='<td>' + sales[i].id + '</td>';
										s+='<td>' + sales[i].name + '</td>';
										s+='<td>' + sales[i].saleNumber + '</td>';
										s+='<td>';
										if(sales[i].status == true) {
											s+='1';
										} else if(sales[i].status == false) {
											s+='0';
										}
										s+='<td><a onclick="return confirm(`Bạn có chắc muốn xóa doanh thu này ra khỏi danh sách?`)" href="${pageContext.request.contextPath }/superadmin/sale?action=deleteSale&id='+ sale[i].id +'"><i class="fa-solid fa-trash"></i></a></td>';
										s+='</tr>';					
									}
									$('#example2 tbody').html(s);
								}							
							});
						});
					});
                </script>
                
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
                	
								<button id="buttonReload" class="btn" ><i class="fa-solid fa-rotate"></i></button>
                  <table style="text-align: center;" id="example2" class="table table-bordered table-hover">
                    <thead>
                    	<th style="vertical-align: top;">
                          Id                      
                        </th>
                        <th style="vertical-align: top;">
                          Tên                      
                        </th>
                          <br>
                          <input type="text" name="name" id="name">
                         </th>
                        <th style="vertical-align: top;">Số doanh thu</th>
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
                    <% for(Sale sale : saleModel.findAll()) {%>
                      <tr>
                        <td><%= sale.getId() %></td>
                        <td><%= sale.getName() %></td>
                        <td><%= sale.getSaleNumber() %></td>
                        <td>
                        	<%= sale.isStatus() ? "1" : "0"%>
                        </td>
                        <td><a onclick="return confirm('Bạn có chắc muốn xóa doanh thu này ra khỏi hệ thống?')" href="${pageContext.request.contextPath }/superadmin/sale?action=deleteSale&id=<%= sale.getId()%>"><i class="fa-solid fa-trash"></i></a></td>
                       
                      
                        
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
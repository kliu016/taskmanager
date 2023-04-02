<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.springboot.demo.model.Task" %>
<%
  List<Task> tasks = (List<Task>)request.getAttribute("TASK_LIST");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task List</title>
</head>
<body>
<h2 align="center">Welcome to Task Manager Demo Project</h2>
<p>
<br>
<form action="/Search" method="post" name="searchform">
<table align="center" width="80%">
  <tr> 
  <td>Search description (with word): <input name="keyword" value="" width="140"><input type="submit" name="search" value="Search" width="150"></td>
  </tr>
</table>
</form>

<form action="/Update" method="post" name="updateform">
<table align="center" width="80%" border="1">
  <tr>
    <td><b>ID</b></td>
    <td><b>Title</b></td>
    <td><b>Description</b></td>
    <td><b>Due Date</b></td>
    <td><b>Computer Status</b></td>
    <td><b>Create Date</b></td>
    <td><b>Delete</b></td>
  <tr>
<% for (int row=0; row<tasks.size(); row++) { 
	Task task = tasks.get(row);
%>	
  <tr>
    <td><%=task.getId()%></td>
    <td><%=task.getTitle()%></td>
    <td><%=task.getDescription()%></td>
    <td><%=task.getDuedate().toString().substring(0,10)%></td>
    <td><select name="sts_<%=task.getId()%>">
      <option value="Yes" <%="Yes".equals(task.getCompletestatus())?"selected":""%>>Yes</option>
      <option value="No" <%="No".equals(task.getCompletestatus())?"selected":""%>>No</otion>
      </select>      
    </td>
    <td><%=task.getCreatedate().toString().substring(0,10)%></td>  
    <td><input type="checkbox" name="del_<%=task.getId()%>" value=1></td>       
  </tr>
<% } %>
</table>
<br>
<table align="center" width="80%">
  <tr>
  <td algin="center">
   <input type="submit" name="submit" value="Submit" width="180">
  </td>
  </tr>
</table>

</form>
</body>
</html>
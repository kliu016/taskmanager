<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.springboot.demo.model.Task" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task List</title>

<script>
function onClickDelete()
{
  if (confirm("Are you sure you want to delete it?"))
  {
	 return true; 
  }
  else
    return false;
}
</script>
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
  <c:forEach var="task" items="${tasks}">
  <tr>
    <td>${task.getId()}</td>
    <td>${task.getTitle()}</td>
    <td>${task.getDescription()}</td>
    <td>${task.getDuedate().toString().substring(0,10)}</td>
    <td><select name="sts_${task.getId()}">
      <option value="Yes" 
      <c:if test="${task.getCompletestatus() == 'Yes'}">selected</c:if>
      >Yes</option>
      <option value="No" 
      <c:if test="${task.getCompletestatus() == 'No'}">selected</c:if>
      >No</otion>
      </select>      
    </td>
    <td>${task.getCreatedate().toString().substring(0,10)}</td>  
    <td><a href="/Delete/${task.getId()}" onclick="return onClickDelete()">Delete</a></td>       
  </tr>
 </c:forEach> 
<!-- % } % -->
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
<%@page import="com.Project"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
 
 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/projects.js"></script>
</head>
<body> 
<div class="container"><div class="row"><div class="col-6"> 
<h1>Project Management V10.1</h1>
<form id="formProject" name="formProject">
 Project code: 
 <input id="projectCode" name="projectCode" type="text" 
 class="form-control form-control-sm">
 <br> Project name: 
 <input id="projectName" name="projectName" type="text" 
 class="form-control form-control-sm">
 <br>Project Description: 
 <input id="projectDesc" name="projectDesc" type="text" 
 class="form-control form-control-sm">
 <br> Project Start Date: 
 <input id="projectstartdate" name="projectstartdate" type="text" 
 class="form-control form-control-sm">
  <br> Project End Date: 
 <input id="projectenddate" name="projectenddate" type="text" 
 class="form-control form-control-sm">
 <br>
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidProjectIDSave" 
 name="hidProjectIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divProjectsGrid">
 <%
  Project projectObj = new Project(); 
  out.print(projectObj.readProject());
 %>
</div>
</div> </div> </div> 
</body>
</html>
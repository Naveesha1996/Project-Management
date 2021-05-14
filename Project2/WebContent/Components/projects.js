$(document).ready(function()
{ 

 $("#alertSuccess").hide(); 

 $("#alertError").hide(); 
}); 
$(document).on("click", "#btnSave", function(event)
{ 
// Clear alerts---------------------
 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
// Form validation-------------------
var status = validateProjectForm(); 
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 
// If valid------------------------
var type = ($("#hidProjectIDSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
 url : "ProjectsAPI", 
 type : type, 
 data : $("#formProject").serialize(), 
 dataType : "text", 
 complete : function(response, status) 
 { 
 onProjectSaveComplete(response.responseText, status); 
 } 
 }); 
});

function onProjectSaveComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully saved."); 
 $("#alertSuccess").show(); 
 $("#divProjectsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while saving."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while saving.."); 
 $("#alertError").show(); 
 } 
 $("#hidProjectIDSave").val(""); 
 $("#formProject")[0].reset(); 
}

$(document).on("click", ".btnUpdate", function(event)
{ 
$("#hidProjectIDSave").val($(this).closest("tr").find('#hidProjectIDUpdate').val()); 
 $("#projectCode").val($(this).closest("tr").find('td:eq((0)').text()); 
 $("#projectName").val($(this).closest("tr").find('td:eq(1)').text()); 
 $("#projectDesc").val($(this).closest("tr").find('td:eq(2)').text()); 
 $("#projectstartdate").val($(this).closest("tr").find('td:eq(3)').text()); 
 $("#projectenddate").val($(this).closest("tr").find('td:eq(4)').text()); 
});

$(document).on("click", ".btnRemove", function(event)
{ 
 $.ajax( 
 { 
 url : "ProjectsAPI", 
 type : "DELETE", 
 data : "projectID=" + $(this).data("projectid"),
 dataType : "text", 
 complete : function(response, status) 
 { 
 onProjectDeleteComplete(response.responseText, status); 
 } 
 }); 
});

function onProjectDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divProjectsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while deleting."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while deleting.."); 
 $("#alertError").show(); 
 } 
}
function validateProjectForm() 
{ 
// CODE
if ($("#projectCode").val().trim() == "") 
 { 
 return "Insert Project Code."; 
 } 
// NAME
if ($("#projectName").val().trim() == "") 
 { 
 return "Insert Project Name."; 
 } 
// Desc
if ($("#projectDesc").val().trim() == "") 
 { 
 return "Insert Project Desc."; 
 } 
// StartDate
if ($("#projectStartdate").val().trim() == "") 
 { 
 return "Insert Project Start Date."; 
 } 
// EndDate
if ($("#projectEnddate").val().trim() == "") 
 { 
 return "Insert Project End Date."; 
 }  
return true; 
}

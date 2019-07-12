<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.*,com.marlabs.struts.Mybean" %>
<%
	Mybean b;
%>


<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript">
function deleteRecord()
	{	     
	    document.fom.action="delete.action";
	    document.fom.submit();
	}
function insertRecord()
{	     
    document.fom.action="insertLink.action";
    document.fom.submit();
}	
function editr(val)
{	     
   document.fom.action="update.action?fid="+val;
   document.fom.submit();   
}	
</script>

</head>

<form method="post" name="fom">

<table class="mtable">
<tr><td colspan="5">

<font face="verdana" size="2">
<input type="button" value="insert" onclick="insertRecord()"> <input type="button" value="delete" onclick="deleteRecord()"> <br><br>

</font>

</td></tr>

<tr>
<td class="th"><center>+</center></td>
<td class="th"><b>SNO</b></td>
<td class="th"><b>SName</b></td>
<td class="th"><b>Country</b></td>
<td class="th"><b> Ope.</b></td>
</tr>


<%
	List l=(List)request.getAttribute("rec");
if(l!=null)
{
	Iterator it=l.iterator();
	
	while(it.hasNext())
	{		
		b=(com.marlabs.struts.Mybean)it.next();
%>
        <tr> 
        <td class="bord"><input type="checkbox" value="<%= b.getNo() %>" name="rdel"></td>
        <td class="bord"><%= b.getNo() %></td>
        <td class="bord"><%= b.getNam() %></td>
        <td class="bord"><%= b.getCt() %></td>
        <td class="bord"><a href="javascript:editr('<%= b.getNo() %>')">Edit</a></td>         
        </tr> 
        
<% 		
				
	}	
}

%> 

</table>
</form>

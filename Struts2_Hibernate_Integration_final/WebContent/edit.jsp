<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*" %>

<html>

<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />

<script type="text/javascript">
function display()
	{	     
	    document.fom.action="verify.action";
	    document.fom.submit();
	}
</script>

</head>

<body>

<s:form action="updateRecInDB" method="post" name="fom"> 	


<table class="mtableu">
<tr>
<td colspan="2">

<input type="button" value="Display Records" onclick="display()"> 

</td></tr>

<tr><td>

			<s:textfield label="Number" value="%{#application.x}" readonly="true" name="b.no" cssClass="bord"/>
			<s:textfield label="Name" value="%{#application.y}" name="b.nam" cssClass="bord"/>
			<s:textfield label="Country" value="%{#application.z}" name="b.ct" cssClass="bord"/>
 
<s:submit value="Update" />

</td>
</tr>
</table>    
    
</s:form>



</body>
</html>


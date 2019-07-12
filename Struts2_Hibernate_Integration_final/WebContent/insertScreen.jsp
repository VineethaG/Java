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

	<s:form action="insert" name="fom"> 	


<table class="mtableu">
<tr>
<td colspan="2">

<input type="button" value="Display Records" onclick="display()"> 


</td></tr>

<tr><td>

			<s:textfield label="Number" name="b.no" cssClass="bord"/>
			<s:textfield label="Name" name="b.nam" cssClass="bord"/>
			<s:textfield label="Country" name="b.ct" cssClass="bord"/>
 
<s:submit value="Insert" />

</td>
</tr>
</table>    
    
</s:form>



</body>
</html>


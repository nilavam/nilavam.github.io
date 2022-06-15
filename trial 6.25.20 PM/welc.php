<html>
<body>

Your feedback has been successfully recorded! You may close this session.
<?php 
ini_set('display_errors', true);
mail('nilava30@gmail.com','Feedback for MSc@RSM', $_POST["comment"],"From: nilavam@cmi.ac.in"); 
?>
<form action="formtry.html" method="post">
	<input type="submit" value="Submit another response" style = "font-size: 20px;">
</form>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href='https://fonts.googleapis.com/css?family=Ubuntu' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<center>
<br/>
<font style="font-family: 'Ubuntu'">
<div class="container">
    <div class="row">
		<div class="span12">
			<form class="form-horizontal" action='authenticate' method="POST">
			  <fieldset>
			    <div id="legend">
			      <legend class="">Login</legend>
			    </div>
			    <div class="control-group">
			      <!-- Username -->
			      <label class="control-label"  for="username">Username</label>
			      <div class="controls">
			        <input type="text" id="username" name="userName" placeholder="" class="input-xlarge">
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- Password-->
			      <label class="control-label" for="password">Password</label>
			      <div class="controls">
			        <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
			      </div>
			    </div>
                            <br/>
			    <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			        <button class="btn btn-success">Login</button>
			      </div>
			    </div>
			  </fieldset>
			</form>
		</div>
	</div>
</div>
<br/>
<center>
	<%
		if(request!=null){
			String message=(String)request.getAttribute("message");
			if(message!=null){
	%>
				<label><font color='RED'>${message}</font></label>
	<%			
			}
			else{
 			message=(String)request.getParameter("message");
 			if(message!=null){
	%>
 				<label><font color='RED'><%=message%></font></label>
	<%			
 			}
			}
		}
	%>
</center>
</font>
</center>
</body> 
</html>


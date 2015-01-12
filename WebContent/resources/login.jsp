<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<title>JavaDemo - Login</title>
</head>
<body>
	<form action="/SpringJavaDemo/j_spring_security_check" method="POST" >
		<input type="text" placeholder="Username" id="username"
			name="j_username" /> <input type="text" placeholder="Password"
			id="password" name="j_password" /> <input type="submit"
			value="Login" />
	</form>
</body>
</html>
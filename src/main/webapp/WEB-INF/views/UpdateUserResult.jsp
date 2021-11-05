<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update!</title>
</head>
<body>
<c:if test ="${check == 1}">
    <h3>
        Fail. 아이디를 입력해주세요.
    </h3>
</c:if>
<c:if test ="${check == 2}">
    <h3>
        Fail. 비밀번호를 입력해주세요.
    </h3>
</c:if>

<c:if test ="${check == 3}">
    <h3>SUCCESS</h3>
    <h3>ID: ${id}</h3>
    <h3>PASSWORD: ${new_password}</h3>
</c:if>
<c:if test ="${check == 4}">
    <h3>
        Fail. 아이디가 존재하지 않습니다.
    </h3>
</c:if>
<c:if test ="${check == 5}">
    <h3>
        Fail. 비밀번호가 일치하지 않습니다.
    </h3>
</c:if>

<br/>
</body>
</html>
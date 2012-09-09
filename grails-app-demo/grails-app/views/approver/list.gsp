<%--
  Created by IntelliJ IDEA.
  User: JBaruch
  Date: 20/08/12
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Unapproved Artifacts</title>
    <meta name="layout" content="main" />

</head>

<body>
<h1>Unapproved Artifacts</h1>
<g:form name="approve" action="list">
    <g:select name="pendingArtifacts"
              from="${pendingArtifacts}"
              size="${pendingArtifacts.size()}" multiple="yes"/>
    <br>
    <g:submitButton value="Approve" name="approve"/>
</g:form>
</body>
</html>
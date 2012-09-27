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
    <meta name="layout" content="main"/>

</head>

<body>
<h1>Unapproved Artifacts</h1>
<g:form name="approve" action="list">
    <g:if test="${pendingArtifacts.size > 0}">
        <g:select name="pendingArtifacts"
                  from="${pendingArtifacts}"
                  size="${pendingArtifacts.size()}" multiple="yes"/>
    </g:if>
    <g:else>
        <p>Nothing's here!</p>
    </g:else>
    <br>
    <g:submitButton value="${pendingArtifacts.size > 0 ? 'Approve' : 'Check Again'}" name="approve"/>
</g:form>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
    </head>
    
    <body>
        <h3>${message}</h3>
        <form:form method="POST"
          action="/CreditControl/creditControl" modelAttribute="customer" onsubmit="">
             <table>
                <tr>
                    <td><form:label path="tckn" >TCKN</form:label></td>
                    <td><form:input path="tckn" maxlength="11" type="text"/></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td><form:label path="name">ADINIZ</form:label></td>
                    <td><form:input path="name" minlegth="1"/></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td><form:label path="surname">SOYADINIZ</form:label></td>
                    <td><form:input path="surname"/></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td><form:label path="income">AYLIK GELİRİNİZ</form:label></td>
                    <td><form:input path="income"/></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td><form:label path="phoneNumber">TELEFON</form:label></td>
                    <td><form:input path="phoneNumber"/></td>
                </tr>
            </table>
            <tr>
                    <td><input type="submit" value="KREDİYE BAŞVUR"/></td>
                </tr>
            
        </form:form>
    </body>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/form-validator.js"></script>
    
</html>

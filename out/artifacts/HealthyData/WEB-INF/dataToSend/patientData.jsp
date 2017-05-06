<%@ page contentType="text/xml;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<patient id="${sessionScope.doctor.selectedPatient.id}">
    <firstName>${sessionScope.doctor.selectedPatient.firstName}</firstName>
    <lastName>${sessionScope.doctor.selectedPatient.lastName}</lastName>
    <adress>${sessionScope.doctor.selectedPatient.adress}</adress>
    <birthday>${sessionScope.doctor.selectedPatient.birthday}</birthday>
    <weight>${sessionScope.doctor.selectedPatient.weight}</weight>
    <height>${sessionScope.doctor.selectedPatient.height}</height>
    <c:forEach items="${sessionScope.doctor.selectedPatient.sensorList}" var="sensor">
        <sensor id = "${sensor.id}" name = "${sensor.name}">
            <c:forEach var="measure" items="${sensor.measureList}">
                <mesure>${measure.type}</mesure>
            </c:forEach>
        </sensor>
    </c:forEach>

</patient>
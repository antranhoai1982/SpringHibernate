<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tieu de</title>
</head>
<body>
	<div class="panel panel-default">
		<div id="abc" class="panel-heading h3 text-center">
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>id</th>
						<th>name</th>
						<th>age</th>
						<th>address</th>
						<th>action</th>
					</tr>
				<thead>
				abc: ${abc}
					<c:choose>
						<c:when test="${!empty abc}">
							<c:forEach items="${abc}" var="student">
								<tr>
									<td>${student.id}</td>
									<td>${student.firstName}${student.lastName}</td>
									<td>${student.age}</td>
									<td>${student.address.street},
										${student.address.district}, ${student.address.city}</td>
									<td>
										<button class="btn btn-info"
											onclick="getStudent(${student.id}, 'VIEW');">
											view
										</button>
										<button class="btn btn-primary"
											onclick="getStudent(${student.id}, 'EDIT');">
											edit
										</button>
										<button class="btn btn-danger"
											onclick="deleteStudent(${student.id});">
											delete
										</button>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<th colspan="5" class="text-center">empty</th>
							</tr>
						</c:otherwise>
					</c:choose>
					<tr>
						<th colspan="5">
							<button onclick="location.href='addStudent'"
								class="btn btn-primary">
								add
							</button>
						</th>
					</tr>
			</table>
		</div>
	</div>
</body>
</html>
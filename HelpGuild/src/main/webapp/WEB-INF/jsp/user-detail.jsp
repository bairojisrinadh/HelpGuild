<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>
<!DOCTYPE html>
<head>
<script type="text/javascript" src="/scripts/common.js"></script>
</head>
<strong style="font-size: large;">${user.name} Profile</strong>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Blog</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${user.blogs}" var="blog">
			<tr>
				<td><a onclick="toggleTable()">${blog.name}</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<table id="ListItems" style="display: none;"
	class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>Link</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${user.blogs}" var="blog">
			<c:forEach items="${blog.items}" var="item">
				<tr>
					<td>${item.title}</td>
					<td><a href="${item.link}">${item.link}</a></td>
				</tr>
			</c:forEach>
		</c:forEach>
	</tbody>
</table>

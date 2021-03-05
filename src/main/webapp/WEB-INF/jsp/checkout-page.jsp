<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Out</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/f8ebbde80f.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body class="bg-light">

	<div class="container main">
		<nav
			class="conatiner-fluid navbar navbar-expand-lg navbar-light bg-light">


			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand" href="#">Music Store</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="/album">Home
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><form:form action="logout" method="post">
							<input type="submit" class="btn" value="Logout" />
						</form:form></li>
				</ul>
			</div>

		</nav>


		<div class="list-group p-3 mt-2">
			<h2>Cart</h2>
			<c:choose>
				<c:when test="${!items.isEmpty() }">

					<c:forEach items="${items}" var="item">
						<div
							class="list-group-item list-group-item-action flex-column align-items-start">
							<div class="d-flex w-100 justify-content-between">
								<c:choose>
									<c:when test="${item.song.name == null}">
										<a href="/album/${item.album.id}" class="mb-1">${item.album.name}</a>
										<div class="w-25 d-flex justify-content-between">
											$${item.album.price} <a href="/cart/delete/${item.id}"><i
												class="fas fa-trash"></i></a>
										</div>
									</c:when>
									<c:when test="${item.album.name == null}">
										<a href="/song/${item.song.id}" class="mb-1">${item.song.name}</a>
										<div class="w-25 d-flex justify-content-between">
											$${item.song.price} <a href="/cart/delete/${item.id}"><i
												class="fas fa-trash"></i></a>
										</div>
									</c:when>
								</c:choose>

							</div>
						</div>

					</c:forEach>
					<div
						class="list-group-item list-group-item-action flex-column align-items-start border-top">
						<div class="d-flex w-100 justify-content-between">


							<h5 class="mb-1">Total</h5>
							<div class="w-25">$${total}</div>

						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div
						class="list-group-item list-group-item-action flex-column align-items-start">
						<div class="d-flex w-100">


							<h5 class="mb-1">Add Items To The Cart!</h5>


						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<form:form class="p-3 container-fluid">
			<h3>User Details</h3>
			<input type="hidden" id="total" name="total" value="${total}">
			<input type="hidden" id="id" name="id" value="${user.id}">
			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" name="name" value="${user.name}"
					placeholder="Name" required>
			</div>

			<div class="form-group">
				<label for="email">Email</label> <input type="text"
					class="form-control" name="email" value="${user.email}"
					placeholder="Email" required>
			</div>

			<div class="form-group">
				<label for="address">Address</label> <input type="text"
					class="form-control" name="address" value="${user.address}"
					placeholder="Address" required>
			</div>

			<div class="form-group">
				<label for="city">City</label> <input type="text"
					class="form-control" name="city" value="${user.city}"
					placeholder="City" required>
			</div>
			<div class="form-group">
				<label for="state">State</label> <select id="state"
					class="form-control" name="state" required>
					<option value="AK"
						<c:if test="${user.state =='AK'}"> selected</c:if>>Alaska</option>
					<option value="AL"
						<c:if test="${user.state =='AL'}"> selected</c:if>>Alabama</option>
					<option value="AZ"
						<c:if test="${user.state =='AZ'}"> selected</c:if>>Arizona</option>
					<option value="AR"
						<c:if test="${user.state =='AR'}"> selected</c:if>>Arkansas</option>
					<option value="CA"
						<c:if test="${user.state =='CA'}"> selected</c:if>>California</option>
					<option value="CO"
						<c:if test="${user.state =='CO'}"> selected</c:if>>Colorado</option>
					<option value="CT"
						<c:if test="${user.state =='CT'}"> selected</c:if>>Connecticut</option>
					<option value="DE"
						<c:if test="${user.state =='DE'}"> selected</c:if>>Delaware</option>
					<option value="FL"
						<c:if test="${user.state =='FL'}"> selected</c:if>>Florida</option>
					<option value="GA"
						<c:if test="${user.state =='GA'}"> selected</c:if>>Georgia</option>
					<option value="HI"
						<c:if test="${user.state =='HI'}"> selected</c:if>>Hawaii</option>
					<option value="ID"
						<c:if test="${user.state =='ID'}"> selected</c:if>>Idaho</option>
					<option value="IL"
						<c:if test="${user.state =='IL'}"> selected</c:if>>Illinois</option>
					<option value="IN"
						<c:if test="${user.state =='IN'}"> selected</c:if>>Indiana</option>
					<option value="IA"
						<c:if test="${user.state =='IA'}"> selected</c:if>>Iowa</option>
					<option value="KS"
						<c:if test="${user.state =='KS'}"> selected</c:if>>Kansas</option>
					<option value="KY"
						<c:if test="${user.state =='KY'}"> selected</c:if>>Kentucky</option>
					<option value="LA"
						<c:if test="${user.state =='LA'}"> selected</c:if>>Louisiana</option>
					<option value="ME"
						<c:if test="${user.state =='ME'}"> selected</c:if>>Maine</option>
					<option value="MD"
						<c:if test="${user.state =='MD'}"> selected</c:if>>Maryland</option>
					<option value="MA"
						<c:if test="${user.state =='MA'}"> selected</c:if>>Massachusetts</option>
					<option value="MI"
						<c:if test="${user.state =='MI'}"> selected</c:if>>Michigan</option>
					<option value="MN"
						<c:if test="${user.state =='MN'}"> selected</c:if>>Minnesota</option>
					<option value="MS"
						<c:if test="${user.state =='MS'}"> selected</c:if>>Mississippi</option>
					<option value="MO"
						<c:if test="${user.state =='MO'}"> selected</c:if>>Missouri</option>
					<option value="MT"
						<c:if test="${user.state =='MT'}"> selected</c:if>>Montana</option>
					<option value="NE"
						<c:if test="${user.state =='NE'}"> selected</c:if>>Nebraska</option>
					<option value="NV"
						<c:if test="${user.state =='NV'}"> selected</c:if>>Nevada</option>
					<option value="NH"
						<c:if test="${user.state =='NH'}"> selected</c:if>>New
						Hampshire</option>
					<option value="NJ"
						<c:if test="${user.state =='NJ'}"> selected</c:if>>New
						Jersey</option>
					<option value="NM"
						<c:if test="${user.state =='NM'}"> selected</c:if>>New
						Mexico</option>
					<option value="NY"
						<c:if test="${user.state =='NY'}"> selected</c:if>>New
						York</option>
					<option value="NC"
						<c:if test="${user.state =='NC'}"> selected</c:if>>North
						Carolina</option>
					<option value="ND"
						<c:if test="${user.state =='ND'}"> selected</c:if>>North
						Dakota</option>
					<option value="OH"
						<c:if test="${user.state =='OH'}"> selected</c:if>>Ohio</option>
					<option value="OK"
						<c:if test="${user.state =='OK'}"> selected</c:if>>Oklahoma</option>
					<option value="OR"
						<c:if test="${user.state =='OR'}"> selected</c:if>>Oregon</option>
					<option value="PA"
						<c:if test="${user.state =='PA'}"> selected</c:if>>Pennsylvania</option>
					<option value="RI"
						<c:if test="${user.state =='RI'}"> selected</c:if>>Rhode
						Island</option>
					<option value="SC"
						<c:if test="${user.state =='SC'}"> selected</c:if>>South
						Carolina</option>
					<option value="SD"
						<c:if test="${user.state =='SD'}"> selected</c:if>>South
						Dakota</option>
					<option value="TN"
						<c:if test="${user.state =='TN'}"> selected</c:if>>Tennessee</option>
					<option value="TX"
						<c:if test="${user.state =='TX'}"> selected</c:if>>Texas</option>
					<option value="UT"
						<c:if test="${user.state =='UT'}"> selected</c:if>>Utah</option>
					<option value="VT"
						<c:if test="${user.state =='VT'}"> selected</c:if>>Vermont</option>
					<option value="VA"
						<c:if test="${user.state =='VA'}"> selected</c:if>>Virginia</option>
					<option value="WA"
						<c:if test="${user.state =='WA'}"> selected</c:if>>Washington</option>
					<option value="DC"
						<c:if test="${user.state =='DC'}"> selected</c:if>>Washington
						D.C.</option>
					<option value="WV"
						<c:if test="${user.state =='WV'}"> selected</c:if>>West
						Virginia</option>
					<option value="WI"
						<c:if test="${user.state =='WI'}"> selected</c:if>>Wisconsin</option>
					<option value="WY"
						<c:if test="${user.state =='WY'}"> selected</c:if>>Wyoming</option>
				</select>
			</div>
			<div class="form-group">
				<label for="zipcode">Zip Code</label> <input type="text"
					class="form-control" name="zipcode" value="${user.zipcode}"
					placeholder="Zip Code" required>
			</div>
			<div class="form-group">
				<label for="credit_card">Credit Card</label> <input type="text"
					class="form-control" name="credit_card" value="${user.credit_card}"
					placeholder="#####" required>
			</div>

			<div class="form-check mt-2">
				<input class="form-check-input" type="checkbox" id="gridCheck"
					name="checkboxValue"> <label class="form-check-label"
					for="gridCheck"> Save my information </label>
			</div>

			<button type="submit"
				class="btn btn-primary mt-2 btn-large btn-block">Buy Now</button>
		</form:form>
	</div>
</body>
</html>
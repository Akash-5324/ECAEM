<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ECAEM Club Management</title>
<link rel="stylesheet" href="clubregistration.css">
</head>
<body>
	<%@include file="adminnav.jsp"%>
	<main class="club-main">
		<div class="club-abmin-container">
			<div class="club-abmin-heading">
				<h2>Club Registration</h2>
			</div>
			<form class="club-form" method="post" action="addclub">
				<div class="form-group">
					<label for="name">Club Name:</label> <input type="text" id="name"
						name="cname" required>
				</div>
				<div class="form-group">
					<label for="name">Club Email:</label> <input type="email"
						id="email" name="cemail" required>
				</div>
				<div class="form-group">
					<label for="name">Club Password:</label> <input type="password"
						id="password" name="cpwd" required>
				</div>
				<div class="form-group">
					<label for="description">Club Description:</label> <input
						type="text" id="description" name="cdescription" required>
				</div>
				<div class="form-group-colour">
					<label for="colour">Colour:</label> <input type="color" id="colour"
						name="ccolour" required>
				</div>
				<!-- Text input to display hex value -->
				<div class="form-group">
				<input type="text" id="colourText" name="colourText" readonly>
				</div>

				<script>
    const colourPicker = document.getElementById('colour');
    const colourText = document.getElementById('colourText');

    // Set initial color text value
    colourText.value = colourPicker.value;

    // Update the text input with the hex color code whenever a new color is selected
    colourPicker.addEventListener('input', () => {
      colourText.value = colourPicker.value;
    });
  </script>
				<div class="save">

					<button>Save</button>
				</div>
			</form>
		</div>

	</main>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Pdf Converter</title>
	<link href="/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/resources/js/form-submit.js" ></script>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="">Pdf Converter</a>
        </div>
    </nav>

	<div class="container">
		<form target="_blank" method="post" action="/pdf">
			<div class="form-group">
				<label for="textContainer">Insert Json structure to be
					converted to PDF:</label>
				<textarea name="jsonToConvert" class="form-control" id="textContainer" rows="10"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Add icon library -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.btn {
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 12px 16px;
	font-size: 16px;
	cursor: pointer;
}

/* Darker background on mouse-over */
.btn:hover {
	background-color: RoyalBlue;
}
</style>
</head>
<body>
	<h2>Welcome</h2>
	<a href="/fileupload/FileUpload.jsp" class="btn"> <i
		class="fa fa-folder"></i> UPLOAD
	</a>

	<a href="/fileupload/DownloadFile.jsp" class="btn"> <i
		class="fa fa-folder"></i> DOWNLOAD
	</a>

	<a href="/fileupload/webapi/files/viewfiles" class="btn"> <i
		class="fa fa-folder"></i> VIEW FILES
	</a>
</body>
</html>

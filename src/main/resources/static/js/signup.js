const input = document.querySelectorAll("input");
const signupButton = document.querySelector('.signUpButton');

signupButton.onclick = () => {
	
	let signupData = {
		userName : input[1].value,
		userEmail : input[2].value,
		userPassword : input[3].value
	}

	$.ajax({
		
		async: false,
		type: "post",
		url: "/api/v1/auth/signup",
		contentType: "application/json",
		data: JSON.stringify(signupData),
		dataType: "json",
		success: (response) => {
			if(response.data) {
				alert("회원가입 완료");
				location.replace("/signin");
			}
		},
		
		error: (error) => {
			if(error.status == 400) {
				alert(JSON.stringify(error.responseJSON.data));
			} else {
				console.log("요청 실패");
				console.log(error);
			}
		}		
	})
	
	console.log(signupData);
}

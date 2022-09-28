const input = document.querySelectorAll("input");
const signupButton = document.querySelector('.signUpButton');

let checkUserEmailFlag = false;

input[2].onblur = () => {
	console.log(input[2].value)
	/* 
		아이디 중복 확인
	 */
	 
	 $.ajax({
		async: false,
		type: "get",
		url: "/api/v1/auth/signup/validation/userEmail",
		data: {userEmail : input[2].value},
		dataType: "json",
		success: (response) => {
			
			checkUserEmailFlag = response.data;
			
			if(checkUserEmailFlag) {
				alert("사용 가능한 이메일 입니다.")
			} else {
				alert("이미 사용 중인 이메일 입니다.")
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
}

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

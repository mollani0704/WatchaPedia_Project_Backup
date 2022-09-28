function getPrincipal() {
	let user = null;
	$.ajax({
		async: false,
		type: "get",
		url: "/api/v1/auth/principal",
		dataType: "json",
		success: (response) => {
			user = response.data
			console.log(user);
		},
		error: (error) => {
			console.log(error);
		}
	});
	
	return user;
}

function loadHeader(user) {
	
	const authItems = document.querySelector(".auth-items");
	
	if(user == null) {
		authItems.innerHTML = `
			<li><button type="button" class="header__button__login" >로그인</button></li>
            <li><button type="button" class="header__button__signup">회원가입</button></li>
		`;
		
		const signin = document.querySelector(".header__button__login");
		const signup = document.querySelector(".header__button__signup");
		
		signin.onclick = () => {
			location.href = "/signin"
		}
		
		signup.onclick = () => {
			location.href = "/signup"
		}
	} else {
		authItems.innerHTML = `
			<li><button type="button" class="auth__button username">${user.user_name}</button></li>
			<li><button type="button" class="auth__button logout">로그아웃</button></li>
		`;
		
		const username = document.querySelector(".username");
		const logout = document.querySelector(".logout");
		
		username.onclick = () => {
			location.href = "/mypage"
		}
		
		logout.onclick = () => {
			location.replace("/logout");
		}
	}
}

let user = getPrincipal();

loadHeader(user);

function getUser() {
	return user;
}

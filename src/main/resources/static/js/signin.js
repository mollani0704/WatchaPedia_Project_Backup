const input = document.querySelectorAll("input");
const signInButton = document.querySelector('.signInButton');

signInButton.onclick = () => {
	
	let signInData = {
		userEmail : input[1].value,
		userPassword : input[2].value
	}
	
	console.log(signInData);
		
}

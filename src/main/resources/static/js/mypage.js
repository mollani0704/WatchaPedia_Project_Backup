

const profileNameWrap = document.querySelector(".profile__name__wrap");
const  myPageReview= document.querySelector(".my__page__review");

getWishData();


function getWishData() {
	$.ajax({
		async: false, 
		type: "get",
		url: `/api/v1/wish/select/${user.user_code}`,
		dataType: "json",
		success: (response) => {
			showUserName(user.user_name);
			showWishCount(response.data);
			console.log(response);
		}
	})
}

function showUserName(username) {
	profileNameWrap.innerHTML = `
		<h1 class="profile__name">${username}</h1>
	`
}

function showWishCount(data) {
	myPageReview.innerHTML = `
		<li class="review__item">
           <a href="/movie/wishList" class="review__detail__wrap">
             <ul class="review__item__detail">
           		<li class="review__detail__section">영화</li>
           		<li class="review__rate">★${data.length}</li>
           		<li class="review__bucket">
              		보고싶어요<strong>${data.length}</strong>
           		</li>
             </ul>
           </a>
        </li>
	`
}
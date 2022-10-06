/**
 * 
 */
 

 
 loadWishList();
 
 function loadWishList() {
	$.ajax({
		async: false,
		type: "get",
		url: `/api/v1/wish/data/${user.user_code}`,
		dataType: "json",
		success: (response) => {
			showWishData(response.data);
			console.log(response);
		}
	})
}

function showWishData(wishData) {
	const wishList = document.querySelector(".wishList");
	for(data of wishData) {
		const wishListItem = `
		<li class="wishList__item">
        	<div class="wishList__item__image">
        		<img src="${data.moviePoster}" alt="" />
        	</div>
        	<div class="wishList__item__description">
        		<div class="wishList__item__title">${data.movieTitle}</div>
        		<div class="wishList__item__year__country">${data.movieYear}•${data.movieOrigin}</div>
        	</div>
        </li>
		`
		wishList.innerHTML += wishListItem;
	}
}

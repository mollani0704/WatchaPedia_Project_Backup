/**
 * 
 */
 
 loadDramaWishList();
 loadUserName();
 
 function loadDramaWishList() {
	$.ajax({
		async: false,
		type: "get",
		url: `/api/v1/wish/drama/data/${user.user_code}`,
		dataType: "json",
		success: (response) => {
			showDramaWishData(response.data);
			console.log(response);
		}
	})
}

function loadUserName() {
	const wishListTitle = document.querySelector('.wishList__title');
	wishListTitle.innerText = `${user.user_name}님이 보고싶은 드라마`
}

function showDramaWishData(dramaWishData) {
	const dramaWishDatas = document.querySelector(".wishList");
	for(data of dramaWishData) {
		const dramaWishDataItem = `
		<li class="wishList__item">
        	<div class="wishList__item__image">
        		<img src="${data.dramaPoster}" alt="" />
        	</div>
        	<div class="wishList__item__description">
        		<div class="wishList__item__title">${data.dramaTitle}</div>
        		<div class="wishList__item__year__country">${data.dramaYear}•${data.dramaCompany}</div>
        	</div>
       	</li>
		`
		dramaWishDatas.innerHTML += dramaWishDataItem
	}
}
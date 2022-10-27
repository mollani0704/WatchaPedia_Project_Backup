load();

function load() {
	$.ajax({
		async: false,
		type: "get",
		url: "/api/v1/content/drama",
		dataType:"json",
		success: (response) => {
			console.log(response.data);
			if(response.data != null) {
				getDramaList(response.data)
			}
		},
		
		error: (error) => {
			console.log(error);
		}
	})
}

function getDramaList(dramaData) {
	const dramaItems = document.querySelector(".mainList__items");
	dramaItems.innerHTML = "";
	dramaData.forEach(drama => {
		dramaItems.innerHTML += `
		<div class="mainList__item">
			<div class="mainList__item__image">
				<img src="${drama.dramaPoster}" alt="" />
			</div>
			<div class="mainList__item__number">${drama.dramaCode}</div>
			<div class="mainList__item__description">
				<div class="item__title">${drama.dramaTitle}</div>
				<div class="item__year__country">${drama.dramaYear}•${drama.dramaCompany}</div>
			</div>
		</div>	`
	});
}

const dramaItem = document.querySelectorAll('.mainList__item');
	
dramaItem.forEach(drama => {
	drama.onclick = () => {
		const dramaNumber = drama.querySelector('.mainList__item__number').textContent;
		
		console.log(dramaNumber);	
		location.href = `/drama/detail/${dramaNumber}`;			

	}
 })
load();

function load() {
	$.ajax({
		async: false,
		type: "get",
		url:"/api/v1/content/book",
		dataType: "json",
		success: (response) => {
			console.log(response.data);
			if(response.data != null) {
				getBookList(response.data)
			}
		},
		
		error: (error) => {
			console.log(error);
		}
		
		
	})
}

function getBookList(bookData) {
	const bookItems = document.querySelector(".mainList__items");
	bookItems.innerHTML = "";
	bookData.forEach(book => {
		bookItems.innerHTML += `
		<div class="mainList__item">
			<div class="mainList__item__image">
				<img src="${book.bookPoster}" alt="" />
			</div>
			<div class="mainList__item__number">${book.bookCode}</div>
			<div class="mainList__item__description">
				<div class="item__title">${book.bookTitle}</div>
				<div class="item__year__country">${book.bookYear}•${book.bookAuthor}•${book.bookPage}</div>
			</div>
		</div>
		`
	});
	
}


const bookItem = document.querySelectorAll('.mainList__item');

bookItem.forEach(book => {
	book.onclick = () => {
		const bookNumber = book.querySelector('.mainList__item__number').textContent;
		
		console.log(bookNumber);	
		location.href = `/book/detail/${bookNumber}`;		
	}
})


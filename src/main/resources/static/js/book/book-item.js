const address = window.location.href;
const bookNumber = address.split("/")[5];

getBook(bookNumber);

function getBook(bookNumber) {
	$.ajax ({
		async: false,
		type: "get",
		url: `/api/v1/content/book/${bookNumber}`,
		dataType: "json",
		success: (response) => {
			console.log(response.data);
			bookDetail(response.data);

		}
	})
}


function bookDetail(bookData) {
	const test = document.querySelector('.test');
	const headerPoster = document.querySelector('.header__description__poster');
	const headerDetail = document.querySelector('.header__description__detail');
	const contentDetail = document.querySelector('.contents__body__detail');
	const commentDetail = document.querySelector('.contents__body__similarity');
	const authorDetail = document.querySelector('.body__association__title__wrap');
	
	test.innerHTML = `
		<img class="top__image" src="${bookData.bookPoster}" alt="">
		`

	headerPoster.innerHTML = `
		<img src="${bookData.bookPoster}">
	`

	headerDetail.innerHTML = `
		<h1 class="description__detail__title">${bookData.bookTitle}</h1>
        <div class="description__detail__info">${bookData.bookYear} • ${bookData.bookGenre} • ${bookData.bookAuthor} </div>
        <div class="description__detail__rate">
           <em>예상★${bookData.bookRate}</em> &nbsp; 평균★ ${bookData.bookRate}•${bookData.bookPage}</div>
	`
	contentDetail.innerHTML = `
                <div class="body__detail__top">
                    <span class="body__detail__name">기본 정보</span>
                    <a href="#" class="body__detail__more">더보기</a>
                </div>
                <div class="body__detail__info">
                    <p>${bookData.bookTitle}</p>        
                    <p>${bookData.bookYear} •  ${bookData.bookAuthor} • ${bookData.bookGenre}</p>        
                    <p>2시간 9분 • ${bookData.movieAge}</p>
                </div>
                <p class="body__detail__stroy">
                	${bookData.bookContent}    
                </p>        
	`
	
	commentDetail.innerHTML = 
	`
    <div class="body__detail__top">
  	  <span class="body__detail__name">출판사 제공 책 정보</span>
   	 <a href="#" class="body__detail__more">더보기</a>
    </div>
    <p class="body__detail__stroy">
    	${bookData.bookComment}
	</p> 
	`
	
	authorDetail.innerHTML = 
	`
	<div class="body__association__description__detail">
        <div class="association__description__profile">
            <h4 class="association__description__profile__name">
               	${bookData.bookAuthor}
            </h4>
            <span class="association__description__profile__title">감독</span>
        </div>
    </div>
	`
}
	

	
	

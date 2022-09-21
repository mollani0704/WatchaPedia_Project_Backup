const address = window.location.href
console.log(address);
const movieNumber = address.split('/')[4];

getmovie(movieNumber);

function getmovie(movieNumber) {
	$.ajax({
		async: false,
		type: "get",
		url: `/api/v1/content/movie/${movieNumber}`,
		dataType: "json",
		success: (response) => {
			console.log(response.data);
			movieDetail(response.data);
		}
	})
}

function movieDetail(movieData) {
	const test = document.querySelector('.test');
	const headerPoster = document.querySelector(".header__description__poster");
	const headerDetail = document.querySelector(".header__description__detail");
	const contentDetail = document.querySelector(".contents__body__detail");

	test.innerHTML = `
		<img class="top__image" src="${movieData.moviePoster}" alt="">
	`

	headerPoster.innerHTML = `
		<img src="${movieData.moviePoster}">
	`
	
	headerDetail.innerHTML = `
		<h1 class="description__detail__title">${movieData.movieTitle}</h1>
        <div class="description__detail__info">${movieData.movieYear} • ${movieData.movieGenre} • ${movieData.movieOrigin} </div>
        <div class="description__detail__rate">
           <em>예상★${movieData.movieRate}</em> &nbsp; 평균★ ${movieData.movieRate}(3,564명)
        </div>
	`
	contentDetail.innerHTML = `
                <div class="body__detail__top">
                    <span class="body__detail__name">기본 정보</span>
                    <a href="#" class="body__detail__more">더보기</a>
                </div>
                <div class="body__detail__info">
                    <p>${movieData.movieTitle}</p>        
                    <p>${movieData.movieYear} •  ${movieData.movieOrigin} • ${movieData.movieGenre}</p>        
                    <p>2시간 9분 • ${movieData.movieAge}</p>
                </div>
                <p class="body__detail__stroy">
                	${movieData.movieContent}    
                </p>        
	`
}
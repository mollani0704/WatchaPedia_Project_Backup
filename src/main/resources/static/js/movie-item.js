const address = window.location.href
const movieNumber = address.split('/')[4];
const wishButton = document.querySelector('.wish__button');

console.log(address);
console.log(movieNumber);

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
			getMoviePeople(movieNumber);
			getSimilarMovieList(response.data.movieGenre, movieNumber);
		}
	})
}


function getMoviePeople(movieNumber) {
	$.ajax({
		async: false,
		type: "get",
		url: `/api/v1/content/moviePeople/${movieNumber}`,
		dataType: "json",
		success: (response) => {
			console.log(response.data);
			moviePersonDetail(response.data);
		}
	})
}

function getSimilarMovieList(genre, movieNumber) {
	$.ajax({
		async: false,
		type: "get",
		url: `/api/v1/content/similarMovie/${genre}/${movieNumber}`,
		dataType: "json",
		success: (response) => {
			console.log(response.data);
			similarMovieList(response.data);
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

function moviePersonDetail(personData) {
	const associationBox = document.querySelector('.body__association__title__wrap');
	
	for(let person of personData) {
		const listContent = `
			<div class="body__association__description__detail">
                <div class="body__association__description__imagebox">
                   <img
                    class="body__comment__bottom__image"
                    src="${person.personImg}"/>
                </div>
                <div class="association__description__profile">
                  <h4 class="association__description__profile__name">
                     ${person.personName}
                  </h4>
                </div>
            </div>
		`
		associationBox.innerHTML += listContent;
	}
	
}
function similarMovieList(similarMovie) {
	const similarityWrap = document.querySelector('.body__similarity__detail__wrap');
		
	for(data of similarMovie) {
		const similarList = `
			<div class="body__similarity__detail">
               	<div class="body__similarity__poster">
                   	<img
                     class="body__similarity__posterimg"
                     src="${data.moviePoster}"/>
                </div>
            	<div class="body__similarity__contents">
                	<h3 class="similarity__contents__title">${data.movieTitle}</h3>
                	<span class="similarity__contents__rate">${data.movieYear}</span>
                	<span class="similarity__contents__category">${data.movieOrigin}</span>
              	</div>
           	</div>
		`
		similarityWrap.innerHTML += similarList;
	}
}

wishButton.onclick = () => {
	if(user) {
		alert("유저 있음")
	} else {
		alert("유저없음")
	}
}
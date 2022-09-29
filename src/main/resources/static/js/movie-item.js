const address = window.location.href
console.log(address);
const movieNumber = address.split('/')[4];

getmovie(movieNumber);
getMoviePeople(movieNumber);

function getmovie(movieNumber) {
	$.ajax({
		async: false,
		type: "get",
		url: `/api/v1/content/movie/${movieNumber}`,
		dataType: "json",
		success: (response) => {
			console.log(response.data);
			movieDetail(response.data);
			getSimilarMovieList(response.data.movieGenre)
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

function getSimilarMovieList(genre) {
	$.ajax({
		async: false,
		type: "get",
		url: `/api/v1/content/similarMovie/${genre}`,
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
	
	associationBox.innerHTML = `
		    <div class="body__association__description__detail">
                            <div class="body__association__description__imagebox">
                                <img
                                    class="body__comment__bottom__image"
                                    src="${personData[0].personImg}"
                                />
                            </div>
                            <div class="association__description__profile">
                                <h4 class="association__description__profile__name">
                                    ${personData[0].personName}
                                </h4>
                           
                            </div>
                        </div>
                        <div class="body__association__description__detail">
                            <div class="body__association__description__imagebox">
                                <img
                                    class="body__comment__bottom__image"
                                    src="${personData[1].personImg}"
                                />
                            </div>
                            <div class="association__description__profile">
                                <h4 class="association__description__profile__name">
                                    ${personData[1].personName}
                                </h4>
                               
                            </div>
                        </div>
                        <div class="body__association__description__detail">
                            <div class="body__association__description__imagebox">
                                <img
                                    class="body__comment__bottom__image"
                                    src="${personData[2].personImg}"
                                />
                            </div>
                            <div class="association__description__profile">
                                <h4 class="association__description__profile__name">
                                    ${personData[2].personName}
                                </h4>
                                
                            </div>
                        </div>
                        <div class="body__association__description__detail">
                            <div class="body__association__description__imagebox">
                                <img
                                    class="body__comment__bottom__image"
                                    src="${personData[3].personImg}"
                                />
                            </div>
                            <div class="association__description__profile">
                                <h4 class="association__description__profile__name">
                                    ${personData[3].personName}
                                </h4>
                               
                            </div>
                        </div>
                        <div class="body__association__description__detail">
                            <div class="body__association__description__imagebox">
                                <img
                                    class="body__comment__bottom__image"
                                    src="${personData[4].personImg}"
                                />
                            </div>
                            <div class="association__description__profile">
                                <h4 class="association__description__profile__name">
                                    ${personData[4].personName}
                                </h4>
       
                            </div>
                        </div>
	`
}

function similarMovieList(data) {
	const similarityWrap = document.querySelector('.body__similarity__detail__wrap');
	
	similarityWrap.innerHTML = `
	 					<div class="body__similarity__detail">
                            <div class="body__similarity__poster">
                                <img
                                    class="body__similarity__posterimg"
                                    src="${data[0].moviePoster}"
                                />
                            </div>
                            <div class="body__similarity__contents">
                                <h3 class="similarity__contents__title">${data[0].movieTitle}</h3>
                                <span class="similarity__contents__rate">${data[0].movieYear}</span>
                                <span class="similarity__contents__category">${data[0].movieOrigin}</span>
                            </div>
                        </div>
                        
                        <div class="body__similarity__detail">
                            <div class="body__similarity__poster">
                                <img
                                    class="body__similarity__posterimg"
                                    src="${data[1].moviePoster}"
                                />
                            </div>
                            <div class="body__similarity__contents">
                                <h3 class="similarity__contents__title">${data[1].movieTitle}</h3>
                                <span class="similarity__contents__rate">${data[1].movieYear}</span>
                                <span class="similarity__contents__category">${data[1].movieOrigin}</span>
                            </div>
                        </div>
                        
                        <div class="body__similarity__detail">
                            <div class="body__similarity__poster">
                                <img
                                    class="body__similarity__posterimg"
                                    src="${data[2].moviePoster}"
                                />
                            </div>
                            <div class="body__similarity__contents">
                                <h3 class="similarity__contents__title">${data[2].movieTitle}</h3>
                                <span class="similarity__contents__rate">${data[2].movieYear}</span>
                                <span class="similarity__contents__category">${data[2].movieOrigin}</span>
                            </div>
                        </div>
                        
                        <div class="body__similarity__detail">
                            <div class="body__similarity__poster">
                                <img
                                    class="body__similarity__posterimg"
                                    src="${data[3].moviePoster}"
                                />
                            </div>
                            <div class="body__similarity__contents">
                                <h3 class="similarity__contents__title">${data[3].movieTitle}</h3>
                                <span class="similarity__contents__rate">${data[3].movieYear}</span>
                                <span class="similarity__contents__category">${data[3].movieOrigin}</span>
                            </div>
                        </div>
                        
                        <div class="body__similarity__detail">
                            <div class="body__similarity__poster">
                                <img
                                    class="body__similarity__posterimg"
                                    src="${data[4].moviePoster}"
                                />
                            </div>
                            <div class="body__similarity__contents">
                                <h3 class="similarity__contents__title">${data[4].movieTitle}</h3>
                                <span class="similarity__contents__rate">${data[4].movieYear}</span>
                                <span class="similarity__contents__category">${data[4].movieOrigin}</span>
                            </div>
                        </div>
                        
                        <div class="body__similarity__detail">
                            <div class="body__similarity__poster">
                                <img
                                    class="body__similarity__posterimg"
                                    src="${data[5].moviePoster}"
                                />
                            </div>
                            <div class="body__similarity__contents">
                                <h3 class="similarity__contents__title">${data[5].movieTitle}</h3>
                                <span class="similarity__contents__rate">${data[5].movieYear}</span>
                                <span class="similarity__contents__category">${data[5].movieOrigin}</span>
                            </div>
                        </div>
                        
                        <div class="body__similarity__detail">
                            <div class="body__similarity__poster">
                                <img
                                    class="body__similarity__posterimg"
                                    src="${data[6].moviePoster}"
                                />
                            </div>
                            <div class="body__similarity__contents">
                                <h3 class="similarity__contents__title">${data[6].movieTitle}</h3>
                                <span class="similarity__contents__rate">${data[6].movieYear}</span>
                                <span class="similarity__contents__category">${data[6].movieOrigin}</span>
                            </div>
                        </div>
                        
                     `
	
}
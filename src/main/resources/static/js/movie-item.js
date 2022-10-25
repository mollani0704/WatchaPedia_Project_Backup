const address = window.location.href;
const movieNumber = address.split('/')[5];
const wishButton = document.querySelector('.wish__check');
const commentButton = document.querySelector('.comment__button');
const commentBox = document.querySelector('.content__body__comment');
const commentInsertButton = document.querySelector('.insert__comment');
const comment = document.querySelector('#comment');
const star = document.querySelectorAll('input[type="radio"]');



console.log(address);
console.log(movieNumber);

getmovie(movieNumber);

function getmovie(movieNumber) {
    $.ajax({
        async: false,
        type: 'get',
        url: `/api/v1/content/movie/${movieNumber}`,
        dataType: 'json',
        success: response => {
            console.log(response.data);
            movieDetail(response.data);
            getMoviePeople(movieNumber);
            getSimilarMovieList(response.data.movieGenre, movieNumber);
            getComment(movieNumber);
        },
    });
}

function getComment(movieNumber) {
    $.ajax({
        async: false,
        type: 'get',
        url: `/api/v1/comment/select/${movieNumber}`,
        dataType: 'json',
        success: response => {
            console.log(response.data);
            showMovieComment(response.data);
        },
    });
}

function getMoviePeople(movieNumber) {
    $.ajax({
        async: false,
        type: 'get',
        url: `/api/v1/content/moviePeople/${movieNumber}`,
        dataType: 'json',
        success: response => {
            console.log(response.data);
            moviePersonDetail(response.data);
        },
    });
}

function getSimilarMovieList(genre, movieNumber) {
    $.ajax({
        async: false,
        type: 'get',
        url: `/api/v1/content/similarMovie/${genre}/${movieNumber}`,
        dataType: 'json',
        success: response => {
            console.log(response.data);
            similarMovieList(response.data);
            getSimilarMovieCode(response.data);
        },
    });
}

function movieDetail(movieData) {
    const test = document.querySelector('.test');
    const headerPoster = document.querySelector('.header__description__poster');
    const headerDetail = document.querySelector('.header__description__detail');
    const contentDetail = document.querySelector('.contents__body__detail');

    test.innerHTML = `
		<img class="top__image" src="${movieData.movieBanner}" alt="">
		`;

    headerPoster.innerHTML = `
		<img src="${movieData.moviePoster}">
	`;

    headerDetail.innerHTML = `
		<h1 class="description__detail__title">${movieData.movieTitle}</h1>
        <div class="description__detail__info">${movieData.movieYear} • ${movieData.movieGenre} • ${movieData.movieOrigin} </div>
        <div class="description__detail__rate">
           <em>예상★${movieData.movieRate}</em> &nbsp; 평균★ ${movieData.movieRate}(3,564명)
        </div>
	`;
    contentDetail.innerHTML = `
                <div class="body__detail__top">
                    <span class="body__detail__name">기본 정보</span>
                    <a href="#" class="body__detail__more__link">더보기</a>
                    <div class="hidden__button__information">${movieData.movieCode}</div>
                </div>
                <div class="body__detail__info">
                    <p>${movieData.movieTitle}</p>        
                    <p>${movieData.movieYear} •  ${movieData.movieOrigin} • ${movieData.movieGenre}</p>        
                    <p>2시간 9분 • ${movieData.movieAge}</p>
                </div>
                <p class="body__detail__stroy">
                	${movieData.movieContent}    
                </p>        
	`;
}



const button = document.querySelector('.body__detail__more__link');

button.onclick= () => {
	const moreNumber = document.querySelector('.hidden__button__information').textContent;
	
	location.href = `/movie/information/${moreNumber}`;		
}



function moviePersonDetail(personData) {
    const associationBox = document.querySelector('.body__association__title__wrap');

    for (let person of personData) {
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
		`;
        associationBox.innerHTML += listContent;
    }
}

function similarMovieList(similarMovie) {
    const similarityWrap = document.querySelector('.body__similarity__detail__wrap');

    for (data of similarMovie) {
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
           	</div>
		`;
        similarityWrap.innerHTML += similarList;
    }
}

function getSimilarMovieCode(similarMovie) {
	const similarMovieItems = document.querySelectorAll('.body__similarity__detail');
	
	for(let i = 0 ; i < similarMovieItems.length; i++) {
		similarMovieItems[i].onclick = () => {
			const title = similarMovieItems[i].querySelector('h3').innerText;
			
			if(similarMovie[i].movieTitle == title) {
				location.href = `/movie/detail/${similarMovie[i].movieCode}`; 
			} else {
				console.log('error')
			}
		}
	}
}

function showMovieComment(movieCommentData) {
    const commentWrap = document.querySelector('.movie__comment__wrap');

    for (let comment of movieCommentData) {
        const commentForm = `
			<li class="body__comment__bottom">
	            <div class=".body__comment__bottom__title">
	                <div class="body__comment__bottom__reviewer">
	                    <div class="comment__bottom__reviewer">
	                        <div class="body__comment__bottom__imagebox">
	                            <img
	                                class="body__comment__bottom__image"
	                                src="/static/images/defaultProfilePhoto.jpg"
	                            />
	                        </div>
	                        <div class="body__comment__bottom__person">${comment.userName}</div>
	                    </div>
	                </div>
	            </div>
	            <p class="body__comment__bottom__description">
	                ${comment.comment}
	            </p>
	        </li>
		`;
        commentWrap.innerHTML += commentForm;
    }
}

wishButton.onclick = () => {
    if (user == null || user == undefined) {
        alert('로그인 필요');
        location.href = '/signin';
    } else {
        if (wishButton.checked) {
            $.ajax({
                async: false,
                type: 'get',
                url: `/api/v1/wish/insert/${user.user_code}/${movieNumber}`,
                dataType: 'json',
                success: response => {
                    console.log(response);
                },
            });
        } else {
            $.ajax({
                async: false,
                type: 'get',
                url: `/api/v1/wish/delete/${user.user_code}/${movieNumber}`,
                dataType: 'json',
                success: response => {
                    console.log(response);
                },
            });
        }
        console.log(wishButton.checked);
        console.log(user.user_code);
        console.log(movieNumber);
    }
};

commentButton.onclick = () => {
    if (user == null || user == undefined) {
        alert('로그인 필요');
        location.href = '/signin';
    } else {
        commentBox.style.display = 'block';
    }
    console.log('test');
};

commentInsertButton.onclick = () => {
    console.log(comment.value);
    let commentData = {
        userCode: user.user_code,
        movieCode: movieNumber,
        comment: comment.value,
    };

    $.ajax({
        async: false,
        type: 'post',
        url: '/api/v1/comment/insert',
        contentType: 'application/json',
        data: JSON.stringify(commentData),
        dataType: 'json',
        success: response => {
            if (response.data) {
                alert('코멘트가 등록되었습니다.');
                location.reload()
            }
        },
    });
};

let score = 0;

for(let i = 0; i < star.length; i++) {
	star[i].addEventListener('click', () => {
		
		if (user == null || user == undefined) {
        alert('로그인 필요');
        location.href = '/signin';
    	
    	} else {
			
			let data = {
				movieCode : movieNumber,
				userCode : user.user_code,
				ratingScore: star[i].value
			};
	
			$.ajax({
				async: false,
				type: 'post',
				url: `/api/v1/movie/rating`,
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: response => {
					if(response.data) {						
					alert("평점이 등록되었습니다.")
					}
				}
				
			})
		}
	})
}

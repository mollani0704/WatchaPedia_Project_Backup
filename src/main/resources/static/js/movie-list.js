load();

function load() {
	$.ajax({
		async: false,
		type: "get",
		url: "/api/v1/content/movie",
		dataType:"json",
		success: (response) => {
			console.log(response.data);
			if(response.data != null) {
				getMovieList(response.data)
			}
		},
		
		error: (error) => {
			console.log(error);
		}
	})
}

function getMovieList(movieData) {
	const movieItems = document.querySelector(".mainList__items");
	movieItems.innerHTML = "";
	movieData.forEach(movie => {
		movieItems.innerHTML += `
		<div class="mainList__item">
			<div class="mainList__item__image">
				<img src="${movie.moviePoster}" alt="" />
			</div>
			<div class="mainList__item__number">${movie.movieCode}</div>
			<div class="mainList__item__description">
				<div class="item__title">${movie.movieTitle}</div>
				<div class="item__year__country">${movie.movieYear}•${movie.movieOrigin}</div>
			</div>
		</div>	`
	});
}

const movieItem = document.querySelectorAll('.mainList__item');
	
movieItem.forEach(movie => {
	movie.onclick = () => {
		const movieNumber = movie.querySelector('.mainList__item__number').textContent;
		
		console.log(movieNumber);	
		location.href = `/movie/detail/${movieNumber}`;			
	}
 })

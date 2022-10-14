const address = window.location.href
const dramaNumber = address.split('/')[5];
const wishButton = document.querySelector('.wish__check');
const commentButton = document.querySelector('.comment__button');
const commentBox = document.querySelector('.content__body__comment');
const commentInsertButton = document.querySelector('.insert__comment');
const comment = document.querySelector('#comment');

console.log(address);
console.log(dramaNumber);

getDrama(dramaNumber);

function getDrama(dramaNumber) {
	$.ajax({
		async: false,
		type: "get",
		url: `/api/v1/content/drama/${dramaNumber}`,
		dataType: "json",
		success: (response) => {
			console.log(response.data);
			dramaDetail(response.data);
			getDramaPeople(dramaNumber);
			getSimilarDramaList(response.data.dramaGenre, dramaNumber);
			getComment(dramaNumber);
		}
	})
}

function getComment(dramaNumber) {
	$.ajax({
		async: false,
		type: 'get',
		url: `/api/v1/comment/select/${dramaNumber}`,
		dataType: 'json',
		success: response => {
			console.log(response.data);
		}
	})
}

function getDramaPeople(dramaNumber) {
	$.ajax({
		async: false,
		type: "get",
		url: `/api/v1/content/dramaPeople/${dramaNumber}`,
		dataType: "json",
		success: (response) => {
			console.log(response.data);
			dramaPersonDetail(response.data);
		}
	})
}

function getSimilarDramaList(dramaGenre, dramaNumber) {
	$.ajax({
		async: false,
		type: "get",
		url:`/api/v1/content/similarDrama/${dramaGenre}/${dramaNumber}`,
		dataType: "json",
		success: (response) => {
			console.log(response.data);
			similarDramaList(response.data);
		}
	})
}


function dramaDetail(dramaData) {
	const test = document.querySelector('.test');
	const headerPoster = document.querySelector(".header__description__poster");
	const headerDetail = document.querySelector(".header__description__detail");
	const contentDetail = document.querySelector(".contents__body__detail");
	
	test.innerHTML = `
		<img class="top__image" src="${dramaData.dramaBanner}" alt="">
		`

	headerPoster.innerHTML = `
		<img src="${dramaData.dramaPoster}">
	`

	headerDetail.innerHTML = `                            
		<h1 class="description__detail__title">${dramaData.dramaTitle}</h1>
	    <div class="description__detail__info">${dramaData.dramaYear}•${dramaData.dramaGenre}•${dramaData.dramaCompany}</div>
	    <div class="description__detail__rate">
	        <em>${dramaData.dramaRate}</em>
	    </div>
	`
	
    contentDetail.innerHTML = `
                <div class="body__detail__top">
                    <span class="body__detail__name">기본 정보</span>
                    <a href="#" class="body__detail__more__link">더보기</a>
                    <div class="hidden__button__information">${dramaData.dramaCode}</div>
                </div>
                <div class="body__detail__info">
                    <p>${dramaData.dramaTitle}</p>        
                    <p>${dramaData.dramaYear} •  ${dramaData.dramaCompany} • ${dramaData.dramaGenre}</p>        
                    <p>2시간 9분 • ${dramaData.dramaAge}</p>
                </div>
                <p class="body__detail__stroy">
                	${dramaData.dramaContent}    
                </p>        
	`;
}

const button = document.querySelector('.body__detail__more__link');

button.onclick= () => {
	const moreNumber = document.querySelector('.hidden__button__information').textContent;
	
	location.href = `/drama/information/${moreNumber}`;		
}



function dramaPersonDetail(personData) {
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

function similarDramaList(similarDrama) {
	const similarityWrap = document.querySelector('.body__similarity__detail__wrap');
		
	for(data of similarDrama) {
		const similarList = `
			<div class="body__similarity__detail">
               	<div class="body__similarity__poster">
                   	<img
                     class="body__similarity__posterimg"
                     src="${data.dramaPoster}"/>
                </div>
            	<div class="body__similarity__contents">
                	<h3 class="similarity__contents__title">${data.dramaTitle}</h3>
                	<span class="similarity__contents__rate">${data.dramaYear}</span>
                	<span class="similarity__contents__category">${data.dramaCompany}•${data.dramaGenre}</span>
              	</div>
           	</div>
		`
		similarityWrap.innerHTML += similarList;
	}
}

wishButton.onclick = () => {
	if(user == null || user == undefined) {
		alert("로그인 필요");
		location.href = '/signin';
	} else {
		alert('유저 있음');
		if(wishButton.checked) {
			$.ajax({
				async: false,
				type: "get",
				url: `/api/v1/wish/drama/insert/${user.user_code}/${dramaNumber}`,
				dataType: 'json',
				success: response => {
					console.log(response);
				}
			});
		} else {
			$.ajax({
				async: false,
				type: "get",
				url:  `/api/v1/wish/drama/delete/${user.user_code}/${dramaNumber}`,
				dataType: 'json',
				success: response => {
					console.log(response);
				}
			})
		}
	}
}

commentButton.onclick = () => {
	if(user = null || user == undefined) {
		alert('로그인 필요');
		location.href = '/signin';
	} else {
		commentBox.style.display = 'block'
	}
}

commentInsertButton.onclick = () => {
	  let commentData = {
        userCode: user.user_code,
       	dramaCode: dramaNumber,
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
    
    
}

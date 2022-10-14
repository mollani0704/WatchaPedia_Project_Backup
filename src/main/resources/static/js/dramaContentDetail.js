const address = window.location.href;
const moreNumber = address.split('/')[5];
getInformation(moreNumber);

function getInformation(moreNumber) {
    $.ajax({
        async: false,
        type: 'get',
        url: `/api/v1/content/dramaInformation/${moreNumber}`,
        dataType: 'json',
        success: response => {
            informationDetail(response.data);
        },
    });
}

function informationDetail(Info) {

    const contentDetail = document.querySelector('.contents__inner__main');

    contentDetail.innerHTML = `
                
          <ul class="contents__lists">
                        <dl class="each__lists__box">
                            <dt class="each__lists__title">원제</dt>
                            <dd class="each__lists__content">${Info.dramaTitle}</dd>
                        </dl>
                        <dl class="each__lists__box">
                            <dt class="each__lists__title">제작 연도</dt>
                            <dd class="each__lists__content">${Info.dramaYear}</dd>
                        </dl>
                        <dl class="each__lists__box">
                            <dt class="each__lists__title">제작사</dt>
                            <dd class="each__lists__content">${Info.dramaCompany}</dd>
                        </dl>
                        <dl class="each__lists__box">
                            <dt class="each__lists__title">장르</dt>
                            <dd class="each__lists__content">${Info.dramaGenre}</dd>
                        </dl>
                        <dl class="each__lists__box">
                            <dt class="each__lists__title">평점</dt>
                            <dd class="each__lists__content">${Info.dramaRate}</dd>
                        </dl>
                        <dl class="each__lists__box">
                            <dt class="each__lists__title">연령 등급</dt>
                            <dd class="each__lists__content">${Info.dramaAge}</dd>
                        </dl>
                        <dl class="each__lists__box__last">
                            <dt class="each__lists__title__last">내용</dt>
                            <dd class="each__lists__content__last">
                                ${Info.dramaContent}
                            </dd>
                        </dl>
                    </ul>       
                
                
	`;
}

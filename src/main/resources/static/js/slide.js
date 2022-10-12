const slides = document.querySelector('.mainList__items');
const slide = document.querySelectorAll('.mainList__item');
const prevButton = document.querySelector('.prev');
const nextButton = document.querySelector('.next');

let slideCount = slide.length;

let currentIndex = 0;
let slideWidth = 238;
let slideMargin = 8;

slides.style.width = (slideWidth + slideMargin) * slideCount - slideMargin + 'px';

function moveSlide(number) {
    slides.style.left = -number * 238 + 'px';
    currentIndex = number;
}

nextButton.addEventListener('click', () => {
    if (currentIndex < slideCount - 3) {
        moveSlide(currentIndex + 1);
        
    }
});

prevButton.addEventListener('click', () => {
    if (currentIndex > 0) {
        moveSlide(currentIndex - 1);
       
    }
});



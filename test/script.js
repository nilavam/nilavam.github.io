const sections = document.querySelectorAll('main section');
sections.forEach(section => {
    section.style.opacity = 0;
});

window.addEventListener('scroll', () => {

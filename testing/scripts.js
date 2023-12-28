document.addEventListener("DOMContentLoaded", function () {
    // Dark mode toggle functionality
    const darkModeToggle = document.getElementById("darkModeToggle");
    const body = document.body;

    darkModeToggle.addEventListener("change", function () {
        body.classList.toggle("dark-mode");
    });

    // Mobile navigation toggle functionality
    const mobileNavToggle = document.getElementById("mobileNavToggle");
    const nav = document.querySelector("nav");

    mobileNavToggle.addEventListener("click", function () {
        nav.classList.toggle("show-mobile-nav");
    });
});

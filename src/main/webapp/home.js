// script.js

window.addEventListener("scroll", function() {
    const brand = document.getElementById("brand");
    if (window.scrollY > 100) {
        brand.classList.add("scrolled-brand");
    } else {
        brand.classList.remove("scrolled-brand");
    }
});

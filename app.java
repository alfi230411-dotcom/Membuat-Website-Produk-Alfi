document.addEventListener("DOMContentLoaded", function () {
    
    // ==========================================
    // 1. EFEK SHADOW PADA NAVBAR SAAT DI-SCROLL
    // ==========================================
    const navbar = document.querySelector(".navbar");

    window.addEventListener("scroll", function () {
        if (window.scrollY > 50) {
            navbar.classList.add("scrolled");
        } else {
            navbar.classList.remove("scrolled");
        }
    });

    // ==========================================
    // 2. TUTUP MENU MOBILE OTOMATIS SAAT LINK DIKLIK
    // ==========================================
    const menuToggle = document.getElementById("menu-toggle");
    const navLinks = document.querySelectorAll(".nav-links a");

    navLinks.forEach(link => {
        link.addEventListener("click", function () {
            if (menuToggle && menuToggle.checked) {
                menuToggle.checked = false;
            }
        });
    });

    // ==========================================
    // 3. SMOOTH SCROLLING UNTUK NAVIGASI LINK
    // ==========================================
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener("click", function (e) {
            const targetId = this.getAttribute("href");
            
            if (targetId === "#") return;

            const targetElement = document.querySelector(targetId);
            if (targetElement) {
                e.preventDefault();
                targetElement.scrollIntoView({
                    behavior: "smooth",
                    block: "start"
                });
            }
        });
    });

    // ==========================================
    // 4. AUTO-SCROLL CAROUSEL (BANNER OTOMATIS)
    // ==========================================
    const carouselSlide = document.querySelector(".carousel-slide");
    
    if (carouselSlide) {
        const slideItems = carouselSlide.querySelectorAll(".carousel-item");
        let currentIndex = 0;

        function autoSlide() {
            currentIndex++;
            if (currentIndex >= slideItems.length) {
                currentIndex = 0;
            }
            
            const itemWidth = slideItems[0].clientWidth;
            carouselSlide.scrollTo({
                left: itemWidth * currentIndex,
                behavior: "smooth"
            });
        }

        // Bergeser otomatis setiap 4 detik
        let slideInterval = setInterval(autoSlide, 4000);

        // Berhenti otomatis jika kursor diarahkan ke banner
        carouselSlide.addEventListener("mouseenter", () => {
            clearInterval(slideInterval);
        });

        // Berjalan lagi saat kursor menjauh
        carouselSlide.addEventListener("mouseleave", () => {
            slideInterval = setInterval(autoSlide, 4000);
        });
    }

});
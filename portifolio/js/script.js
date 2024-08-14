/*Mudar menu hamburguer*/

const menuHamburguer = document.querySelector('.menu-hamburguer');
menuHamburguer.addEventListener('click', () => {
    toggleMenu();
});

function toggleMenu () {
    const nav = document.querySelector('.nav-responsive');
    menuHamburguer.classList.toggle('change');

    if (menuHamburguer.classList.contains('change')) {
        nav.style.display = 'block';
    } else {
        nav.style.display = 'none';
    }
};

document.getElementById('read-more').addEventListener('click', function(event) {
    event.preventDefault();  // Evita o comportamento padrão do link
    const moreText = document.querySelector('.more-text');
    const btnText = document.getElementById('read-more');

    if (moreText.style.display === 'none') {
        moreText.style.display = 'inline';
        btnText.textContent = 'Ler Menos';
    } else {
        moreText.style.display = 'none';
        btnText.textContent = 'Ler Mais';
    }
});

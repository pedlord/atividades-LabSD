// Visualizar imagem, texto ou vídeo
document.getElementById('viewImageBtn').addEventListener('click', function() {
    const fileContainer = document.getElementById('fileContainer');
    fileContainer.innerHTML = '';
    const img = document.createElement('img');
    img.src = 'ICEN.png';
    img.alt = 'Imagem';
    fileContainer.appendChild(img);
});

document.getElementById('viewTextBtn').addEventListener('click', function() {
    const fileContainer = document.getElementById('fileContainer');
    fileContainer.innerHTML = '';
    const pre = document.createElement('pre');
    pre.textContent = 'Visualizando textos e textos, e mais textos.\n';
    fileContainer.appendChild(pre);
});

document.getElementById('viewVideoBtn').addEventListener('click', function() {
    const fileContainer = document.getElementById('fileContainer');
    fileContainer.innerHTML = '';
    const video = document.createElement('video');
    video.src = 'https://www.w3schools.com/html/mov_bbb.mp4'; 
    video.controls = true;
    fileContainer.appendChild(video);
});

// Função para resolver uma equação do 2º grau
document.getElementById('solveQuadraticBtn').addEventListener('click', function() {
    const a = parseFloat(document.getElementById('a').value);
    const b = parseFloat(document.getElementById('b').value);
    const c = parseFloat(document.getElementById('c').value);
    const resultElement = document.getElementById('quadraticResult');

    if (isNaN(a) || isNaN(b) || isNaN(c)) {
        resultElement.textContent = 'Por favor, insira coeficientes válidos!';
        return;
    }

    const discriminant = b * b - 4 * a * c;
    
    if (discriminant > 0) {
        const root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        const root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        resultElement.textContent = `Raízes Reais: ${root1.toFixed(2)} e ${root2.toFixed(2)}`;
    } else if (discriminant === 0) {
        const root = -b / (2 * a);
        resultElement.textContent = `Raiz Real: ${root.toFixed(2)}`;
    } else {
        resultElement.textContent = 'Não há raízes reais.';
    }
});

// Função para gerar números aleatórios e ordená-los
document.getElementById('generateAndSortBtn').addEventListener('click', function() {
    const size = parseInt(document.getElementById('arraySize').value);
    const originalArrayElement = document.getElementById('originalArray');
    const sortedArrayElement = document.getElementById('sortedArray');

    if (isNaN(size) || size <= 0) {
        originalArrayElement.textContent = 'Por favor, insira um número válido!';
        return;
    }

    let numbers = Array.from({ length: size }, () => Math.floor(Math.random() * 100));

    originalArrayElement.textContent = `Números Gerados: ${numbers.join(', ')}`;

    //Bubble Sort
    for (let i = 0; i < numbers.length - 1; i++) {
        for (let j = 0; j < numbers.length - i - 1; j++) {
            if (numbers[j] > numbers[j + 1]) {
                [numbers[j], numbers[j + 1]] = [numbers[j + 1], numbers[j]];
            }
        }
    }

    sortedArrayElement.textContent = `Números Ordenados: ${numbers.join(', ')}`;
});

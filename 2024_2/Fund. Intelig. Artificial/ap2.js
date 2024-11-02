const tamanhoPopulacao = 500;
const mutationRate = 0.01; // 1%
const geracoes = 100;

 // cidades aleatorias
let cidades = [
    { nome: "Porto Alegre", coords: [-30.0346, -51.2177] },
    { nome: "Caxias do Sul", coords: [-29.1639, -51.1795] },
    { nome: "Pelotas", coords: [-31.7683, -52.3420] },
    { nome: "Santa Maria", coords: [-29.6869, -53.8008] },
    { nome: "Uruguaiana", coords: [-29.9707, -57.0933] },
    { nome: "Bagé", coords: [-31.3295, -54.0966] },
    { nome: "Novo Hamburgo", coords: [-29.6868, -51.1303] },
    { nome: "Gravataí", coords: [-29.9499, -50.9947] },
    { nome: "Canela", coords: [-29.3580, -50.8111] },
    { nome: "Gramado", coords: [-29.3702, -50.8105] },
    { nome: "Tapes", coords: [-30.1827, -51.4311] },
    { nome: "Capão da Canoa", coords: [-29.9736, -50.2234] },
    { nome: "São Leopoldo", coords: [-29.0165, -51.2192] },
    { nome: "Rio Grande", coords: [-32.0374, -52.0957] },
    { nome: "Santa Cruz do Sul", coords: [-29.9652, -52.4292] },
    { nome: "Ijuí", coords: [-28.3684, -53.9144] },
    { nome: "Passo Fundo", coords: [-28.2541, -52.4064] },
    { nome: "Alvorada", coords: [-30.0456, -51.0494] },
    { nome: "Esteio", coords: [-29.9710, -51.2021] },
    { nome: "Lajeado", coords: [-29.4546, -51.9648] },
    { nome: "Santana do Livramento", coords: [-30.8896, -55.5337] },
    { nome: "Veranópolis", coords: [-29.0872, -51.3004] },
    { nome: "Erechim", coords: [-27.6461, -52.2701] },
    { nome: "São Borja", coords: [-28.6521, -56.0162] },
];

// calculo da distância entre dois pontos usando a formula de Haversine
function calculoDistanciaEntrPontos(cidadeA, cidadeB) {
    const R = 6371; // raio da terra em kms
    const dLat = (cidadeB[0] - cidadeA[0]) * Math.PI / 180;
    const dLon = (cidadeB[1] - cidadeA[1]) * Math.PI / 180;

    const a =
        Math.sin(dLat / 2) * Math.sin(dLat / 2) +
        Math.cos(cidadeA[0] * Math.PI / 180) * Math.cos(cidadeB[0] * Math.PI / 180) *
        Math.sin(dLon / 2) * Math.sin(dLon / 2);
    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return R * c; // distanc. em kms
}

// func. para criar um novo individuo
function criarIndividuo() {
    let individuo = [];
    let listaCidades = JSON.parse(JSON.stringify(cidades));
    while (listaCidades.length > 0) {
        const cidadeEscolhida = Math.floor(Math.random() * listaCidades.length);
        individuo.push(listaCidades[cidadeEscolhida]);
        listaCidades.splice(cidadeEscolhida, 1);
    }
    return individuo;
}

// func. para criar uma população inicial
function criarPopulacao(tamanho) {
    const populacao = [];
    for (let i = 0; i < tamanho; i++) {
        populacao.push(criarIndividuo());
    }
    return populacao;
}

// func de aptidão vulgo fitness
function aptidao(individuo) {
    let distancia = 0.0;
    for (let i = 0; i < individuo.length - 1; i++) {
        distancia += calculoDistanciaEntrPontos(individuo[i].coords, individuo[i + 1].coords);
    }
    distancia += calculoDistanciaEntrPontos(individuo[individuo.length - 1].coords, individuo[0].coords); // retorna a cidade inicial
    return 1 / distancia; // inverso da distância pq queremos minimizar a distância
}

// seleção por torneio
function selecao(populacao) {
    const torneio = [];
    for (let i = 0; i < 5; i++) {
        torneio.push(populacao[Math.floor(Math.random() * populacao.length)]);
    }
    torneio.sort((a, b) => aptidao(b) - aptidao(a));
    return torneio[0];
}

// func de cruzamento
function cruzamento(pai, mae) {
    const pontoInicio = Math.floor(Math.random() * pai.length);
    const pontoFim = Math.floor(Math.random() * (pai.length - pontoInicio)) + pontoInicio;

    const filho = new Array(pai.length).fill(null);
    for (let i = pontoInicio; i < pontoFim; i++) {
        filho[i] = pai[i];
    }

    let pos = pontoFim;
    for (let cidade of mae) {
        if (!filho.includes(cidade)) {
            if (pos >= filho.length) pos = 0;
            filho[pos] = cidade;
            pos++;
        }
    }
    return filho;
}

// func de mutação
function mutacao(individuo) {
    for (let i = 0; i < individuo.length; i++) {
        if (Math.random() < mutationRate) {
            const j = Math.floor(Math.random() * individuo.length);
            [individuo[i], individuo[j]] = [individuo[j], individuo[i]];
        }
    }
    return individuo;
}

// algoritmo genetico
function algoritmoGenetico() {
    let populacao = criarPopulacao(tamanhoPopulacao);
    let melhorDistanciaHistorico = []; // p/ rastrear distancias
    let geracaoMelhorCaminho = 0;

    for (let geracao = 0; geracao < geracoes; geracao++) {
        populacao.sort((a, b) => aptidao(b) - aptidao(a)); // ordenando pela aptidão
        const melhorIndividuo = populacao[0];
        const melhorDistancia = 1 / aptidao(melhorIndividuo);
        console.log(`Geração ${geracao + 1}: Melhor distância: ${melhorDistancia.toFixed(2)} km`);

        // verifica se a mesma distância foi encontrada mais de 100 vezes consecutivas
        if (melhorDistanciaHistorico.length >= 100 && melhorDistanciaHistorico[4] === melhorDistancia) {
            console.log("\nA mesma distância se repetiu por 100 vezes consecutivas.");
            break;
        }
        melhorDistanciaHistorico.push(melhorDistancia);
        if (melhorDistanciaHistorico.length > 5) {
            melhorDistanciaHistorico.shift(); // remove o mais antigo
        }

        if (melhorDistancia <= 10) { // critério de parada
            console.log("Solução satisfatória encontrada!");
            break;
        }

        geracaoMelhorCaminho = geracao + 1; // atualiza a geração do melhor caminho encontrado
        const novaPopulacao = [];
        while (novaPopulacao.length < tamanhoPopulacao) {
            const pai = selecao(populacao);
            const mae = selecao(populacao);
            let filho = cruzamento(pai, mae);
            filho = mutacao(filho);
            novaPopulacao.push(filho);
        }

        populacao = novaPopulacao; // atualiza a população com a nova geração
    }

    populacao.sort((a, b) => aptidao(b) - aptidao(a));
    const melhorIndividuoFinal = populacao[0];
    const menorDistanciaTotal = (1 / aptidao(melhorIndividuoFinal)).toFixed(2);
    
    // exibindo os resultados
    console.log("\nMelhor caminho encontrado:\n");
    melhorIndividuoFinal.forEach(cidade => {
        console.log(`\x1b[32m${cidade.nome}\x1b[0m`);
    });
    console.log(`\nMenor distância total: ${menorDistanciaTotal} km`);
    console.log(`\nPrimeira cidade: \x1b[32m${melhorIndividuoFinal[0].nome}\x1b[0m`);
    console.log(`\nÚltima cidade: \x1b[32m${melhorIndividuoFinal[melhorIndividuoFinal.length - 1].nome}\x1b[0m`);
    console.log(`\nGeração em que o melhor caminho foi encontrado: ${geracaoMelhorCaminho}`);
}

// executa o algoritmo genético
algoritmoGenetico();

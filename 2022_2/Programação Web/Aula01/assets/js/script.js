$(document).ready(()=>{

    $('section').load('pages/home.html')
    $('Home').addClass('active')

    function clearClass(params) {
        $('#menuHome').removeClass('active')
        $('#menuSobre').removeClass('active')
        $('#menuServicos').removeClass('active')
        $('#menuContato').removeClass('active')
        
        
    }

    $('#menuHome').click(()=>{
        $('section').load('pages/home.html')
    
    })

    $('#menuSobre').click(()=>{
        $('section').load('pages/sobre.html')
    
    })

    ('#menuServico').click(()=>{
        $('section').load('pages/servicos.html')
    
    })

    ('#menuCTT').click(()=>{
        $('section').load('pages/contato.html')
    
    })
})

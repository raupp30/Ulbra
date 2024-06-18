$(document).ready(()=>{

    $('article').load('pages/home.html')
    $('#menuHome').addClass('active')

    function clearClass(params) {
        $('#menuBR').removeClass('active')
        $('#menuInt').removeClass('active')
        $('#menuSelecoes').removeClass('active')
        $('#menuContato').removeClass('active')
        
        
    }

    $('#menuBR').click(()=>{
        clearClass()
        $('#menuBR').addClass('active')
        $('article').load('pages/BR.html')
    })

    $('#menuInt').click(()=>{
        clearClass()
        $('#menuInt').addClass('active')
        $('article').load('pages/int.html')
    })

    $('#menuSelecoes').click(()=>{
        clearClass()
        $('#menuSelecoes').addClass('active')
        $('article').load('pages/selecoes.html')
    })

    $('#menuContato').click(()=>{
        clearClass()
        $('#menuContato').addClass('active')
        $('article').load('pages/contato.html')
    })
   
   

})
$(document).ready(()=>{

    function clearClass(params) {
        $('#troca').removeClass('active')
        $('#trabalhe').removeClass('active')
        $('#portal').removeClass('active')
        $('#politica').removeClass('active')
        $('#clique').removeClass('active')
        
        
    }

    $('#troca').click(()=>{
        clearClass()
        $('#troca').addClass('active')
        $('footer').load('pages2/troca.html')
    })

   

})




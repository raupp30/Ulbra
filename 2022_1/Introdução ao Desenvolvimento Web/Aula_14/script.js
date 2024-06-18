$(document).ready(()=>{

    $('section').load('pages/home.html')
    $('#menuHome').addClass('active')

    function clearClass(params) {
        $('#menuRoad').removeClass('active')
        $('#menuMontainBike').removeClass('active')
        
        
    }

    $('#menuRoad').click(()=>{
        clearClass()
        $('#menuRoad').addClass('active')
        $('section').load('pages/road.html')
    })

    $('#menuMountainbike').click(()=>{
        clearClass()
        $('#menuMountainbike').addClass('active')
        $('section').load('pages/mountainbike.html')
    })

   

})




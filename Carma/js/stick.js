$(window).scroll(function() {
  var scrollTop = $(window).scrollTop();
  console.log("scrollTop>>>" + scrollTop);
  if (scrollTop == 0) {
   $("#miImagen").css({"margin-top": "0px"});
  } else {
   $("#miImagen").css({"margin-top": ($(window).scrollTop()) + "px"});
  }
});
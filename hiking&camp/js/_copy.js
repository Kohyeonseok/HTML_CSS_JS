$(function () {
  $("body").prepend(`<div id="container">
        <header>
        <img src="images/logo.png" id="logo">
        <a href="main.html">
            <h1 id="title">HIKING & CAMP</h1>
        </a>
        <img src="images/login.png" id="loginImg">
        </a>
        <div id="slidingShow">
            <span class="slider">HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP
                HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING
                & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP
                HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING
                & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP
                HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING
                & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP
                HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING & CAMP HIKING
                & CAMP HIKING & CAMP HIKING & CAMP </span>
           </div>
        </header>
          </div>
          <div id="sideBar">
           <ul id="sideMenu">
           <li><a href="about.html">A B O U T</a></li>
           <li><a href="hiking.html">H I K I N G</a></li>
           <li><a href="camp.html">C A M P</a></li>
           <li><a href="item.html">I T E M</a></li>
           <li><a href="market.html">M A R K E T</a></li>
           </ul>
          </div>
          <div id="logModal">
              <div class="modal-content">
                  <button class="closeBtn">X</button>
                  <div id="logInfo">
                      <h1>LOGIN</h1>
                      <input type="text" placeholder="ID" id="logID">
                      <input type="password" placeholder="PASSWORD" id="logPw">
                      <button id="logBtn">login</button><br>
                      <a href="#">forget id/pw ?</a>
                  </div>
                  <hr>
                  <div id="joinInfo">
                      <h1>JOIN</h1>
                      <input type="text" placeholder="ID" id="joinID">
                      <input type="password" placeholder="PASSWORD" id="joinPw">
                      <button id="joinBtn">join</button><br>
                  </div>
              </div>
          </div>
          


      </div>
      
      <footer>
      <div id="underBar">
          <p>The mountain is high and big. From a high place, you can see far and see everything, not just parts.</p>
      </div>
  </footer>`);
});

$(function () {
  $("#loginImg").on("click", function (event) {
    event.preventDefault(); // 이벤트 전파 중단
    $("#logModal").css("display", "block"); // 모달 창 표시
  });

  $(".closeBtn").on("click", function () {
    $("#logModal").css("display", "");
  });

  $("#logBtn").on("click", function () {
    if ($("#logID").val() == "") {
      alert("아이디를 입력하세요.");
      $("#logID").focus();
    } else if ($("#logPw").val() == "") {
      alert("비밀번호를 입력하세요.");
      $("#logPw").focus();
    } else {
      $("#logModal").css("display", "");
      $("#logID").val("");
      $("#logPw").val("");
      $("#joinID").val("");
      $("#joinPw").val("");
    }
  });

  $("#joinBtn").on("click", function () {
    if ($("#joinID").val() == "") {
      alert("아이디를 입력하세요.");
      $("#joinID").focus();
    } else if ($("#joinPw").val() == "") {
      alert("비밀번호를 입력하세요.");
      $("#joinPw").focus();
    } else {
      $("#logModal").css("display", "");
      $("#logID").val("");
      $("#logPw").val("");
      $("#joinID").val("");
      $("#joinPw").val("");
    }
  });
});

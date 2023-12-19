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
                    <a href="_copy.html">forget id/pw ?</a>
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
        <div id="review_title">
        <h2>I T E M review</h2>
        <P>아이템 추천</P>
    </div>
    <div id="review_content"  style="background-image: url('images/item.jpg'); background-size: cover; background-repeat: no-repeat;">
    <div id="review_list_wrap">
    <div class="review_list">
        <img src="https://dummyimage.com/150x150/fff/000">
        <p>제목</p>
        <p>조회수</p>
        <p>날짜</p>
    </div>
    <div class="review_list">
        <img src="https://dummyimage.com/150x150/fff/000">
        <p>제목</p>
        <p>조회수</p>
        <p>날짜</p>
    </div>
    <div class="review_list">
        <img src="https://dummyimage.com/150x150/fff/000">
        <p>제목</p>
        <p>조회수</p>
        <p>날짜</p>
    </div>
    <div class="review_list">
        <img src="https://dummyimage.com/150x150/fff/000">
        <p>제목</p>
        <p>조회수</p>
        <p>날짜</p>
    </div>
    <div class="review_list">
        <img src="https://dummyimage.com/150x150/fff/000">
        <p>제목</p>
        <p>조회수</p>
        <p>날짜</p>
    </div>
    <div class="review_list">
        <img src="https://dummyimage.com/150x150/fff/000">
        <p>제목</p>
        <p>조회수</p>
        <p>날짜</p>
    </div>
    <div class="review_list">
        <img src="https://dummyimage.com/150x150/fff/000">
        <p>제목</p>
        <p>조회수</p>
        <p>날짜</p>
    </div>
    <div class="review_list">
        <img src="https://dummyimage.com/150x150/fff/000">
        <p>제목</p>
        <p>조회수</p>
        <p>날짜</p>
    </div>
    <div class="review_list">
        <img src="https://dummyimage.com/150x150/fff/000">
        <p>제목</p>
        <p>조회수</p>
        <p>날짜</p>
    </div>
    <div class="review_list">
        <img src="https://dummyimage.com/150x150/fff/000">
        <p>제목</p>
        <p>조회수</p>
        <p>날짜</p>
    </div>
</div>
        <div id="review_control">
            <button id="prevBtn">◀</button>
            <input type="text" id="search" placeholder="찾을 내용 검색">
            <button id="submitBtn">검색</button>
            <button id="nextBtn">▶</button><br>
            <button id="writeBtn">작성</button>
            <button id="delBtn">삭제</button>
        </div>
    </div>
    <div id="addContent_modal">
        <div class="addContent_modal_header">
            <select id="category">
                <option>Hiking</option>
                <option>Camp</option>
                <option>Item</option>
                <option>Market</option>
            </select>
            <input type="text" placeholder="제목" id="addContent_modal_title">
            <button class="addContent_modal_closeBtn">X</button>
        </div>
        <div class="addContent_content">
            <button id="addContent_content_file">파일</button>
            <textarea id="addContent_content_text"></textarea>
            <button id="addContent_content_submit">작성</button>
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

  $(".review_list img").on("click", function () {
    window.location.href = "_copy.html";
  });

  $("#writeBtn").on("click", function () {
    $("#addContent_modal").css("display", "block");
  });

  $(".addContent_modal_closeBtn").on("click", function () {
    $("#addContent_modal").css("display", "none");
    $("#addContent_modal_title").val("");
    $("#addContent_content_text").val("");
  });

  $("#addContent_content_submit").on("click", function () {
    $("#addContent_modal").css("display", "none");
    $("#addContent_modal_title").val("");
    $("#addContent_content_text").val("");
  });
});

$(function () {
  $("#loginImg").on("click", function (event) {
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

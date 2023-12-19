$(function () {
  // $("#topMenu p").on("mouseover focus", function () {
  //   $(this).css("borderBottom", "2px solid white");
  // });
  // $("#topMenu p").on("mouseout focusout", function () {
  //   $(this).css("border-bottom", "");
  // });

  $("#0").on("click", function () {
    $("html, body").animate({ scrollTop: 0 }, 1000);
    $(".mainBoard").css("display", "");
  });
  $("#1").on("click", function () {
    $("html, body").animate({ scrollTop: $("#schedule").offset().top }, 1000);
    $(".mainBoard").css("display", "");
  });
  $("#2").on("click", function () {
    $("html, body").animate({ scrollTop: $("#study").offset().top }, 1000);
    $(".mainBoard").css("display", "");
  });
  $("#3").on("click", function () {
    $("html, body").animate({ scrollTop: $("#life").offset().top }, 1000);
    $(".mainBoard").css("display", "");
  });
  $("#4").on("click", function () {
    $("html, body").animate({ scrollTop: $("#comment").offset().top }, 1000);
    $(".mainBoard").css("display", "");
  });

  $("#sns img").on("mouseover focus", function () {
    $("#contacts").fadeIn(500, "linear");
    if ($(this).hasClass("phone")) {
      $("#contacts").append("<p>+82 ) 10 - 5466 - 3418</p>");
    } else if ($(this).hasClass("instagram")) {
      $("#contacts").append("<p>@ koesnuyh</p>");
    } else if ($(this).hasClass("email")) {
      $("#contacts").append("<p>kohunsuk @ gmail.com</p>");
    } else {
      $("#contacts").append("<p>github</p>");
    }
  });

  $("#sns img").on("mouseout focusout", function () {
    $("#contacts").hide();
    $("#contacts").empty();
  });

  $("#studyList p").on("click", function () {
    let index = $(this).index();
    $("#studyBoard .mainBoard").css("display", "");
    $("#studyBoard .mainBoard")
      .eq(index - 1)
      .css("display", "block");
  });

  $("#lifeList p").on("click", function () {
    let index = $(this).index();
    $("#lifeBoard .mainBoard").css("display", "");
    $("#lifeBoard .mainBoard")
      .eq(index - 1)
      .css("display", "block");
  });

  ///////////////////////////////////////

  $(".write").on("click", function () {
    let add = $(this).parent().siblings();

    $("#modal").css("display", "block");

    $(".modal-content .closeBtn").on("click", function () {
      $("#modal").css("display", "");
    });

    $("#saveBtn").one("click", function () {
      let title = $("#inputTitle").val();
      let writter = $("#writter").val();
      let content = $("#inputContent").val();
      add.append(
        `<tr><td><input type="checkbox"></td><td>${title}</td><td>${writter}</td><td class="clickContent">${content}</td></tr>`
      );
      $("#modal").css("display", "");
      $("#writter").val("");
      $("#inputTitle").val("");
      $("#inputContent").val("");
    });
  });

  $(".delete").on("click", function () {
    let del = $(this).parent().siblings().find("input:checked");
    del.parent().parent().remove();
  });

  $(document).on("mouseover focus", "td.clickContent", function () {
    $(this).css("background-color", "gray");
    $(this).css("color", "white");
  });

  $(document).on("mouseout focusout", "td.clickContent", function () {
    $(this).css("background-color", "white");
    $(this).css("color", "black");
  });

  $(document).on("click", "td.clickContent", function () {
    let content = $(this).text();
    $("#studyModal").css("display", "block");
    $("#showContent").text(content);
    $("#studyModal .closeBtn").on("click", function () {
      $("#studyModal").css("display", "");
    });
  });

  $("#comBtn").on("click", function () {
    let text = $("#commentText").val();
    let name = $("#commentName").val();
    if ($("#commentText").val() == "") {
      alert("댓글을 입력하세요.");
      $("#commentText").focus();
    } else if ($("#commentName").val() == "") {
      alert("닉네임을 입력하세요.");
      $("#commentName").focus();
    } else {
      $("#comTable").append(
        `<tr><td><p>${text}</p></td><td><p>${name}</p></td><td><button class="comDelBtn">X</button></td></tr>`
      );
      $("#commentText").val("");
      $("#commentName").val("");
    }
  });

  $(document).on("click", ".comDelBtn", function () {
    $(this).closest("tr").remove();
  });

  $(document).on("click", ".calTable td", function () {
    $("#scheduleDate").val(
      $("#subtitle").text() + "." + $("#title").text() + "." + $(this).text()
    );
  });

  $("#addSchedule").on("click", function () {
    if ($("#scheduleInfo").val() == "") {
      alert("스케줄을 입력하세요.");
      $("#scheduleInfo").focus();
    } else if ($("#scheduleDate").val() == "") {
      alert("날짜를 선택하세요.");
    } else {
      let scheduleInfo = $("#scheduleInfo").val();
      let scheduleDate = $("#scheduleDate").val();
      $("#scheduleTable").append(
        `<tr><td>${scheduleInfo}</td><td>${scheduleDate}</td><td><input type="checkbox" class="checkSchedule"></td></tr>`
      );
      $("#scheduleInfo").val("");
      $("#scheduleDate").val("");
    }
  });

  $(document).on("click", ".checkSchedule", function () {
    if ($(this).is(":checked")) {
      $(this)
        .parent()
        .parent()
        .children()
        .eq(0)
        .css("text-decoration", "line-through");
      $(this)
        .parent()
        .parent()
        .children()
        .eq(1)
        .css("text-decoration", "line-through");
    } else {
      $(this).parent().parent().children().eq(0).css("text-decoration", "");
      $(this).parent().parent().children().eq(1).css("text-decoration", "");
    }
  });

  $(document).on("click", "#delSchedule", function () {
    if ($(".checkSchedule").is(":checked")) {
      $(".checkSchedule:checked").parent().parent().remove();
    }
  });
});

const animals = ["DOG","CAT","FOX","SKUNK","RACCON","HAMSTER","KANGAROO","HORSE","CROCODILE","ELEPHANT","WHALE","DOLPHIN","SHEEP",
  "FROG","BEAR","PANDA","MOUSE","TURTLE","RABBIT","KOALAS","HIPPO","TIGER","MONKEY","ZEBRA","WOLF","CHIMPANZEE","CAMEL",
    "GOOSE","GIRAFFE","DEER","PENGUIN","DONKEY","PIG","CHICKEN","SNAKE"
];

const alphabet=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];



let answer = "";
let splitAnswer = [];
let blank = [];
let alpha = "";
let count =0;
let maxCount=10;
let counter="";
let getImg="";
let picNum=1;

function shuffle() {
    animals.sort(function () {return 0.5 - Math.random();});
    answer = animals[0];
    splitAnswer = answer.split("");
    console.log(splitAnswer);
}


function display(){
    for (let i = 0; i < splitAnswer.length; i++) {
        blank.push("_");
    }
    document.getElementById("main").innerHTML=blank.join(" ");

    for(let i=0;i<26;i++){
        if(i==13){
            alpha+='<br>'
        }
        alpha+=`<button value="${i}" onclick="result()">${alphabet[i]}</button>`;
    }


    document.getElementById("button").innerHTML=alpha;
    getImg=`<img id="imgs" src="hangman${picNum}.jpg">`;
    counter +=`<p>${count} of ${maxCount}</p>`;
    document.getElementById("hangmanImg").innerHTML=getImg;
    document.getElementById("count").innerHTML =counter;
}


function result(button) {
    const guessedLetter = alphabet[button.value];
    let correctGuess = false;
    for (let i = 0; i < splitAnswer.length; i++) {
        if (splitAnswer[i] === guessedLetter) {
            blank[i] = guessedLetter;
            correctGuess = true;
        }
    }
    if (correctGuess) {
        document.getElementById("main").innerHTML = blank.join(" ");
        if (splitAnswer.join("") == blank.join("")) {
            alert(splitAnswer.join("") + " 정답입니다.");
            if(confirm("다시하시겠습니까?")){
                reset();
            }
        }
    } else {
        count++;
        picNum++;
        document.getElementById("hangmanImg").innerHTML=`<img id="imgs" src="hangman${picNum}.jpg">`;
        document.getElementById("count").innerHTML = `${count} of ${maxCount}`;
        if (count >= maxCount) {
            alert("실패. 정답은 " + splitAnswer.join("") + " 입니다.");
            if(confirm("다시하시겠습니까?")){
                reset();
            }
        }
    }
}


function init(){
    shuffle();
    display();
    const buttons = document.querySelectorAll("button");
    buttons.forEach((button) => {
        button.addEventListener("click", () => result(button));
    });
}

function reset() {
    answer = "";
    splitAnswer = [];
    blank = [];
    alpha = "";
    count = 0;
    counter = "";
    picNum=1;

    shuffle();
    display();

    const buttons = document.querySelectorAll("button");
    buttons.forEach((button) => {
        button.addEventListener("click", () => result(button));
    });
}
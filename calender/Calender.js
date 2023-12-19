const dayOfTheWeek = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
const monthName = ["JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"];
const now = new Date();
const curDate=now.getDate();


let curYear = now.getFullYear();
let curMonth = now.getMonth();
let lastDate = getLastDateOfMonth();
let firstDayOfTheWeekInst = new Date(curYear, curMonth, 1);
let firstDayOfTheWeek = firstDayOfTheWeekInst.getDay();
let numOfWeeks = Math.ceil((firstDayOfTheWeek + lastDate) / 7);

function getLastDateOfMonth() {
  const lastDateOfMon = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
  let leapYear;

  if (curYear % 4 == 0 && curYear % 100 != 0) leapYear = true;
  else if (curYear % 400 == 0) leapYear = true;
  else leapYear = false;

  lastDateOfMon[1] = leapYear ? 29 : 28;
  return lastDateOfMon[curMonth];
}

function setCurrentMonth() {
  lastDate = getLastDateOfMonth();
  firstDayOfTheWeekInst = new Date(curYear, curMonth, 1);
  firstDayOfTheWeek = firstDayOfTheWeekInst.getDay();
  numOfWeeks = Math.ceil((firstDayOfTheWeek + lastDate) / 7);
}

function changeMonth(num) {
  curMonth += num;
  if (curMonth == -1) {
    curMonth = 11;
    curYear--;
  } else if (curMonth == 12) {
    curMonth = 0;
    curYear++;
  }
  setCurrentMonth();
  showCal();
}

function showCal() {
  let date = 1;
  let cell = 0;
  let table = "";
  table += `<table>`;
  table += `<caption>`;
  table += `<button type="button" id="prev" onclick="changeMonth(-1)">◄prev</button>
  <button type="button" id="next" onclick="changeMonth(1)">next►</button>`;
  table += `<p id="title">${monthName[curMonth]}</p><br><p id="subtitle">${curYear}</p>`;
  table += `</caption>`;

  table += `<tr>`;
  for (let i = 0; i < 7; i++) table += `<th>${dayOfTheWeek[i]}</th>`;
  table += `</tr>`;
  
  for (let i = 0; i < numOfWeeks; i++) {
    table += `<tr>`;
    for (let j = 0; j < 7; j++) {
      if (cell < firstDayOfTheWeek) table += `<td>&nbsp;</td>`;
      else if (date <= lastDate){
        if(date==curDate && curMonth==now.getMonth() && curYear==now.getFullYear()){
          table += `<td><p id="today">${date++}</p></td>`;  
        }
        else
          table += `<td>${date++}</td>`;
      }
      else 
        table += `<td>&nbsp;</td>`;
      cell++;
    }

    table += `</tr>`;
  }
  table += `</table>`;
  document.getElementById("demo").innerHTML = table;
}

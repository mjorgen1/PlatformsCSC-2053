var sol = [[0 ,7 ,0 ,2 ,3 ,8 ,0 ,0 ,0] ,
           [0 ,0 ,0 ,7 ,4 ,0 ,8 ,0 ,9] ,
           [0 ,6 ,8 ,1 ,0 ,9 ,0 ,0 ,2] ,
           [0 ,3 ,5 ,4 ,0 ,0 ,0 ,0 ,8] ,
           [6 ,0 ,7 ,8 ,0 ,2 ,5 ,0 ,1] ,
           [8 ,0 ,0 ,0 ,0 ,5 ,7 ,6 ,0] ,
           [2 ,0 ,0 ,6 ,0 ,3 ,1 ,9 ,0] ,
           [7 ,0 ,9 ,0 ,2 ,1 ,0 ,0 ,0] ,
           [0 ,0 ,0 ,9 ,7 ,4 ,0 ,8 ,0]];

var values = document.getElementById("sudokuTable").getElementsByTagName("tr");

var printBoard = function(s) {
  for(var i = 0; i < values.length; i++) { 
    var cell = values[i].getElementsByTagName("td");
    for(var j = 0; j < values.length; j++) {
      cell[j].innerHTML = (s[i][j]);
    }
  }
};
var printSolution = function(s) {
  // display the final solution, is this the same for loop as above? want to use setAttribute method.
  for(var i = 0; i < 9; i++) { 
    var cell = values[i].getElementsByTagName("td");
    for(var j = 0; j < 9; j++) {
      if(s[i][j] == sol[i][j])
        cell[j].innerHTML = (s[i][j]);
      else {
        cell[j].innerHTML = (s[i][j]);
        cell[j].style.color = "red";
      }
    }
  }
};

var solve = function(s) {
  // solve the puzzle s using a recursive depth first search
  if(solved(s)) {
    printSolution(s);
  }  
  else {
    var eRow = null;
    var eCol = null;
    var emptyFound = false;
    for(var i = 0; i < 9; i++) {
      for(var j = 0; j < 9; j++) {
        if(s[i][j] == 0) {
          eRow = i;
          eCol = j;
          emptyFound = true;
          break;
        }
      }
      if(emptyFound)
        break;
    }
    var answers = [];
    var answerIndex = -1;
    var possibleAnswers = 1;
    var answerFound = true;
    //figures out what possible actions there are for a given empty space
    while(possibleAnswers <= 9) {
      for(var c = 0; c < 9; c++) {
        if(s[eRow][c]==possibleAnswers) {
          answerFound = false;
          break;
        }
      }
      if(answerFound) {
        for(var r = 0; r < 9; r++) {
          if(s[r][eCol]==possibleAnswers) {
            answerFound = false;
            break;
          }
        }
      } 
      if(answerFound) {
        var squareNumber = squareNum(eRow, eCol);
        var startRow = 0;
        var startCol = 0;
       
        if(squareNumber == 1) {
          startRow = 0;
          startCol = 0;
        }
        else if(squareNumber == 2) {
          startRow = 0;
          startCol = 3;
        }
        else if(squareNumber == 3) {
          startRow = 0;
          startCol = 6;
        }
        else if(squareNumber == 4) {
          startRow = 3;
          startCol = 0;
        }
        else if(squareNumber == 5) {
          startRow = 3;
          startCol = 3;
        }
        else if(squareNumber == 6) {
          startRow = 3;
          startCol = 6;
        }
        else if(squareNumber == 7) {
          startRow = 6;
          startCol = 0;
        }
        else if(squareNumber == 8) {
          startRow = 6;
          startCol = 3;
        }
        else if(squareNumber == 9) {
          startRow = 6;
          startCol = 6;
        }
        for(var r = startRow; r < startRow + 3; r++) {
          for(var c = startCol; c < startCol + 3; c++) {
            if(s[r][c]==possibleAnswers) {
              answerFound = false;
              break;
            }
          }
        }
      }
      //adds the possible now ACCURATE answer to the array answers
      if(answerFound) {
        answerIndex++;
        answers[answerIndex] = possibleAnswers;
      }
      answerFound = true;
      possibleAnswers++;
    }

    //adds the new sudoku states with the new answer and recurses through
    while(answerIndex >=0) {
      var newSol = [];
      for(var i = 0; i < s.length; i++) {
        newSol[i] = s[i].slice();
      }
      newSol[eRow][eCol] = answers[answerIndex];
      solve(newSol);
      answerIndex--;
    }
  }
};
var solved = function(s) { 
  // check to see if the puzzle s is solved . Return true or false
  var total = 9+8+7+6+5+4+3+2+1;
  var countRow = 0;
  var countCol = 0;
  var sumTotal = 405;
  var countTotal = 0;

  //checks the row, column, and entire table sums
  for(var i = 0; i < 9; i++) {
    for(var j = 0; j < 9; j++) {
      countRow += s[i][j];
      countCol += s[j][i];
      countTotal += s[i][j];
    }
    if(countRow!=total && countCol!=total)
      return false;
    countRow = 0;
    countCol = 0;
  }
  //checks the entire table sum
  if(countTotal!=sumTotal)
    return false;
  return true;
};
var squareNum = function(row, col) {
  var width = 3;
  var majorRow = parseInt((row) / width, 10);
  var majorCol = parseInt((col) / width, 10);
  var answer = parseInt(((majorRow * width) + majorCol)+1, 10);
  return answer; 
};
printBoard(sol);
solve(sol);

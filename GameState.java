import java.util.*;

public class GameState{
  public int[][] state; //state of the puzzle
  public GameState parent; //parent in the game tree
  public GameState() {
    //initialize state to zeros, parent to null
    state = new int[3][3];
    for(int r = 0; r < 3; r++) {
      for(int c = 0; c < 3; c++) {
        state[r][c] = 0;  
      }  
    }
    parent = null;
  }
  public GameState(int[][] state) {
    //initialize this.state to state, parent to null
    this.state = new int[3][3];
    for(int r = 0; r < 3; r++) {
      for(int c = 0; c < 3; c++) {
        this.state[r][c] = state[r][c];
      }
    }
    this.parent = null;
  }
  public GameState(int[][] state, GameState parent) {
    //initialize this.state to state, this.parent to parent
    this.state = new int[3][3];
    for(int r = 0; r < 3; r++) {
      for(int c = 0; c < 3; c++) {
        this.state[r][c] = state[r][c];
      }
    }
    this.parent = parent;
  }
  public GameState swapRight(GameState s, int row, int col) {
    //helper function to swap blank space with right block
    int swapVal = s.state[row][col+1];
    GameState newS = new GameState(s.state, s);
    newS.state[row][col] = swapVal;
    newS.state[row][col+1] = 0;
    return newS;
  }
  public GameState swapLeft(GameState s, int row, int col) {
    //helper function to swap blank space with left block
    int swapVal = s.state[row][col-1];
    GameState newS = new GameState(s.state, s);
    newS.state[row][col] = swapVal;
    newS.state[row][col-1] = 0;
    return newS;
  }
  public GameState swapUp(GameState s, int row, int col) {
    //helper function to swap blank space with up block
    int swapVal = s.state[row-1][col];
    GameState newS = new GameState(s.state, s);
    newS.state[row][col] = swapVal;
    newS.state[row-1][col] = 0;
    return newS;
  }
  public GameState swapDown(GameState s, int row, int col) {
    //helper function to swap blank space with down block
    int swapVal = s.state[row+1][col];
    GameState newS = new GameState(s.state, s);
    newS.state[row][col] = swapVal;
    newS.state[row+1][col] = 0;
    return newS;
  }
  public boolean isEnd() {
    //helper function to check if the GameState is the end state e.g.
    //0 1 2
    //3 4 5
    //6 7 8
    int count = 0;
    for(int r = 0; r < 3; r++) {
      for(int c = 0; c < 3; c++) {
        if(this.state[r][c] != count) {
          return false;
        }
        count++;
      }
    } 
    return true;
  }
  public ArrayList<GameState> getAdjacent() {
    //Use the swap functions to generate the new vertices of the tree
    //Beware of the boundary conditions, i.e. don’t swap left when you are
    //already on the left edge
    ArrayList<GameState> adj = new ArrayList<GameState>();
    int row = 0;
    int col = 0;
    boolean left = true;
    boolean right = true;
    boolean up = true;
    boolean down = true;
    for (int r = 0; r < this.state.length; r++) {
      for (int c = 0; c < this.state.length; c++) {
        if (this.state[r][c] == 0) {
          row = r;
          col = c;
          if (row == 0) //don't swapUp
            up = false;
          if (row == 2) //don't swapDown
            down = false;
          if (col == 0) //don't swapLeft
            left = false;
          if(col == 2) //don't swapRight
            right = false;
          break; 
        }
      }
    }
    if (left) {
      adj.add(swapLeft(this, row, col));
    }
    if (right) {
      adj.add(swapRight(this, row, col));
    }
    if (up) {
      adj.add(swapUp(this, row, col));
    }
    if (down) {
      adj.add(swapDown(this, row, col));
    }
    return adj; 
  }
  @Override
  public boolean equals(Object o) {
    //test that 2 GameStates are equal
    GameState st = (GameState) o;
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        if(this.state[r][c] != st.state[r][c])
          return false;
      }
    }
    return true;
  }
  @Override
  public String toString() {
    // print out the int[][] array in a 3x3 block e.g.
    //0 1 2
    //3 4 5
    //6 7 8
    String array = "";
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        array += state[r][c];
        if(c == 2)
          array += "\n";
      }
    }
    return array;
  }
}

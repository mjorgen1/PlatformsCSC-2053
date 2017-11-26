import java.util.*;

public class Play{
  public static List<GameState> explored; //explored stores our marked vertices
  public static Deque<GameState> frontier; //frontier is our queue for BFS
  public static void main(String[] args) {
    int[][] tArr = {{1,5,2},{3,4,0},{6,8,7}}; //start state, i.e. tree root
    GameState start = new GameState(tArr,null); // state with tArr state, null parent
    explored = new ArrayList<GameState>();
    frontier = new ArrayDeque<GameState>();
    frontier.add(start);
    boolean found = false;
       
    //while loop as long as the queue is not empty and the final gamestate has yet to be found
    while (!frontier.isEmpty() && !found) { 
      GameState curr = frontier.remove();
      if(curr.isEnd() && curr != null) {  //checking to see if the front of frontier is the end
        found = true;
        explored.add(curr);
        foundAnswer(curr);
        break;
      }
      ArrayList<GameState> adj = curr.getAdjacent();  //taking in the possible GameStates
      for(GameState a : adj) {  //cycle through the arrayList of the possible GameStates
          if(!explored.contains(a) && !frontier.contains(a)) {  //we make sure it hasnt already been explored or is in frontier 
            frontier.addLast(a);  //and if not then we add it to the frontier deque
          }                       
        }
        explored.add(curr);  //if we havent found the end GameState yet, we move the front of frontier to explored
    }
  }  
  public static void foundAnswer(GameState curr) {
    while(curr != null) {  //checking to make sure the gamestate's
      System.out.println(curr.toString() + "\n");  //parents are still there, and we havent reached the begin gamestate
      curr = curr.parent;
    }
  }
}

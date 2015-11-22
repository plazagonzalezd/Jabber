import java.util.HashSet;
/**
 * This class implements a Jabber that can have a converstion about
 * the World Cup or Little red riding hood.
 * It is the top level class in this project.
 * The Jabber communicates via text input/output
 * in the text terminal.
 * 
 * This class uses an object of class InputReader to read input
 * from the user, and an object of class Responder to generate responses.
 * It contains a loop that repeatedly reads input and generates
 * output until the users wants to leave.
 * 
 * By Alex
 * June/2014
 */

public class Jabber
{
    private InputReader reader;
    private Responder responder;
    private String name;
    
    public Jabber()
    {
        reader = new InputReader();
        responder = new Responder();
        name = ""; //name provided by the user.
    }
        
    /**
     * Starts the Jabber. This will ask the user to select a conversation 
     * theme, and different dialogs will be launched depending on the user's
     * preference.
     */
    public void start()
    {
        printWelcome();
        int option = getOption();
        boolean optionGiven = false; //indicates if a valid answer has been given
        if (option == 0 && !optionGiven){
          responder.fillResponseMapLRRH();
          optionGiven = true;
          launchLRRH();
       }
       if (option == 1 && !optionGiven){
           responder.fillResponseMapWC();
           optionGiven = true;
           launchWC();
        }
       if ((option == 0 || option != 1) && !optionGiven ){
           System.out.println("Don't be stubborn, is either 0 or 1!!");
           start();
        }
    }
    
    /**
     * launches Little World Cup dialog
     */
    private void launchWC()
    {
        printAskNameWC(); 
        name = getName();
        printWelcomeWC(); 
        mainLoop();
        printGoodbye();
    }
    
    /** 
     * launches World Cup dialog
     */
    private void launchLRRH()
    {
        printAskNameLRRH();
        name = getName();
        printWelcomeLRRH();
        mainLoop();
        printGoodbye();
    }
    
    /**
     * This is the main loop that controls any of the dialogs
     */
    private void mainLoop()
    {
        int i = 1; // auxiliary variable used to alternate the place where the name is inputed
        boolean finished = false; //indicates if the conversation is over
        while(!finished) {
           HashSet<String> input = reader.getInput();
           if(input.contains(responder.getEndingString())) {
                finished = true;
             }
            else {
                String response = responder.generateResponse(input);
                if(responder.randomNameInput()){ // 30% of the responses will have the user's name inputed
                  if(i % 2 != 0){ 
                   response = name + ", " + response;
                   }
                  if(i % 2 == 0){
                  response = response + ", "+ name;
                  }
                 i++;
             }
                System.out.println(response);
           } 
        }
    }
    
    /**
     * prints the message that ask for the name in the WC system
     */
    private void printAskNameWC()
    {
       System.out.println(responder.produceAskNameWC());
    }
    
     /**
     * prints the message that ask for the name in the LRRH system
     */
    private void printAskNameLRRH()
    {
       System.out.println(responder.produceAskNameLRRH());
    }

     /**
     * prints the welcome message in the LRRH system
     */
    private void printWelcomeLRRH()
    {
        System.out.println(responder.produceWelcomeLRRH());
    }
    
     /**
     * prints the welcome message in the WC system
     */
    private void printWelcomeWC()
    {
        System.out.println(responder.produceWelcomeWC());
    }

     /**
     * prints the goodbye message
     */
    private void printGoodbye()
    {
        System.out.println(responder.produceBye());
    }
    
    /**
     * asks for, and returns the name the user.
     */
    private String getName()
    {
      name = reader.inputName();
      return name;
    }
    
    /**
     * returns the option (0 or 1) that represent the diferent systems.
     */
    private int getOption()
    {
        int option = reader.inputOption();
        return option;
    }
    
    /**
     * Prints the overall welcome message
     */
    private void printWelcome()
    {
        System.out.println(responder.produceWelcome());
    }
   
}
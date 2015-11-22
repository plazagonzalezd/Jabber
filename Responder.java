import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response, based on specified input.
 * Input is presented to the responder as a set of words, and based on those
 * words the responder will generate a String that represents the response.
 *
 * Internally, the reponder uses a HashMap to associate words with response
 * strings. If any of the input words is found in the HashMap, the corresponding response is returned. 
 * If none of the input words is recognized, a default response is returned.
 * 
 * Also, the responder uses a ArrayList to generate responses that contain
 * more than one keyword.
 * 
 * By Alex Plaza
 * June/2014
 */

public class Responder
{
    private HashMap<String, String> responseMap; // Used to map key words to responses.
    private Random randomGenerator; // Used to generate random behavior 
    private ArrayList<String> optionsMulti; //Used to generate multi-words answers.
    
    public Responder()
    {
        responseMap = new HashMap<String, String>();
        randomGenerator = new Random();
        optionsMulti = new ArrayList<String>();
    }
    
    /**
     * Generates a response from a given set of input words.
     * 
     * @param words  A set of words entered by the user
     * @return       A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> words)
    {
        ArrayList<String> options = new ArrayList<String>();
        for (String word : words) {
            String response = responseMap.get(word);
            if(response != null) {
                options.add(response);
                optionsMulti.add(word); 
            }
        }
        
        
        String multiAnswer = multipleWordAnswer(); 
        // if words that match the multi-word answers are found, then return
        // those answers, if not, continue.
        if (multiAnswer != ""){
                optionsMulti.clear();
                return multiAnswer;
            }
        optionsMulti.clear();
        // if no key words were found siplay default message.
        if(options.size() == 0){
            return "Please try to use another word or phrase";
        }
        // the randomGenerator to select one response if more than one key word was found.
        int index = randomGenerator.nextInt(options.size());
        return options.get(index);
    }
    
     /**
     * Enter all the known keywords and their associated responses
     * into the Little Red Riding Hood response map.
     */
    public void fillResponseMapLRRH()
    {
        responseMap.put("arm", 
                        "all the better to hug you with");
        responseMap.put("arms", 
                        "all the better to hug you with");
        responseMap.put("leg", 
                        "all the better to run with");
        responseMap.put("legs", 
                        "all the better to run with");
        responseMap.put("ear", 
                        "all the better to hear with");
        responseMap.put("ears", 
                        "all the better to hear with");
        responseMap.put("eye", 
                        "all the better to see with");
        responseMap.put("eyes", 
                        "all the better to see with");
        responseMap.put("teeth", 
                        "they are to eat you better! Ha, ha, ha, ha!!\n" +
                        "Narrator: Oh no, Little Red Riding Hood, you may want to yell for help");
        responseMap.put("mouth", 
                        "I't's to eat you better! Ha, ha, ha, ha!!\n" +
                        "Narrator: Oh no, Little Red Riding Hood, you may want to yell for help");
        responseMap.put("help", 
                        "you cry and cry for help! \n" +
                        "Fortunately, a woodsman hears you cry. He arrives to the scene and kills the wolf");
        responseMap.put("wolf", 
                       "you cry and cry for help! \n" +
                        "Fortunately, a woodsman hears you cry, arrives to the scene and kills the wolf");
    }
    
    /**
     * Enter all the known keywords and their associated responses
     * into the Word Cup response map.
     */
    public void fillResponseMapWC()
    {
        responseMap.put("colombia", 
                        "Colombia got 9 points in the first round, despite the fact that they \n" +
                        "haven't been in a World cup for 16 years, and Falcao is not playing!\n" +
                        "That is very imperssive");
        responseMap.put("spain", 
                        "I was appalled by Spain's performance. The world's champion did not\n"
                        + "pass to the second stage? Wow. If would divorce Piqué,\n" +
                        "if I was Shakira");
        responseMap.put("england", 
                        "In all honesty, England was one of my favorite candidates. Roney is one of my \n" +
                        "favorite players, and I would've loved to watch him play for longer" );
        responseMap.put("italy", 
                        "Marchisio's first goal was magnificent! But I can't believe Costa Rica\n" +
                        "is at the head of Italy's group. What's wrong with the Eurpean teams"  );
        responseMap.put("germany", 
                        "Müller is a God. Germany has a great chance to win the World Cup");
        responseMap.put("brazil", 
                        "although Brazil is not playing like in its Golden Era, \n" +
                        "I think they can be champions this time, especially because they are hosting");
        responseMap.put("uruguay", 
                        "watching Suarez play is enjoyable, but Urugay won't stand a \n" +
                        "chance against Colombia");
        responseMap.put("mexico", 
                        "I was not happy when I first heard that Guillermo Ochoa was going to the World Cup.\n" +
                        "But when México played against Brazil, I was happy he was elected");
        responseMap.put("us", 
                        "I still don't get Donovan's controversy; he is too old to be playing. \n" +
                        "The U.S. is doing good withour him");
        responseMap.put("usa", 
                        "I still don't get Donovan's controversy; he is too old to be playing. \n" +
                        "The U.S. is doing good withour him"); 
        responseMap.put("states", 
                        "I still don't get Donovan's controversy; he is too old to be playing. \n" +
                        "The U.S. is doing good withour him");
        responseMap.put("netherlands", 
                        "5-1 against the champions!? The Netherlands is going to make it to the \n" +
                        "final again, hopefully they'll win this time");
        responseMap.put("portugal", 
                        "watching Ronaldo play is a surreal experience. But Portugal is not that \n" +
                        "good of a team");
        responseMap.put("argentina", 
                        "so far, Argentina has only played very boring games");
        responseMap.put("win", 
                        "I think the next champion will be either Germany or Brazil");
        responseMap.put("winner", 
                        "I think the next champion will be either Germany or Brazil");
        responseMap.put("champion", 
                        "I think the next champion will be either Germany or Brazil");
    }
    
    /**
     * Returns the multi-word reponses if particular word are contain in
     * optionsMulti, or "" if none of them are found.
     * This method only works for the WC theme
     */
      public String multipleWordAnswer()
    {
        if(optionsMulti.contains("colombia") && optionsMulti.contains("uruguay")){
            return "I think Uruguay does not stand a chance against Colombia.\n" +
            "Hopefully Suarez won't bite Cuadrado, hehe";
        }
        
        if(optionsMulti.contains("germany") && (optionsMulti.contains("us") || optionsMulti.contains("usa") ||
        optionsMulti.contains("states"))){
            return "I would like to see the U.S. win. But let's be real";
        }
        
        if(optionsMulti.contains("mexico") && optionsMulti.contains("netherlands")){
            return "sadly, I don't think México will defeat the Netherlands in the next game";
        }
        
        if(optionsMulti.contains("chile") && optionsMulti.contains("brazil")){
            return "I really like to watch Alexis Sanchez play, but I think that Brazil will probably win" ;
        }
        
        if(optionsMulti.contains("spain") && optionsMulti.contains("netherlands")){
            return "what a game was that! There's no adjective to describe van Persie's header";
        }
        
        if(optionsMulti.contains("portugal") && optionsMulti.contains("germany")){
            return "I bet Cristiano was FURIOUS after that game";
        }
        
        if(optionsMulti.contains("portugal") && (optionsMulti.contains("us") || optionsMulti.contains("usa") ||
        optionsMulti.contains("states"))){
            return "that goal in the last minute was pretty frustrating";
        }
        return "";
    }
    
    /**
     * Generates random name input every 3 in 10 responses
     */
    public boolean randomNameInput()
    {
        int index = randomGenerator.nextInt(10);
        boolean test = false;
        if(index <= 2){
            test = true;
        }
        return test;
    }
    
    /**
     * Return phrase that ends the program
     */
    public String getEndingString()
    {
        return "bye";
    }
    
    /**
     * Returns String that asks name in the LRRH system
     */
    public String produceAskNameLRRH()
    {
        String askName;
        askName = "Narrator: Hello, Little Red Ridding Hood, what do you like to be called?\n" +
        "Try something like: sweety, honey or dear.";
        return askName;
    }
    
    /**
     * Returns the String of the welcome message of the LRRH system
     */
    public String produceWelcomeLRRH()
    {
        String welcome;
        welcome = " Narrator: You are at Grandma's and you are greatly amazed to see \n" +
        "   how your grandmother looks in her nightclothes.\n" + 
        "   Why don't you ask her questions about her odd appearance? \n" +
        "   Or tell her 'bye' if you don't want to talk to her";
        return welcome;
    }
    
    /**
     * Returns the welcome message of the overrall system
     */
    public String produceWelcome()
    {
        String welcome = "Please choose one of the following systems:\n" +
                 "0. Little Red Riding Hood\n" +
                 "1. World Cup 2014";
        return welcome;
    }
    
    /**
     * returns the string that ask the name in the world cup system
     */
    public String produceAskNameWC()
    {
        String askName = "Hi, what's your name?";
        return askName;
    }
    
    /**
     * returns the welcome message for the wc system
     */
    public String produceWelcomeWC()
    {
        String welcome = "Ask me questions about the world cup! ";
        return welcome;
    }
    
    /**
     * returns the exit message
     */
    public String produceBye()
    {
        String bye = "You are a boring fellow :(";
        return bye;
    }
}

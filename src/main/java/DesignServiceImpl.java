import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

interface DesignService {

    String createDesign(AuthContext ctx, String designContent);


    String getDesign(AuthContext ctx, String designId);
}

public class DesignServiceImpl implements DesignService {

    //<userid,Map<designid,designcontent> => <userid, designMapping>
    Map<String, Map<String,String>> userDesignMapping = new HashMap<String, Map<String,String>>();

    Map<String, String> designMapping = new HashMap<String, String>();

    /** Creates a design and returns the design id. */
    @Override
    public String createDesign(AuthContext ctx, String designContent) {
        String user = ctx.userId;
        String designId = UUID.randomUUID().toString();
        designMapping.put(designId,designContent);

        userDesignMapping.put(user,designMapping);

        return designId;
    }

    /** Returns the design content, if the user has access to the design. */
    @Override
    public String getDesign(AuthContext ctx, String designId) {
        Map<String, String> designMap = userDesignMapping.get(ctx.userId);
        if(designMap == null){
            throw new RuntimeException("User not found");
        }

        String content = designMap.get(designId);
        if(content == null){
            throw new RuntimeException("No associated design for this is.");
        }
        return content;
    }

    public static void main(String[] args) {
        DesignServiceImpl testSubject = new DesignServiceImpl();
        AuthContext contextOne = new AuthContext("user1");


        String designId = testSubject.createDesign(contextOne, "SomeContent");
        String retrievedContent = testSubject.getDesign(contextOne, designId);
       //System.out.println(retrievedContent.equals("SomeContent"));

        AuthContext contextTwo = new AuthContext("user2");
        String designIdTwo = testSubject.createDesign(contextTwo, "SomeContentTwo");
//       try{
////           testSubject.getDesign(contextTwo,"1");
////       }catch (Exception e){
////           System.out.println(e.getMessage().equals("User not found"));
////       }


          //  String content = testSubject.getDesign(contextOne,"1");
       try{
           System.out.println( " Executing Context Two for designId");
           String content = testSubject.getDesign(contextTwo, designId);
           System.out.println("Content "+ content);
       }catch (Exception e){
           System.out.println("Exception " + e.getMessage());
           System.out.println(e.getMessage().equals("No associated design for this is."));
       }


    }
}

//
// user1
//map<String, String> = <useriD,mAP<DESIGNID,designContent>>

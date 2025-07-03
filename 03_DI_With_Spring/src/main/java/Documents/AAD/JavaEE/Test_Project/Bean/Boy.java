package Documents.AAD.JavaEE.Test_Project.Bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Boy {

    @Autowired
    @Qualifier("girl2")
    Agreement girl;

    public  Boy() {
        System.out.println("Boy Constructor Called");
    }
    public void chatwithgirl() {
        girl.Chat();
    }


}

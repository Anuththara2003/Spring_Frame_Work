package Documents.AAD.JavaEE.Test_Project.Bean;

import org.springframework.stereotype.Component;

@Component
public class Girl2 implements Agreement {
    @Override
    public void Chat() {
        System.out.println("Chatting with Girl2");
    }
}

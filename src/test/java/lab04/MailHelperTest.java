package lab04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MailHelperTest {

    String to = "To";
    String body = "body";
    String subject = "subject";
    public Mail mail;

    @BeforeEach
    public void setMailHelper() {
        MailHelper mailHelper = new MailHelper();
        mailHelper.createAndSendMail(to,subject,body);
        mail = mailHelper.getMail();
    }

    @Test
    public void setTo_toIsSet_returnsTo() {
        Assertions.assertEquals(to,mail.getTo());
    }

}

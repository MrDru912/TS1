package lab05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class MockMailHelperTest {

    DBManager mockDBManager = Mockito.mock(DBManager.class);
    MailHelper mailHelper = new MailHelper(mockDBManager);

    @Test
    public void negativeVerifySendMailVerifyTest(){
        //mailHelper.sendMail(Mockito.anyInt());

        Mockito.verify(mockDBManager, times(0)).findMail(Mockito.anyInt());

    }
    @Test
    public void positiveVerifySendMailOnceTest() {
        mailHelper.sendMail(Mockito.anyInt());
        Mockito.verify(mockDBManager, times(1)).findMail(Mockito.anyInt());
    }

    @Test
    public void mockTest(){
        int mailID = 1;
        Mail mail = getMail();
        Mockito.when(mockDBManager.findMail(mailID)).thenReturn(mail);
        mailHelper.sendMail(Mockito.anyInt());
        Mockito.verify(mockDBManager).findMail(Mockito.anyInt());

    }

    @Test
    public void checkMailCorrectTo(){
        int mailID = Mockito.anyInt();
        Mockito.when(mockDBManager.findMail(mailID)).thenReturn(getMail());
        mailHelper.sendMail(mailID);
        Assertions.assertEquals("ABCD", mailHelper.getMail().getTo());
    }

    private Mail getMail() {
        Mail mail = new Mail();
        mail.setTo("ABCD");
        mail.setSubject("BODY");
        mail.setBody("SUBJECT");
        return mail;
    }
}

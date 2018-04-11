import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;


public class Test_Web_service {

    Web_service service = mock(Web_service.class);//конструктор и мокито

    @Test
    public void getUserEmailPositive(){
    when(service.getUserEmail(1)).thenReturn("sample@mail.com");//имитируем работу сервиса, что сообщили и что должен вернуть
    assertEquals(service.getUserEmail(1), "sample@mail.com");//ну и проверяем
    }
    @Test
    public void getUserEmailNegative(){
        when(service.getUserEmail(1)).thenReturn("sample@mail.com");
        assertNotEquals(service.getUserEmail(1), "mymale@mail.com");
    }
    @Test
    public void getCurrentUrlPositive(){

        when(service.getCurrentUrl()).thenReturn("https://sample.url.com");
        assertEquals(service.getCurrentUrl(), "https://sample.url.com");
    }
    @Test
    public void getCurrentUrlNegative(){
        when(service.getCurrentUrl()).thenReturn("https://sample.url.com");
        assertNotEquals(service.getCurrentUrl(), "https://sample.Fakeurl.com");
    }
    @Test
    public void isRegisteredUserPositive(){
        when(service.isRegisteredUser("sample@mail.com")).thenReturn(true);
        assertEquals(service.isRegisteredUser("sample@mail.com"), true);

    }
    @Test
    public void isRegisteredUserNegative(){
        when(service.isRegisteredUser("sample@mail.com")).thenReturn(true);
        assertEquals(service.isRegisteredUser("samplefake@mail.com"), false);

    }

}

package pl.dziedziul.mockito.jpms.example;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class MockitoJpmsTest {

    @Test
    public void testWithSpy() {
        File file = spy(new File("testFile"));
        when(file.setLastModified(anyLong())).thenReturn(false);

        assertFalse(file.setLastModified(123L));
    }

    @Test
    public void testWithMock() {
        File file = mock(File.class);
        when(file.setLastModified(anyLong())).thenReturn(false);

        assertFalse(file.setLastModified(123L));
    }

    @Test
    public void testWithoutMockito() {
        File file = new File("testFile") {
            @Override
            public boolean setLastModified(long time) {
                return false;
            }
        };
        assertFalse(file.setLastModified(123L));
    }

}

package com.qoomon.mockito;

import static org.mockito.Mockito.mock;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.qoomon.mockito.MockCollector;


//@RunWith(MockitoJUnitRunner.class)
public class MockCollectorTest {

  

  private final MockCollector mocksCollector = new MockCollector();

  @After
  public void after() {
    Mockito.verifyNoMoreInteractions(this.mocksCollector.getMockArray());
  }



  @Test
  public void collecting() {



    final Object a1 = mock(Object.class);
    Assert.assertEquals("wrong amount of mocks", 1, this.mocksCollector.getMockList().size());
    Assert.assertTrue(this.mocksCollector.getMockList().contains(a1));
    final Object a2 = mock(Object.class);
    Assert.assertEquals("wrong amount of mocks", 2, this.mocksCollector.getMockList().size());
    Assert.assertTrue(this.mocksCollector.getMockList().contains(a2));
    final Object a3 = mock(Object.class);
    Assert.assertEquals("wrong amount of mocks", 3, this.mocksCollector.getMockList().size());
    Assert.assertTrue(this.mocksCollector.getMockList().contains(a3));

    this.mocksCollector.getMockArray();

  }



}

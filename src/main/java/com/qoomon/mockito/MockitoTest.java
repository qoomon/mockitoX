package com.qoomon.mockito;

import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MockitoTest {

  private final MockCollector mocksCollector = new MockCollector();

  @Before
  public final void initMocks() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @After
  public final void verifyNoMoreInteractions() {
    Mockito.verifyNoMoreInteractions(this.mocksCollector.getMockArray());
  }

}

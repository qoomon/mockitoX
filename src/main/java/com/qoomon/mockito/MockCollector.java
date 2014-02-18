package com.qoomon.mockito;

import java.util.LinkedList;
import java.util.List;

import org.mockito.internal.listeners.CollectCreatedMocks;
import org.mockito.internal.progress.MockingProgress;
import org.mockito.internal.progress.ThreadSafeMockingProgress;

public class MockCollector {
  private final List<Object> mockList = new LinkedList<Object>();


  public MockCollector() {
    final MockingProgress progress = new ThreadSafeMockingProgress();
    final CollectCreatedMocks listener = new CollectCreatedMocks(this.mockList);
    progress.setListener(listener);
  }

  public List<Object> getMockList() {
    return this.mockList;
  }

  public Object[] getMockArray() {
    return this.mockList.toArray();
  }
}
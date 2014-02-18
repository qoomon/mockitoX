package com.qoomon.mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class MultiAnswer<T> implements Answer<T>
{

    private final Queue<T> answerQueue = new LinkedList<T>();
    private T              lastAnswer;




    public MultiAnswer(final Collection<T> answers)
    {
        for (final T answer : answers)
        {
            this.answerQueue.add(answer);
            this.lastAnswer = answer;
        }
    }




    public MultiAnswer(final T... answers)
    {
        this(Arrays.asList(answers));
    }




    @Override
    public synchronized T answer(final InvocationOnMock invocation) throws Throwable
    {

        if (this.answerQueue.isEmpty())
        {
            return this.lastAnswer;
        }
        return this.answerQueue.poll();
    }
}

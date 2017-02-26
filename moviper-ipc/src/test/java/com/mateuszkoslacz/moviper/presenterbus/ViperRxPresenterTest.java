package com.mateuszkoslacz.moviper.presenterbus;

import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor;
import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.moviper.presenterbus.presentertest.CustomPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by bwilk on 12/20/16.
 */

public class ViperRxPresenterTest {

    @Mock
    BaseRxRouting mBaseRxRouting;

    @Mock
    BaseRxInteractor mBaseRxInteractor;

    @InjectMocks
    CustomPresenter mPresenter = new CustomPresenter();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void cleanUp() {
        Moviper.getInstance().unregister(mPresenter);
    }

    @Test
    public void routingShouldAttachOnPresenterAttach() {
        mPresenter.attachView(Mockito.any());
        Mockito.verify(mBaseRxRouting).attach(Mockito.any());
    }

    @Test
    public void routingShouldDetachOnPresenterDetach() {
        mPresenter.detachView(false);
        Mockito.verify(mBaseRxRouting).detach(false);
    }

    @Test
    public void routingShouldNotBeAttachedBeforePresenterAttach() {
        Mockito.verify(mBaseRxRouting, Mockito.never()).attach(Mockito.any());
    }

    @Test
    public void routingShouldNotBeDetachedBeforePresenterDetach() {
        Mockito.verify(mBaseRxRouting, Mockito.never()).detach(false);
    }

    @Test
    public void interactorShouldAttachAfterPresenterAttach() {
        mPresenter.attachView(Mockito.any());
        Mockito.verify(mBaseRxInteractor).attach();
    }

    @Test
    public void interactorShouldDetachOnPresenterDetach() {
        mPresenter.detachView(false);
        Mockito.verify(mBaseRxInteractor).detach(false);
    }

    @Test
    public void interactorShouldNotBeAttachedBeforePresenterAttach() {
        Mockito.verify(mBaseRxInteractor, Mockito.never()).attach();
    }

    @Test
    public void interactorShouldNotBeDetachedBeforePresenterDetach() {
        Mockito.verify(mBaseRxInteractor, Mockito.never()).detach(false);
    }
}

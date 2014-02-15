package com.vaadin.demo.dashboard.scrolling;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vaadin.ui.Table;

public class ScrollingTable extends Table {

	private static final long serialVersionUID = 5007124121625961567L;
	List<ScrollingTableScrollListener> listeners = new ArrayList<ScrollingTableScrollListener>();
	
	private void fireSrollEvent() {
		for (ScrollingTableScrollListener listener : listeners) {
			listener.doTableScroll();
		}
	}
	
	public void addScrollListener(ScrollingTableScrollListener listener) {
        listeners.add(listener);
    }
	
	@Override
	public void changeVariables(Object source, Map<String, Object> variables) {
		super.changeVariables(source, variables);
		fireSrollEvent();
	}
}

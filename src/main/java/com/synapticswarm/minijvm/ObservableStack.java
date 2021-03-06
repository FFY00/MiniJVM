package com.synapticswarm.minijvm;

import java.util.ArrayDeque;
import java.util.Deque;

import com.synapticswarm.minijvm.ui.StackDisplayName;
import com.synapticswarm.minijvm.ui.SystemOutCapturePrintStream;
import javafx.collections.ObservableList;

import com.synapticswarm.minijvm.ui.model.StackEntryDisplayModel;


/**
 * Let's our UI show changes to the stack as the miniJVM executes.
 * 
 */
public class ObservableStack implements MiniStack {
	private ObservableList <StackEntryDisplayModel> observableList;
	private Deque<Object> stack = new ArrayDeque <Object> ();
	
	public ObservableStack(ObservableList <StackEntryDisplayModel> observableList){
		this.observableList = observableList;
	}
	
	@Override
	public void push(Object o) {
		stack.push(o);
		observableList.add(new StackEntryDisplayModel(o.toString(), o instanceof StackDisplayName ? ((StackDisplayName)o).getName() : o.getClass().getSimpleName()));
	}

	@Override
	public Object pop() {
		observableList.remove(0);
		return stack.pop();
	}

}

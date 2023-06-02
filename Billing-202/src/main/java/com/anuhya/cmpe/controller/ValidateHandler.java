package com.anuhya.cmpe.controller;

import java.util.List;

import com.anuhya.cmpe.model.Request;

public abstract class ValidateHandler {

	public abstract void nextHandler(ValidateHandler next);
	public abstract void handle(List<Request> orders);
	
}

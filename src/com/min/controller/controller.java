package com.min.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface controller {
	void execute(HttpServletRequest req, HttpServletResponse resp);
}

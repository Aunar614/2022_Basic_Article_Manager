package com.KoreaIT.java.BAM.controller;

import java.util.Scanner;

import com.KoreaIT.java.BAM.container.Container;
import com.KoreaIT.java.BAM.service.ExportService;

public class ExportController extends Controller {
	private Scanner sc;
	private String command;
	private String actionMethodName;
	private ExportService exportService;

	public ExportController(Scanner ac) {
		this.sc = sc;

		exportService = Container.exportService;
	}

	public void doAction(String command, String actionMethodName) {
		this.command = command;
		this.actionMethodName = actionMethodName;

		switch (actionMethodName) {
		case "html":
			doHtml();
			break;
		default:
			System.out.println("존재하지 않는 명령어 입니다");
			break;
		}
	}
	
	private void doHtml() {
		System.out.println("== html 생성을 시작합니다 ==");
		exportService.makeHtml();
	}

	@Override
	public void makeTestData() {
		
	}
	
}

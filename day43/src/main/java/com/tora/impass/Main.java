package com.tora.impass;

class MyApp {
	public static Integer LOGIN_RETRIES = 3;
	private LoginController ctrl;
	private static MyApp instance = new MyApp(LoginController.getInstance());

	public MyApp(LoginController controller) {
		this.ctrl = controller;
	}

	public void run() {
		ctrl.login();
	}

	public static MyApp getInstance() {
		return instance;
	}
}

class LoginController {

	private static LoginController instance;
	private Integer loginRetries;

	static {
		instance = new LoginController(MyApp.LOGIN_RETRIES);
	}

	private LoginController(Integer retries) {
		this.loginRetries = retries;
	}

	public static LoginController getInstance() {
		return instance;
	}

	public void login() {
		System.out.println("Logging in...");
	}

	public Integer getLoginRetries() {
		return loginRetries;
	}
}

public final class Main {
	public static void main(String[] args) {
		// some thread starts running app, eg SwingThread
		new Thread(new Runnable() {
			@Override
			public void run() {
				MyApp.getInstance().run();
			}
		}).start();

		// main thread
		LoginController.getInstance().getLoginRetries();
	}
}
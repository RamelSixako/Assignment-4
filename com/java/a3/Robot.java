package com.java.a3;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CountDownLatch;

public class Robot extends Thread {

	private String name;
	private CountDownLatch latch;
	private LocalTime startTime;
	private int units;

	/**
	 * @param name
	 */
	public Robot(String name, CountDownLatch latch, LocalTime startTime, int units) {
		super();
		setName(name);
		this.latch = latch;
		this.startTime = startTime;
		this.units = units;
	}

	@Override
	public void run() {
		latch.countDown();
		// CODE HERE
		int currentLength = 0;
		while (currentLength < this.units) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int speed = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
			currentLength += speed;
		}
		// finding the time after the operation is executed
		LocalTime finish = LocalTime.now();
		float timeElapsed = Duration.between(this.startTime, finish).toSeconds();
		System.out.println(Thread.currentThread().getName() + " finished at " + timeElapsed + " seconds");
	}

}

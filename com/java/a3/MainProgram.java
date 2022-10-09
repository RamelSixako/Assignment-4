package com.java.a3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class MainProgram {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("======================Welcome to the Robot race=========================");
			System.out.print("Enter the number of robots you want to have in the race:....");
			int numberOfRobots = scanner.nextInt();
			System.out.print("Enter the number of units (must be whole number) the race should cover:....");
			int units = scanner.nextInt();
			CountDownLatch latch = new CountDownLatch(numberOfRobots);
			LocalTime start = LocalTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
			System.out.println("The race will start at " + start.format(dtf));
			ArrayList<Robot> robots = new ArrayList<Robot>();
			for (int i = 1; i <= numberOfRobots; i++) {
				robots.add(new Robot("Robot" + i, latch, start, units));
			}
			for (Robot robot : robots) {
				robot.start();
			}
			latch.await();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

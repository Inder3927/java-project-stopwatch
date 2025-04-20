# ⏱ Java Stopwatch Applet

A simple yet functional stopwatch application built using **Java Applet** and **AWT (Abstract Window Toolkit)**. This project demonstrates core concepts of Java GUI development, event handling, multithreading, and object-oriented programming.

---

## 📋 Project Information

- **Program Name:** BSC CS  
- **Subject Name / Code:** Java Programming (22SCP-352)  
- **Student:** Inderjeet Singh  
- **UID:** 22BSC10128  
- **Section:** 22BSC-2A  
- **Instructor:** Jitendra Kumar (Asst. Prof)

---

## 📖 Abstract

This project aims to develop a stopwatch application with the following core functionalities:

- Start
- Stop
- Reset
- Lap recording

The application updates in real-time using Java’s multithreading capabilities and displays time in the format: **HH:MM:SS.ms**. Built with AWT components and an Applet interface, it showcases object-oriented design principles, event-driven programming, and basic graphics rendering. Although Java Applets are deprecated in modern environments, this project serves as a hands-on demonstration of foundational Java GUI development.

---

## 🧠 Introduction

Java is a platform-independent, object-oriented programming language with strong GUI capabilities via AWT and Swing. This stopwatch project utilizes **AWT** components and **Java Applet** to simulate a real-time stopwatch that can run in an applet viewer. Key features:

- Interactive interface using AWT
- Real-time updates via multithreading
- Dynamic lap tracking using ArrayList
- Time formatting with millisecond precision

Despite the outdated nature of applets, this project provides a strong learning base for Java GUI concepts.

---

## ⚙️ Techniques Used

1. **Applet Programming**  
   Lifecycle methods: `init()`, `start()`, `stop()`, `paint()`.

2. **AWT GUI Components**  
   `Button`, `Panel`, `FlowLayout`, `BorderLayout`.

3. **Event Handling**  
   Implements `ActionListener` to respond to button clicks.

4. **Multithreading**  
   Background thread refreshes display every 10 milliseconds.

5. **Graphics Rendering**  
   Uses `Graphics` class to draw current time and lap data.

6. **Data Structures**  
   Lap times are stored in an `ArrayList<Long>`.

7. **Time Management**  
   Uses `System.currentTimeMillis()` and custom formatting to display elapsed time.

8. **Object-Oriented Programming Principles**  
   - **Encapsulation**
   - **Modularity**
   - **Reusability**

---

## 💻 Code Overview

The core logic resides in the `StopwatchApplet` class, which:
- Implements `Runnable` and `ActionListener`
- Manages stopwatch state and timing
- Draws the UI dynamically
- Handles all user interactions

### Key Features:
```java
startButton.addActionListener(this);
stopButton.addActionListener(this);
resetButton.addActionListener(this);
lapButton.addActionListener(this);


✅ Functionalities & Results

Function	Status	Description
Start	✅	Starts or resumes the stopwatch.
Stop	✅	Pauses the stopwatch and holds time.
Reset	✅	Resets time and clears lap history.
Lap	✅	Records the current time as a lap.
Real-Time	✅	Timer updates every 10ms via a background thread.
UI	✅	Time and lap data rendered dynamically.
📊 Performance Evaluation
Accuracy: Updates every 10 milliseconds

Responsiveness: Instant button feedback

Usability: Clean layout and easy interaction

Data Handling: Correct use of collections for lap tracking

✅ Key Strengths:
Accurate time tracking

Clean and minimal interface

Effective use of Java’s multithreading

Proper formatting and display of lap data

⚠️ Limitations:
Applets are deprecated and unsupported by modern browsers.

Fixed-size layout; lacks responsive design.

No audio or notifications on actions.

🧾 Summary
This stopwatch project provides a functional demonstration of:

Java Applet lifecycle management

GUI development with AWT

Real-time threading

Data structure usage (ArrayList)

Graphics rendering

Event-driven interaction

Though applets are outdated, this project offers a strong foundation in Java programming and GUI development, and lays the groundwork for future enhancements using modern frameworks like Swing or JavaFX.

🚀 Future Enhancements
Migrate to JavaFX or Swing for modern UI support

Add sound notifications

Implement save/export feature for lap data

Make layout responsive for different screen sizes
